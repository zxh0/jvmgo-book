package misc

import "jvmgo/ch11/native"
import "jvmgo/ch11/rtda"
import "jvmgo/ch11/rtda/heap"

const miscUnsafe = "sun/misc/Unsafe"

func init() {
	native.Register(miscUnsafe, "arrayBaseOffset", "(Ljava/lang/Class;)I", arrayBaseOffset)
	native.Register(miscUnsafe, "arrayIndexScale", "(Ljava/lang/Class;)I", arrayIndexScale)
	native.Register(miscUnsafe, "addressSize", "()I", addressSize)
	native.Register(miscUnsafe, "objectFieldOffset", "(Ljava/lang/reflect/Field;)J", objectFieldOffset)
	native.Register(miscUnsafe, "compareAndSwapObject", "(Ljava/lang/Object;JLjava/lang/Object;Ljava/lang/Object;)Z", compareAndSwapObject)
	native.Register(miscUnsafe, "getIntVolatile", "(Ljava/lang/Object;J)I", getInt)
	native.Register(miscUnsafe, "compareAndSwapInt", "(Ljava/lang/Object;JII)Z", compareAndSwapInt)
	native.Register(miscUnsafe, "getObjectVolatile", "(Ljava/lang/Object;J)Ljava/lang/Object;", getObject)
	native.Register(miscUnsafe, "compareAndSwapLong", "(Ljava/lang/Object;JJJ)Z", compareAndSwapLong)

}

// public native int arrayBaseOffset(Class<?> type);
// (Ljava/lang/Class;)I
func arrayBaseOffset(frame *rtda.Frame) {
	stack := frame.OperandStack()
	stack.PushInt(0) // todo
}

// public native int arrayIndexScale(Class<?> type);
// (Ljava/lang/Class;)I
func arrayIndexScale(frame *rtda.Frame) {
	stack := frame.OperandStack()
	stack.PushInt(1) // todo
}

// public native int addressSize();
// ()I
func addressSize(frame *rtda.Frame) {
	// vars := frame.LocalVars()
	// vars.GetRef(0) // this

	stack := frame.OperandStack()
	stack.PushInt(8) // todo unsafe.Sizeof(int)
}

// public native long objectFieldOffset(Field field);
// (Ljava/lang/reflect/Field;)J
func objectFieldOffset(frame *rtda.Frame) {
	vars := frame.LocalVars()
	jField := vars.GetRef(1)

	offset := jField.GetIntVar("slot", "I")

	stack := frame.OperandStack()
	stack.PushLong(int64(offset))
}

// public final native boolean compareAndSwapObject(Object o, long offset, Object expected, Object x)
// (Ljava/lang/Object;JLjava/lang/Object;Ljava/lang/Object;)Z
func compareAndSwapObject(frame *rtda.Frame) {
	vars := frame.LocalVars()
	obj := vars.GetRef(1)
	fields := obj.Data()
	offset := vars.GetLong(2)
	expected := vars.GetRef(4)
	newVal := vars.GetRef(5)

	// todo
	if anys, ok := fields.(heap.Slots); ok {
		// object
		swapped := _casObj(obj, anys, offset, expected, newVal)
		frame.OperandStack().PushBoolean(swapped)
	} else if objs, ok := fields.([]*heap.Object); ok {
		// ref[]
		swapped := _casArr(objs, offset, expected, newVal)
		frame.OperandStack().PushBoolean(swapped)
	} else {
		// todo
		panic("todo: compareAndSwapObject!")
	}
}
func _casObj(obj *heap.Object, fields heap.Slots, offset int64, expected, newVal *heap.Object) bool {
	current := fields.GetRef(uint(offset))
	if current == expected {
		fields.SetRef(uint(offset), newVal)
		return true
	} else {
		return false
	}
}
func _casArr(objs []*heap.Object, offset int64, expected, newVal *heap.Object) bool {
	current := objs[offset]
	if current == expected {
		objs[offset] = newVal
		return true
	} else {
		return false
	}
}

// public native boolean getInt(Object o, long offset);
// (Ljava/lang/Object;J)I
func getInt(frame *rtda.Frame) {
	vars := frame.LocalVars()
	fields := vars.GetRef(1).Data()
	offset := vars.GetLong(2)

	stack := frame.OperandStack()
	if slots, ok := fields.(heap.Slots); ok {
		// object
		stack.PushInt(slots.GetInt(uint(offset)))
	} else if shorts, ok := fields.([]int32); ok {
		// int[]
		stack.PushInt(int32(shorts[offset]))
	} else {
		panic("getInt!")
	}
}

// public final native boolean compareAndSwapInt(Object o, long offset, int expected, int x);
// (Ljava/lang/Object;JII)Z
func compareAndSwapInt(frame *rtda.Frame) {
	vars := frame.LocalVars()
	fields := vars.GetRef(1).Data()
	offset := vars.GetLong(2)
	expected := vars.GetInt(4)
	newVal := vars.GetInt(5)

	if slots, ok := fields.(heap.Slots); ok {
		// object
		oldVal := slots.GetInt(uint(offset))
		if oldVal == expected {
			slots.SetInt(uint(offset), newVal)
			frame.OperandStack().PushBoolean(true)
		} else {
			frame.OperandStack().PushBoolean(false)
		}
	} else if ints, ok := fields.([]int32); ok {
		// int[]
		oldVal := ints[offset]
		if oldVal == expected {
			ints[offset] = newVal
			frame.OperandStack().PushBoolean(true)
		} else {
			frame.OperandStack().PushBoolean(false)
		}
	} else {
		// todo
		panic("todo: compareAndSwapInt!")
	}
}

// public native Object getObject(Object o, long offset);
// (Ljava/lang/Object;J)Ljava/lang/Object;
func getObject(frame *rtda.Frame) {
	vars := frame.LocalVars()
	fields := vars.GetRef(1).Data()
	offset := vars.GetLong(2)

	if anys, ok := fields.(heap.Slots); ok {
		// object
		x := anys.GetRef(uint(offset))
		frame.OperandStack().PushRef(x)
	} else if objs, ok := fields.([]*heap.Object); ok {
		// ref[]
		x := objs[offset]
		frame.OperandStack().PushRef(x)
	} else {
		panic("getObject!")
	}
}

// public final native boolean compareAndSwapLong(Object o, long offset, long expected, long x);
// (Ljava/lang/Object;JJJ)Z
func compareAndSwapLong(frame *rtda.Frame) {
	vars := frame.LocalVars()
	fields := vars.GetRef(1).Data()
	offset := vars.GetLong(2)
	expected := vars.GetLong(4)
	newVal := vars.GetLong(6)

	if slots, ok := fields.(heap.Slots); ok {
		// object
		oldVal := slots.GetLong(uint(offset))
		if oldVal == expected {
			slots.SetLong(uint(offset), newVal)
			frame.OperandStack().PushBoolean(true)
		} else {
			frame.OperandStack().PushBoolean(false)
		}
	} else if longs, ok := fields.([]int64); ok {
		// long[]
		oldVal := longs[offset]
		if oldVal == expected {
			longs[offset] = newVal
			frame.OperandStack().PushBoolean(true)
		} else {
			frame.OperandStack().PushBoolean(false)
		}
	} else {
		// todo
		panic("todo: compareAndSwapLong!")
	}
}
