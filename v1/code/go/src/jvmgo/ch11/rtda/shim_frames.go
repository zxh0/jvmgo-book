package rtda

import "jvmgo/ch11/rtda/heap"

func NewShimFrame(thread *Thread, ops *OperandStack) *Frame {
	return &Frame{
		thread:       thread,
		method:       heap.ShimReturnMethod(),
		operandStack: ops,
	}
}

//func newAthrowFrame(thread *Thread, ex *heap.Object, initArgs []interface{}) *Frame {
//	// stackSlots := [ex, ex, initArgs]
//	stackSlots := make([]interface{}, len(initArgs)+2)
//	stackSlots[0] = ex
//	stackSlots[1] = ex
//	copy(stackSlots[2:], initArgs)
//
//	frame := &Frame{}
//	frame.thread = thread
//	frame.method = heap.AthrowMethod()
//	frame.operandStack = &OperandStack{
//		size:  uint(len(stackSlots)),
//		slots: stackSlots,
//	}
//	return frame
//}
