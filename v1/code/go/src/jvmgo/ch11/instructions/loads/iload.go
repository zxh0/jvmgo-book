package loads

import "jvmgo/ch11/instructions/base"
import "jvmgo/ch11/rtda"

// Load int from local variable
type ILOAD struct{ base.Index8Instruction }

func (self *ILOAD) Execute(frame *rtda.Frame) {
	_iload(frame, self.Index)
}

type ILOAD_0 struct{ base.NoOperandsInstruction }

func (self *ILOAD_0) Execute(frame *rtda.Frame) {
	_iload(frame, 0)
}

type ILOAD_1 struct{ base.NoOperandsInstruction }

func (self *ILOAD_1) Execute(frame *rtda.Frame) {
	_iload(frame, 1)
}

type ILOAD_2 struct{ base.NoOperandsInstruction }

func (self *ILOAD_2) Execute(frame *rtda.Frame) {
	_iload(frame, 2)
}

type ILOAD_3 struct{ base.NoOperandsInstruction }

func (self *ILOAD_3) Execute(frame *rtda.Frame) {
	_iload(frame, 3)
}

func _iload(frame *rtda.Frame, index uint) {
	val := frame.LocalVars().GetInt(index)
	frame.OperandStack().PushInt(val)
}
