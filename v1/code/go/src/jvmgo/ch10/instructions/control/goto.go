package control

import "jvmgo/ch10/instructions/base"
import "jvmgo/ch10/rtda"

// Branch always
type GOTO struct{ base.BranchInstruction }

func (self *GOTO) Execute(frame *rtda.Frame) {
	base.Branch(frame, self.Offset)
}
