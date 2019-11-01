package com.github.jvmgo.rtda;

public class Util {

    public static Slot setInt(int val) {
        boolean flag = true;
        String s = addZero(Integer.toBinaryString(val), 32);
        if (val < 0) {
            flag = false;
            s = addZero(translate(Integer.toBinaryString(val)), 32);
        }
        Slot slot = new Slot();
        slot.setFlag(flag);
        slot.setNum(s);
        return slot;
    }

    public static int getInt(Slot slot) {
        if (slot.isFlag()) {
            return slot.getNumInt();
        } else {
            return slot.getNumInt() * -1 - 1;
        }
    }

    public static Slot[] setLong(long val) {
        Slot[] slots = new Slot[2];
        boolean flag = true;
        String s = Util.addZero(Long.toBinaryString(val), 64);
        if (val < 0) {
            flag = false;
            s = Util.addZero(Util.translate(Long.toBinaryString(val)), 64);
        }
        String high = s.substring(0, 32);
        String low = s.substring(32);

        Slot slot = new Slot();
        slot.setNum(high);
        slot.setFlag(flag);
        slots[0] = slot;

        Slot slot2 = new Slot();
        slot2.setNum(low);
        slot.setFlag(flag);
        slots[1] = slot2;
        return slots;
    }

    public static long getLong(Slot[] slots) {
        Slot high = slots[0];
        Slot low = slots[1];
        if (high.isFlag()) {
            return Long.parseLong(high.getNum() + low.getNum(), 2);
        } else {
            return Long.parseLong(high.getNum() + low.getNum(), 2) * -1 - 1;
        }
    }

    public static String addZero(String s, int length) {
        if (s.length() >= length) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length - s.length(); i++) {
            builder.append("0");
        }
        return builder.append(s).toString();
    }

    public static String translate(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '0') {
                builder.append("1");
            } else {
                builder.append("0");
            }
        }
        return builder.toString();
    }
}
