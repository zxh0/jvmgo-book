package rtda

import "jvmgo/ch11/rtda/heap"

type Slot struct {
	num int32
	ref *heap.Object
}
