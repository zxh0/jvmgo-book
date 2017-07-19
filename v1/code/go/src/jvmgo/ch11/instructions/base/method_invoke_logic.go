package base

import "fmt"
import "strings"
import "jvmgo/ch11/rtda"
import "jvmgo/ch11/rtda/heap"

func InvokeMethod(invokerFrame *rtda.Frame, method *heap.Method) {
	//_logInvoke(callerFrame.Thread().StackDepth(), method)
	thread := invokerFrame.Thread()
	newFrame := thread.NewFrame(method)
	thread.PushFrame(newFrame)

	argSlotCount := int(method.ArgSlotCount())
	if argSlotCount > 0 {
		for i := argSlotCount - 1; i >= 0; i-- {
			slot := invokerFrame.OperandStack().PopSlot()
			newFrame.LocalVars().SetSlot(uint(i), slot)
		}
	}
}

func _logInvoke(stackSize uint, method *heap.Method) {
	space := strings.Repeat(" ", int(stackSize))
	className := method.Class().Name()
	methodName := method.Name()
	fmt.Printf("[method]%v %v.%v()\n", space, className, methodName)
}
