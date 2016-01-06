package lang

import "jvmgo/ch11/instructions/base"
import "jvmgo/ch11/rtda"
import "jvmgo/ch11/rtda/heap"

/*
Method(Class<?> declaringClass,
       String name,
       Class<?>[] parameterTypes,
       Class<?> returnType,
       Class<?>[] checkedExceptions,
       int modifiers,
       int slot,
       String signature,
       byte[] annotations,
       byte[] parameterAnnotations,
       byte[] annotationDefault)
*/
const _methodConstructorDescriptor = "" +
	"(Ljava/lang/Class;" +
	"Ljava/lang/String;" +
	"[Ljava/lang/Class;" +
	"Ljava/lang/Class;" +
	"[Ljava/lang/Class;" +
	"II" +
	"Ljava/lang/String;" +
	"[B[B[B)V"

// private native Method[] getDeclaredMethods0(boolean publicOnly);
// (Z)[Ljava/lang/reflect/Method;
func getDeclaredMethods0(frame *rtda.Frame) {
	vars := frame.LocalVars()
	classObj := vars.GetThis()
	publicOnly := vars.GetBoolean(1)

	class := classObj.Extra().(*heap.Class)
	methods := class.GetMethods(publicOnly)
	methodCount := uint(len(methods))

	classLoader := class.Loader()
	methodClass := classLoader.LoadClass("java/lang/reflect/Method")
	methodArr := methodClass.ArrayClass().NewArray(methodCount)

	stack := frame.OperandStack()
	stack.PushRef(methodArr)

	// create method objs
	if methodCount > 0 {
		thread := frame.Thread()
		methodObjs := methodArr.Refs()
		methodConstructor := methodClass.GetConstructor(_methodConstructorDescriptor)
		for i, method := range methods {
			methodObj := methodClass.NewObject()
			methodObj.SetExtra(method)
			methodObjs[i] = methodObj

			ops := rtda.NewOperandStack(12)
			ops.PushRef(methodObj)                                                // this
			ops.PushRef(classObj)                                                 // declaringClass
			ops.PushRef(heap.JString(classLoader, method.Name()))                 // name
			ops.PushRef(toClassArr(classLoader, method.ParameterTypes()))         // parameterTypes
			ops.PushRef(method.ReturnType().JClass())                             // returnType
			ops.PushRef(toClassArr(classLoader, method.ExceptionTypes()))         // checkedExceptions
			ops.PushInt(int32(method.AccessFlags()))                              // modifiers
			ops.PushInt(int32(0))                                                 // todo: slot
			ops.PushRef(getSignatureStr(classLoader, method.Signature()))         // signature
			ops.PushRef(toByteArr(classLoader, method.AnnotationData()))          // annotations
			ops.PushRef(toByteArr(classLoader, method.ParameterAnnotationData())) // parameterAnnotations
			ops.PushRef(toByteArr(classLoader, method.AnnotationDefaultData()))   // annotationDefault

			shimFrame := rtda.NewShimFrame(thread, ops)
			thread.PushFrame(shimFrame)

			// init methodObj
			base.InvokeMethod(shimFrame, methodConstructor)
		}
	}
}
