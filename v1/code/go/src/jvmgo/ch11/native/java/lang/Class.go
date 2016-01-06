package lang

import "strings"
import "jvmgo/ch11/instructions/base"
import "jvmgo/ch11/native"
import "jvmgo/ch11/rtda"
import "jvmgo/ch11/rtda/heap"

const jlClass = "java/lang/Class"

func init() {
	native.Register(jlClass, "getPrimitiveClass", "(Ljava/lang/String;)Ljava/lang/Class;", getPrimitiveClass)
	native.Register(jlClass, "getName0", "()Ljava/lang/String;", getName0)
	native.Register(jlClass, "desiredAssertionStatus0", "(Ljava/lang/Class;)Z", desiredAssertionStatus0)
	native.Register(jlClass, "isInterface", "()Z", isInterface)
	native.Register(jlClass, "isPrimitive", "()Z", isPrimitive)
	native.Register(jlClass, "getDeclaredFields0", "(Z)[Ljava/lang/reflect/Field;", getDeclaredFields0)
	native.Register(jlClass, "forName0", "(Ljava/lang/String;ZLjava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Class;", forName0)
	native.Register(jlClass, "getDeclaredConstructors0", "(Z)[Ljava/lang/reflect/Constructor;", getDeclaredConstructors0)
	native.Register(jlClass, "getModifiers", "()I", getModifiers)
	native.Register(jlClass, "getSuperclass", "()Ljava/lang/Class;", getSuperclass)
	native.Register(jlClass, "getInterfaces0", "()[Ljava/lang/Class;", getInterfaces0)
	native.Register(jlClass, "isArray", "()Z", isArray)
	native.Register(jlClass, "getDeclaredMethods0", "(Z)[Ljava/lang/reflect/Method;", getDeclaredMethods0)
	native.Register(jlClass, "getComponentType", "()Ljava/lang/Class;", getComponentType)
	native.Register(jlClass, "isAssignableFrom", "(Ljava/lang/Class;)Z", isAssignableFrom)
}

// static native Class<?> getPrimitiveClass(String name);
// (Ljava/lang/String;)Ljava/lang/Class;
func getPrimitiveClass(frame *rtda.Frame) {
	nameObj := frame.LocalVars().GetRef(0)
	name := heap.GoString(nameObj)

	loader := frame.Method().Class().Loader()
	class := loader.LoadClass(name).JClass()

	frame.OperandStack().PushRef(class)
}

// private native String getName0();
// ()Ljava/lang/String;
func getName0(frame *rtda.Frame) {
	this := frame.LocalVars().GetThis()
	class := this.Extra().(*heap.Class)

	name := class.JavaName()
	nameObj := heap.JString(class.Loader(), name)

	frame.OperandStack().PushRef(nameObj)
}

// private static native boolean desiredAssertionStatus0(Class<?> clazz);
// (Ljava/lang/Class;)Z
func desiredAssertionStatus0(frame *rtda.Frame) {
	// todo
	frame.OperandStack().PushBoolean(false)
}

// public native boolean isInterface();
// ()Z
func isInterface(frame *rtda.Frame) {
	vars := frame.LocalVars()
	this := vars.GetThis()
	class := this.Extra().(*heap.Class)

	stack := frame.OperandStack()
	stack.PushBoolean(class.IsInterface())
}

// public native boolean isPrimitive();
// ()Z
func isPrimitive(frame *rtda.Frame) {
	vars := frame.LocalVars()
	this := vars.GetThis()
	class := this.Extra().(*heap.Class)

	stack := frame.OperandStack()
	stack.PushBoolean(class.IsPrimitive())
}

// private static native Class<?> forName0(String name, boolean initialize,
//                                         ClassLoader loader,
//                                         Class<?> caller)
//     throws ClassNotFoundException;
// (Ljava/lang/String;ZLjava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Class;
func forName0(frame *rtda.Frame) {
	vars := frame.LocalVars()
	jName := vars.GetRef(0)
	initialize := vars.GetBoolean(1)
	//jLoader := vars.GetRef(2)

	goName := heap.GoString(jName)
	goName = strings.Replace(goName, ".", "/", -1)
	goClass := frame.Method().Class().Loader().LoadClass(goName)
	jClass := goClass.JClass()

	if initialize && !goClass.InitStarted() {
		// undo forName0
		thread := frame.Thread()
		frame.SetNextPC(thread.PC())
		// init class
		base.InitClass(thread, goClass)
	} else {
		stack := frame.OperandStack()
		stack.PushRef(jClass)
	}
}

// public native int getModifiers();
// ()I
func getModifiers(frame *rtda.Frame) {
	vars := frame.LocalVars()
	this := vars.GetThis()
	class := this.Extra().(*heap.Class)
	modifiers := class.AccessFlags()

	stack := frame.OperandStack()
	stack.PushInt(int32(modifiers))
}

// public native Class<? super T> getSuperclass();
// ()Ljava/lang/Class;
func getSuperclass(frame *rtda.Frame) {
	vars := frame.LocalVars()
	this := vars.GetThis()
	class := this.Extra().(*heap.Class)
	superClass := class.SuperClass()

	stack := frame.OperandStack()
	if superClass != nil {
		stack.PushRef(superClass.JClass())
	} else {
		stack.PushRef(nil)
	}
}

// private native Class<?>[] getInterfaces0();
// ()[Ljava/lang/Class;
func getInterfaces0(frame *rtda.Frame) {
	vars := frame.LocalVars()
	this := vars.GetThis()
	class := this.Extra().(*heap.Class)
	interfaces := class.Interfaces()
	classArr := toClassArr(class.Loader(), interfaces)

	stack := frame.OperandStack()
	stack.PushRef(classArr)
}

// public native boolean isArray();
// ()Z
func isArray(frame *rtda.Frame) {
	vars := frame.LocalVars()
	this := vars.GetThis()
	class := this.Extra().(*heap.Class)
	stack := frame.OperandStack()
	stack.PushBoolean(class.IsArray())
}

// public native Class<?> getComponentType();
// ()Ljava/lang/Class;
func getComponentType(frame *rtda.Frame) {
	vars := frame.LocalVars()
	this := vars.GetThis()
	class := this.Extra().(*heap.Class)
	componentClass := class.ComponentClass()
	componentClassObj := componentClass.JClass()

	stack := frame.OperandStack()
	stack.PushRef(componentClassObj)
}

// public native boolean isAssignableFrom(Class<?> cls);
// (Ljava/lang/Class;)Z
func isAssignableFrom(frame *rtda.Frame) {
	vars := frame.LocalVars()
	this := vars.GetThis()
	cls := vars.GetRef(1)

	thisClass := this.Extra().(*heap.Class)
	clsClass := cls.Extra().(*heap.Class)
	ok := thisClass.IsAssignableFrom(clsClass)

	stack := frame.OperandStack()
	stack.PushBoolean(ok)
}
