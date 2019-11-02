package com.github.jvmgo.instructions.base;

import com.github.jvmgo.rtda.Frame;

public interface Instruction {


    int getOpCode();

    default String getReName() {
        return this.getClass().getSimpleName();
    }

    /**
     * 从字节码中提取操作数
     *
     * @param reader
     */
    void fetchOperands(BytecodeReader reader) throws Exception;

    /**
     * 执行逻辑指令
     *
     * @param frame
     */
    void execute(Frame frame) throws Exception;
}
