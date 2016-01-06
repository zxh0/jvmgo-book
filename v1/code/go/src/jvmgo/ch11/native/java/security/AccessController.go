package security

import "jvmgo/ch11/instructions/base"
import "jvmgo/ch11/native"
import "jvmgo/ch11/rtda"

func init() {
	native.Register("java/security/AccessController", "doPrivileged", "(Ljava/security/PrivilegedAction;)Ljava/lang/Object;", doPrivileged)
	native.Register("java/security/AccessController", "doPrivileged", "(Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;", doPrivileged)
	native.Register("java/security/AccessController", "getStackAccessControlContext", "()Ljava/security/AccessControlContext;", getStackAccessControlContext)
}

// @CallerSensitive
// public static native <T> T
//     doPrivileged(PrivilegedExceptionAction<T> action)
//     throws PrivilegedActionException;
// (Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;

// @CallerSensitive
// public static native <T> T doPrivileged(PrivilegedAction<T> action);
// (Ljava/security/PrivilegedAction;)Ljava/lang/Object;
func doPrivileged(frame *rtda.Frame) {
	vars := frame.LocalVars()
	action := vars.GetRef(0)

	stack := frame.OperandStack()
	stack.PushRef(action)

	method := action.Class().GetInstanceMethod("run", "()Ljava/lang/Object;") // todo
	base.InvokeMethod(frame, method)
}

// private static native AccessControlContext getStackAccessControlContext();
// ()Ljava/security/AccessControlContext;
func getStackAccessControlContext(frame *rtda.Frame) {
	// todo
	frame.OperandStack().PushRef(nil)
}
