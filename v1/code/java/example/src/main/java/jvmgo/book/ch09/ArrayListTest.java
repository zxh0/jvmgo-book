package jvmgo.book.ch09;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("hello");
        strs.add("world");
        for (String str : strs) {
            System.out.println(str);
        }
    }

}
