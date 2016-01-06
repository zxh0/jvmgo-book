package rtda

import "jvmgo/ch09/rtda/heap"

type Slot struct {
	num int32
	ref *heap.Object
}
