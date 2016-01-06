package lang

import "unsafe"
import "jvmgo/ch11/rtda/heap"

// []*Class => Class[]
func toClassArr(loader *heap.ClassLoader, classes []*heap.Class) *heap.Object {
	arrLen := len(classes)

	classArrClass := loader.LoadClass("java/lang/Class").ArrayClass()
	classArr := classArrClass.NewArray(uint(arrLen))

	if arrLen > 0 {
		classObjs := classArr.Refs()
		for i, class := range classes {
			classObjs[i] = class.JClass()
		}
	}

	return classArr
}

// []byte => byte[]
func toByteArr(loader *heap.ClassLoader, goBytes []byte) *heap.Object {
	if goBytes != nil {
		jBytes := castUint8sToInt8s(goBytes)
		return heap.NewByteArray(loader, jBytes)
	}
	return nil
}
func castUint8sToInt8s(goBytes []byte) (jBytes []int8) {
	ptr := unsafe.Pointer(&goBytes)
	jBytes = *((*[]int8)(ptr))
	return
}

func getSignatureStr(loader *heap.ClassLoader, signature string) *heap.Object {
	if signature != "" {
		return heap.JString(loader, signature)
	}
	return nil
}
