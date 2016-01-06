package constants

import "jvmgo/ch05/instructions/base"
import "jvmgo/ch05/rtda"

// Do nothing
type NOP struct{ base.NoOperandsInstruction }

func (self *NOP) Execute(frame *rtda.Frame) {
	// really do nothing
}
