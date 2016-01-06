package misc

import "math"
import "encoding/binary"
import "jvmgo/ch11/native"
import "jvmgo/ch11/rtda"

func init() {
	_unsafe(allocateMemory, "allocateMemory", "(J)J")
	_unsafe(reallocateMemory, "reallocateMemory", "(JJ)J")
	_unsafe(freeMemory, "freeMemory", "(J)V")
	_unsafe(addressSize, "addressSize", "()I")
	//	_unsafe(putAddress, "putAddress", "(JJ)V")
	//	_unsafe(getAddress, "getAddress", "(J)J")
	//	_unsafe(mem_putByte, "putByte", "(JB)V")
	_unsafe(mem_getByte, "getByte", "(J)B")
	//	_unsafe(mem_putShort, "putShort", "(JS)V")
	//	_unsafe(mem_getShort, "getShort", "(J)S")
	//	_unsafe(mem_putChar, "putChar", "(JC)V")
	//	_unsafe(mem_getChar, "getChar", "(J)C")
	//	_unsafe(mem_putInt, "putInt", "(JI)V")
	//	_unsafe(mem_getInt, "getInt", "(J)I")
	_unsafe(mem_putLong, "putLong", "(JJ)V")
	//	_unsafe(mem_getLong, "getLong", "(J)J")
	//	_unsafe(mem_putFloat, "putFloat", "(JF)V")
	//	_unsafe(mem_getFloat, "getFloat", "(J)F")
	//	_unsafe(mem_putDouble, "putDouble", "(JD)V")
	//	_unsafe(mem_getDouble, "getDouble", "(J)D")
}

func _unsafe(method func(frame *rtda.Frame), name, desc string) {
	native.Register("sun/misc/Unsafe", name, desc, method)
}

// public native long allocateMemory(long bytes);
// (J)J
func allocateMemory(frame *rtda.Frame) {
	vars := frame.LocalVars()
	// vars.GetRef(0) // this
	bytes := vars.GetLong(1)

	address := allocate(bytes)
	stack := frame.OperandStack()
	stack.PushLong(address)
}

// public native long reallocateMemory(long address, long bytes);
// (JJ)J
func reallocateMemory(frame *rtda.Frame) {
	vars := frame.LocalVars()
	// vars.GetRef(0) // this
	address := vars.GetLong(1)
	bytes := vars.GetLong(3)

	newAddress := reallocate(address, bytes)
	stack := frame.OperandStack()
	stack.PushLong(newAddress)
}

// public native void freeMemory(long address);
// (J)V
func freeMemory(frame *rtda.Frame) {
	vars := frame.LocalVars()
	// vars.GetRef(0) // this
	address := vars.GetLong(1)
	free(address)
}

//// public native void putAddress(long address, long x);
//// (JJ)V
//func putAddress(frame *rtda.Frame) {
//	mem_putLong(frame)
//}
//
//// public native long getAddress(long address);
//// (J)J
//func getAddress(frame *rtda.Frame) {
//	mem_getLong(frame)
//}
//
//// public native void putByte(long address, byte x);
//// (JB)V
//func mem_putByte(frame *rtda.Frame) {
//	mem, value := _put(frame)
//	PutInt8(mem, int8(value.(int32)))
//}
//
// public native byte getByte(long address);
// (J)B
func mem_getByte(frame *rtda.Frame) {
	stack, mem := _get(frame)
	stack.PushInt(int32(Int8(mem)))
}

//
//// public native void putShort(long address, short x);
//// (JS)V
//func mem_putShort(frame *rtda.Frame) {
//	mem, value := _put(frame)
//	PutInt16(mem, int16(value.(int32)))
//}
//
//// public native short getShort(long address);
//// (J)S
//func mem_getShort(frame *rtda.Frame) {
//	stack, mem := _get(frame)
//	stack.PushInt(int32(Int16(mem)))
//}
//
//// public native void putChar(long address, char x);
//// (JC)V
//func mem_putChar(frame *rtda.Frame) {
//	mem, value := _put(frame)
//	PutUint16(mem, uint16(value.(int32)))
//}
//
//// public native char getChar(long address);
//// (J)C
//func mem_getChar(frame *rtda.Frame) {
//	stack, mem := _get(frame)
//	stack.PushInt(int32(Uint16(mem)))
//}
//
//// public native void putInt(long address, int x);
//// (JI)V
//func mem_putInt(frame *rtda.Frame) {
//	mem, value := _put(frame)
//	PutInt32(mem, value.(int32))
//}
//
//// public native int getInt(long address);
//// (J)I
//func mem_getInt(frame *rtda.Frame) {
//	stack, mem := _get(frame)
//	stack.PushInt(Int32(mem))
//}
//
// public native void putLong(long address, long x);
// (JJ)V
func mem_putLong(frame *rtda.Frame) {
	vars := frame.LocalVars()
	// vars.GetRef(0) // this
	address := vars.GetLong(1)
	value := vars.GetLong(3)

	mem := memoryAt(address)

	PutInt64(mem, value)
}

//
//// public native long getLong(long address);
//// (J)J
//func mem_getLong(frame *rtda.Frame) {
//	stack, mem := _get(frame)
//	stack.PushLong(Int64(mem))
//}
//
//// public native void putFloat(long address, float x);
//// (JJ)V
//func mem_putFloat(frame *rtda.Frame) {
//	mem, value := _put(frame)
//	PutFloat32(mem, value.(float32))
//}
//
//// public native float getFloat(long address);
//// (J)J
//func mem_getFloat(frame *rtda.Frame) {
//	stack, mem := _get(frame)
//	stack.PushFloat(Float32(mem))
//}
//
//// public native void putDouble(long address, double x);
//// (JJ)V
//func mem_putDouble(frame *rtda.Frame) {
//	mem, value := _put(frame)
//	PutFloat64(mem, value.(float64))
//}
//
//// public native double getDouble(long address);
//// (J)J
//func mem_getDouble(frame *rtda.Frame) {
//	stack, mem := _get(frame)
//	stack.PushDouble(Float64(mem))
//}
//
//func _put(frame *rtda.Frame) ([]byte, interface{}) {
//	vars := frame.LocalVars()
//	// vars.GetRef(0) // this
//	address := vars.GetLong(1)
//	value := vars.Get(3)
//
//	mem := memoryAt(address)
//	return mem, value
//}
//
func _get(frame *rtda.Frame) (*rtda.OperandStack, []byte) {
	vars := frame.LocalVars()
	// vars.GetRef(0) // this
	address := vars.GetLong(1)

	stack := frame.OperandStack()
	mem := memoryAt(address)
	return stack, mem
}

var _bigEndian = binary.BigEndian

func PutInt8(s []byte, val int8) {
	s[0] = uint8(val)
}
func Int8(s []byte) int8 {
	return int8(s[0])
}

func PutUint16(s []byte, val uint16) {
	_bigEndian.PutUint16(s, val)
}
func Uint16(s []byte) uint16 {
	return _bigEndian.Uint16(s)
}

func PutInt16(s []byte, val int16) {
	_bigEndian.PutUint16(s, uint16(val))
}
func Int16(s []byte) int16 {
	return int16(_bigEndian.Uint16(s))
}

func PutInt32(s []byte, val int32) {
	_bigEndian.PutUint32(s, uint32(val))
}
func Int32(s []byte) int32 {
	return int32(_bigEndian.Uint32(s))
}

func PutInt64(s []byte, val int64) {
	_bigEndian.PutUint64(s, uint64(val))
}
func Int64(s []byte) int64 {
	return int64(_bigEndian.Uint64(s))
}

func PutFloat32(s []byte, val float32) {
	_bigEndian.PutUint32(s, math.Float32bits(val))
}
func Float32(s []byte) float32 {
	return math.Float32frombits(_bigEndian.Uint32(s))
}

func PutFloat64(s []byte, val float64) {
	_bigEndian.PutUint64(s, math.Float64bits(val))
}
func Float64(s []byte) float64 {
	return math.Float64frombits(_bigEndian.Uint64(s))
}
