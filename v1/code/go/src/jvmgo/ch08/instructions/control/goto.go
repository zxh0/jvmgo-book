package control

import "jvmgo/ch08/instructions/base"
import "jvmgo/ch08/rtda"

// Branch always
type GOTO struct{ base.BranchInstruction }

func (self *GOTO) Execute(frame *rtda.Frame) {
	base.Branch(frame, self.Offset)
}
