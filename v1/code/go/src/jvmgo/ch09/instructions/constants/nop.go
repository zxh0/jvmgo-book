package constants

import "jvmgo/ch09/instructions/base"
import "jvmgo/ch09/rtda"

// Do nothing
type NOP struct{ base.NoOperandsInstruction }

func (self *NOP) Execute(frame *rtda.Frame) {
	// really do nothing
}
