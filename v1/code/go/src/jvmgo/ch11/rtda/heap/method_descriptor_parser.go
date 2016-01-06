package heap

import "strings"

type MethodDescriptorParser struct {
	raw    string
	offset int
	parsed *MethodDescriptor
}

func parseMethodDescriptor(descriptor string) *MethodDescriptor {
	parser := &MethodDescriptorParser{}
	return parser.parse(descriptor)
}

func (self *MethodDescriptorParser) parse(descriptor string) *MethodDescriptor {
	self.raw = descriptor
	self.parsed = &MethodDescriptor{}
	self.startParams()
	self.parseParamTypes()
	self.endParams()
	self.parseReturnType()
	self.finish()
	return self.parsed
}

func (self *MethodDescriptorParser) startParams() {
	if self.readUint8() != '(' {
		self.causePanic()
	}
}
func (self *MethodDescriptorParser) endParams() {
	if self.readUint8() != ')' {
		self.causePanic()
	}
}
func (self *MethodDescriptorParser) finish() {
	if self.offset != len(self.raw) {
		self.causePanic()
	}
}

func (self *MethodDescriptorParser) causePanic() {
	panic("BAD descriptor: " + self.raw)
}

func (self *MethodDescriptorParser) readUint8() uint8 {
	b := self.raw[self.offset]
	self.offset++
	return b
}
func (self *MethodDescriptorParser) unreadUint8() {
	self.offset--
}

func (self *MethodDescriptorParser) parseParamTypes() {
	for {
		t := self.parseFieldType()
		if t != "" {
			self.parsed.addParameterType(t)
		} else {
			break
		}
	}
}

func (self *MethodDescriptorParser) parseReturnType() {
	if self.readUint8() == 'V' {
		self.parsed.returnType = "V"
		return
	}

	self.unreadUint8()
	t := self.parseFieldType()
	if t != "" {
		self.parsed.returnType = t
		return
	}

	self.causePanic()
}

func (self *MethodDescriptorParser) parseFieldType() string {
	switch self.readUint8() {
	case 'B':
		return "B"
	case 'C':
		return "C"
	case 'D':
		return "D"
	case 'F':
		return "F"
	case 'I':
		return "I"
	case 'J':
		return "J"
	case 'S':
		return "S"
	case 'Z':
		return "Z"
	case 'L':
		return self.parseObjectType()
	case '[':
		return self.parseArrayType()
	default:
		self.unreadUint8()
		return ""
	}
}

func (self *MethodDescriptorParser) parseObjectType() string {
	unread := self.raw[self.offset:]
	semicolonIndex := strings.IndexRune(unread, ';')
	if semicolonIndex == -1 {
		self.causePanic()
		return ""
	} else {
		objStart := self.offset - 1
		objEnd := self.offset + semicolonIndex + 1
		self.offset = objEnd
		descriptor := self.raw[objStart:objEnd]
		return descriptor
	}
}

func (self *MethodDescriptorParser) parseArrayType() string {
	arrStart := self.offset - 1
	self.parseFieldType()
	arrEnd := self.offset
	descriptor := self.raw[arrStart:arrEnd]
	return descriptor
}
