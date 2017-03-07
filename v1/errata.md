# 勘误表

页数  | 章节   | 位置         | 原文                          | 更正                                | 读者                          | 更正版次
----- | ------ | ------------ | ----------------------------- | ----------------------------------- | ----------------------------- | ---------
 13   | 2.3.2  | 第2段话      | ...显示实现接口...            | ...显**式**实现接口...              | ![先飞][先飞]                 | 第3次印刷
 26   | 3.2    | 表3-1        | float33                       | float3**2**                         | ![一切都将尘封][一切都将尘封] | 第3次印刷
 37   | 3.3.1  | 最后一行字   | ...常量池大小是61...          | ...常量池大小是6**4**...            | ![JingkaiTang][JingkaiTang]   | 第3次印刷
 38   | 3.3.2  | 第3段        | 继续编辑constant`_pool`.go... | 继续编辑constant`_info`.go...       | ![啊乐][啊乐]                 | 第2次印刷
 45   | 3.3.9  | 最后一行字   | `CONSTANT_Utf_info`           | `CONSTANT_Utf8_info`                | ![乌鸦的吉他][乌鸦的吉他]     | 
 47   | 3.3.10 | 表3-3（r4c3）| (Ljava.lang.String;)V         | (**[**Ljava.lang.String;)V          | ![啊乐][啊乐]                 | 第2次印刷
 47   | 3.3.10 | 表3-3（r5c3）| (FF)F                         | (FF)**I**                           | ![啊乐][啊乐]                 | 第2次印刷
 47   | 3.3.10 | 表3-3（r6c2）| java.lang.Object[]            | java.lang.**String**[]              | ![乌鸦的吉他][乌鸦的吉他]     | 
 47   | 3.3.10 | 第2段话      | override                      | overload                            | ![Nancy945][Nancy945]         | 
 61   | 3.5    | 第1段代码    | func startJVM(参数错误)...    | func startJVM(`cmd *Cmd`)...        | ![Jing0][Jing0]               | 
 81   | 4.3.6  | 图4-13       | botto                         | botto**m**                          | ![zxh][zxh]                   | 第2次印刷
 88   | 5.1    | 第1段话      | 266(0xFF)                     | 2**55**(0xFF)                       | ![charles0lee][charles0lee]   | 第3次印刷
 90   | 5.2.1  | 第2段        | 读取一个uint16整数            | 读取一个**int16**整数               | ![iHge2k][iHge2k]             | 第3次印刷
 90   | 5.2.1  | 第4段        | 读取一个int8整数              | 读取一个**u**int8整数               | ![iHge2k][iHge2k]             | 第3次印刷
170   | 7.5.1  | 第1段代码    | import "jvmgo/ch07/rtda/class"| import "jvmgo/ch07/rtda/**heap**"   | ![Nancy945][Nancy945]         | 
170   | 7.5.1  | 第2段代码    | if !resolved.IsStatic() {     | if !resolved**Method**.IsStatic() { | ![乌鸦的吉他][乌鸦的吉他]     |
171   | 7.5.2  | 第4段代码    | ...ArgSlotCount())            | ...ArgSlotCount()` - 1`)            | ![Beyond][Beyond]             | 第3次印刷
172   | 7.5.2  | 第2段        | 如果调用的中超类中的函数      | 如果调用的**是**超类中的函数        | ![zxh][zxh]                   | 第3次印刷
172   | 7.5.2  | 倒数第2段代码| (frame, methodtoBeInvoked)    | (frame, method**T**oBeInvoked)      | ![乌鸦的吉他][乌鸦的吉他]     | 
175   | 7.5.4  | 最后一段话   | 从操作数栈中弹出this引用...   | 从操作数栈中**取**出this引用...     | ![乌鸦的吉他][乌鸦的吉他]     | 
189   | 8.2.1  | 最后一段代码 | switch self.fields.(type) {   | switch self.**data**.(type) {       | ![JingkaiTang][JingkaiTang]   | 
194   | 8.3.2  | 第2段代码    | ...(*rtc.ClassRef)            | ...(`*heap`.ClassRef)               | ![CURAS][CURAS]               | 
199   | 8.3.6  | 最后一句话   | newMultiArray()               | newMultiDimensionalArray()          | ![CURAS][CURAS]               | 
204   | 8.5    | 第2段话      | 缓存~~计~~字符串的哈希码      | 缓存字符串的哈希码                  | ![乌鸦的吉他][乌鸦的吉他]     | 
206   | 8.5.1  | getField方法 | ...isStatic) *Field {         | ...isStatic **bool**) *Field {      | ![CURAS][CURAS]               | 


[Beyond]: https://github.com/zxh0/jvmgo-book/blob/master/v1/readers/Beyond.png?raw=true "Beyond"
[CURAS]: https://github.com/zxh0/jvmgo-book/blob/master/v1/readers/CURAS.png?raw=true "CURAS"
[charles0lee]: https://github.com/zxh0/jvmgo-book/blob/master/v1/readers/charles0lee.png?raw=true "charles0lee"
[iHge2k]: https://github.com/zxh0/jvmgo-book/blob/master/v1/readers/iHge2k.jpg?raw=true "iHge2k"
[Jing0]: https://github.com/zxh0/jvmgo-book/blob/master/v1/readers/Jing0.jpg?raw=true "Jing0"
[JingkaiTang]: https://github.com/zxh0/jvmgo-book/blob/master/v1/readers/JingkaiTang.png?raw=true "JingkaiTang"
[Nancy945]: https://github.com/zxh0/jvmgo-book/blob/master/v1/readers/Nancy945.jpg?raw=true "Nancy945"
[zxh]: https://github.com/zxh0/jvmgo-book/blob/master/v1/readers/zxh.jpg?raw=true "zxh"
[啊乐]: https://github.com/zxh0/jvmgo-book/blob/master/v1/readers/啊乐.png?raw=true "啊乐"
[乌鸦的吉他]: https://github.com/zxh0/jvmgo-book/blob/master/v1/readers/乌鸦的吉他.jpg?raw=true "乌鸦的吉他"
[先飞]: https://github.com/zxh0/jvmgo-book/blob/master/v1/readers/先飞.png?raw=true "先飞"
[一切都将尘封]: https://github.com/zxh0/jvmgo-book/blob/master/v1/readers/一切都将尘封.jpg?raw=true "一切都将尘封"
