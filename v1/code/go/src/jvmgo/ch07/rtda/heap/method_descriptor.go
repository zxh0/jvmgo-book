package heap

type MethodDescriptor struct {
	parameterTypes []string
	returnType     string
}

func (self *MethodDescriptor) addParameterType(t string) {
	pLen := len(self.parameterTypes)
	if pLen == cap(self.parameterTypes) {
		s := make([]string, pLen, pLen+4)
		copy(s, self.parameterTypes)
		self.parameterTypes = s
	}

	self.parameterTypes = append(self.parameterTypes, t)
}
