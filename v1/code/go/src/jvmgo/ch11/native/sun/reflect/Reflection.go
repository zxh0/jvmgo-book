package reflect

import "jvmgo/ch11/native"
import "jvmgo/ch11/rtda"
import "jvmgo/ch11/rtda/heap"

func init() {
	native.Register("sun/reflect/Reflection", "getCallerClass", "()Ljava/lang/Class;", getCallerClass)
	native.Register("sun/reflect/Reflection", "getClassAccessFlags", "(Ljava/lang/Class;)I", getClassAccessFlags)

}

// public static native Class<?> getCallerClass();
// ()Ljava/lang/Class;
func getCallerClass(frame *rtda.Frame) {
	// top0 is sun/reflect/Reflection
	// top1 is the caller of getCallerClass()
	// top2 is the caller of method
	callerFrame := frame.Thread().GetFrames()[2] // todo
	callerClass := callerFrame.Method().Class().JClass()
	frame.OperandStack().PushRef(callerClass)
}

// public static native int getClassAccessFlags(Class<?> type);
// (Ljava/lang/Class;)I
func getClassAccessFlags(frame *rtda.Frame) {
	vars := frame.LocalVars()
	_type := vars.GetRef(0)

	goClass := _type.Extra().(*heap.Class)
	flags := goClass.AccessFlags()

	stack := frame.OperandStack()
	stack.PushInt(int32(flags))
}
