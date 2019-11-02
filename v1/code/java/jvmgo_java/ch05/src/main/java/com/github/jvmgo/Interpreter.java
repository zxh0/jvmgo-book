package com.github.jvmgo;

import com.github.jvmgo.clazz.attribute.Code;
import com.github.jvmgo.instructions.base.BytecodeReader;
import com.github.jvmgo.instructions.base.Instruction;
import com.github.jvmgo.instructions.base.InstructionFactory;
import com.github.jvmgo.rtda.Frame;
import com.github.jvmgo.rtda.Thread;

/**

 */
public class Interpreter {


    public static void execute(Code code) throws Exception {
        int max_stack = code.getMax_stack();
        int max_locals = code.getMax_locals();
        byte[] byteCode = code.getCode();
        Thread thread = new Thread(max_stack);
        Frame frame = new Frame(thread, max_locals, max_stack);
        thread.pushFrame(frame);
        loop(thread, byteCode);
    }

    public static void loop(Thread thread, byte[] byteCode) throws Exception {
        Frame frame = thread.popFrame();
        BytecodeReader reader = new BytecodeReader(byteCode, frame.getNextPc());
        int opcode;
        do {
            int pc = frame.getNextPc();
            thread.setPc(pc);
            System.out.print("pc:" + reader.getPc());
            reader.reset(byteCode, pc);
            opcode = reader.read8();
            System.out.print("    opcode:" + opcode);
            Instruction instruction = InstructionFactory.getByOpcode(opcode);
            instruction.fetchOperands(reader);
            frame.setNextPc(reader.getPc());
            instruction.execute(frame);
            System.out.print("   op:" + instruction.getReName());
            System.out.println("   localVars:" + frame.getLocalVars());
        } while (opcode != 0xb1);

    }
}
