package stack

import "jvmgo/ch05/instructions/base"
import "jvmgo/ch05/rtda"

/*
bottom -> top
[...][c][b][a]
            |
            V
[...][c][b]
*/
// Pop the top operand stack value
type POP struct{ base.NoOperandsInstruction }

func (self *POP) Execute(frame *rtda.Frame) {
	stack := frame.OperandStack()
	stack.PopSlot()
}

/*
bottom -> top
[...][c][b][a]
         |  |
         V  V
[...][c]
*/
// Pop the top one or two operand stack values
type POP2 struct{ base.NoOperandsInstruction }

func (self *POP2) Execute(frame *rtda.Frame) {
	stack := frame.OperandStack()
	stack.PopSlot()
	stack.PopSlot()
}
