package heap

func (self *Class) IsArray() bool {
	return self.name[0] == '['
}

func (self *Class) ComponentClass() *Class {
	componentClassName := getComponentClassName(self.name)
	return self.loader.LoadClass(componentClassName)
}

func (self *Class) NewArray(count uint) *Object {
	if !self.IsArray() {
		panic("Not array class: " + self.name)
	}
	switch self.Name() {
	case "[Z":
		return &Object{self, make([]int8, count), nil}
	case "[B":
		return &Object{self, make([]int8, count), nil}
	case "[C":
		return &Object{self, make([]uint16, count), nil}
	case "[S":
		return &Object{self, make([]int16, count), nil}
	case "[I":
		return &Object{self, make([]int32, count), nil}
	case "[J":
		return &Object{self, make([]int64, count), nil}
	case "[F":
		return &Object{self, make([]float32, count), nil}
	case "[D":
		return &Object{self, make([]float64, count), nil}
	default:
		return &Object{self, make([]*Object, count), nil}
	}
}

func NewByteArray(loader *ClassLoader, bytes []int8) *Object {
	return &Object{loader.LoadClass("[B"), bytes, nil}
}
