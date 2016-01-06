package lang

import "jvmgo/ch11/instructions/base"
import "jvmgo/ch11/rtda"
import "jvmgo/ch11/rtda/heap"

/*
Constructor(Class<T> declaringClass,
            Class<?>[] parameterTypes,
            Class<?>[] checkedExceptions,
            int modifiers,
            int slot,
            String signature,
            byte[] annotations,
            byte[] parameterAnnotations)
}
*/
const _constructorConstructorDescriptor = "" +
	"(Ljava/lang/Class;" +
	"[Ljava/lang/Class;" +
	"[Ljava/lang/Class;" +
	"II" +
	"Ljava/lang/String;" +
	"[B[B)V"

// private native Constructor<T>[] getDeclaredConstructors0(boolean publicOnly);
// (Z)[Ljava/lang/reflect/Constructor;
func getDeclaredConstructors0(frame *rtda.Frame) {
	vars := frame.LocalVars()
	classObj := vars.GetThis()
	publicOnly := vars.GetBoolean(1)

	class := classObj.Extra().(*heap.Class)
	constructors := class.GetConstructors(publicOnly)
	constructorCount := uint(len(constructors))

	classLoader := frame.Method().Class().Loader()
	constructorClass := classLoader.LoadClass("java/lang/reflect/Constructor")
	constructorArr := constructorClass.ArrayClass().NewArray(constructorCount)

	stack := frame.OperandStack()
	stack.PushRef(constructorArr)

	if constructorCount > 0 {
		thread := frame.Thread()
		constructorObjs := constructorArr.Refs()
		constructorInitMethod := constructorClass.GetConstructor(_constructorConstructorDescriptor)
		for i, constructor := range constructors {
			constructorObj := constructorClass.NewObject()
			constructorObj.SetExtra(constructor)
			constructorObjs[i] = constructorObj

			ops := rtda.NewOperandStack(9)
			ops.PushRef(constructorObj)                                                // this
			ops.PushRef(classObj)                                                      // declaringClass
			ops.PushRef(toClassArr(classLoader, constructor.ParameterTypes()))         // parameterTypes
			ops.PushRef(toClassArr(classLoader, constructor.ExceptionTypes()))         // checkedExceptions
			ops.PushInt(int32(constructor.AccessFlags()))                              // modifiers
			ops.PushInt(int32(0))                                                      // todo slot
			ops.PushRef(getSignatureStr(classLoader, constructor.Signature()))         // signature
			ops.PushRef(toByteArr(classLoader, constructor.AnnotationData()))          // annotations
			ops.PushRef(toByteArr(classLoader, constructor.ParameterAnnotationData())) // parameterAnnotations

			shimFrame := rtda.NewShimFrame(thread, ops)
			thread.PushFrame(shimFrame)

			// init constructorObj
			base.InvokeMethod(shimFrame, constructorInitMethod)
		}
	}
}
