package io

import "path/filepath"
import "os"
import "jvmgo/ch11/native"
import "jvmgo/ch11/rtda"
import "jvmgo/ch11/rtda/heap"

const unixfs = "java/io/UnixFileSystem"

func init() {
	native.Register(unixfs, "canonicalize0", "(Ljava/lang/String;)Ljava/lang/String;", canonicalize0)
	native.Register(unixfs, "getBooleanAttributes0", "(Ljava/io/File;)I", getBooleanAttributes0)

}

// private native String canonicalize0(String path) throws IOException;
// (Ljava/lang/String;)Ljava/lang/String;
func canonicalize0(frame *rtda.Frame) {
	vars := frame.LocalVars()
	path := vars.GetRef(1)

	// todo
	goPath := heap.GoString(path)
	goPath2 := filepath.Clean(goPath)
	if goPath2 != goPath {
		path = heap.JString(frame.Method().Class().Loader(), goPath2)
	}

	stack := frame.OperandStack()
	stack.PushRef(path)
}

// public native int getBooleanAttributes0(File f);
// (Ljava/io/File;)I
func getBooleanAttributes0(frame *rtda.Frame) {
	vars := frame.LocalVars()
	f := vars.GetRef(1)
	path := _getPath(f)

	// todo
	attributes0 := 0
	if _exists(path) {
		attributes0 |= 0x01
	}
	if _isDir(path) {
		attributes0 |= 0x04
	}

	stack := frame.OperandStack()
	stack.PushInt(int32(attributes0))
}

func _getPath(fileObj *heap.Object) string {
	pathStr := fileObj.GetRefVar("path", "Ljava/lang/String;")
	return heap.GoString(pathStr)
}

// http://stackoverflow.com/questions/10510691/how-to-check-whether-a-file-or-directory-denoted-by-a-path-exists-in-golang
// exists returns whether the given file or directory exists or not
func _exists(path string) bool {
	_, err := os.Stat(path)
	if err == nil {
		return true
	}
	if os.IsNotExist(err) {
		return false
	}
	return false
}

// http://stackoverflow.com/questions/8824571/golang-determining-whether-file-points-to-file-or-directory
func _isDir(path string) bool {
	fileInfo, err := os.Stat(path)
	if err == nil {
		return fileInfo.IsDir()
	}
	return false
}
