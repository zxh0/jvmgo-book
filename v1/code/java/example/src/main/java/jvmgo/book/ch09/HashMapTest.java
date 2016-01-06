package jvmgo.book.ch09;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("abc", "123");
        map.put("xyz", "987");
        System.out.println(map.get("abc"));
        System.out.println(map.get("xyz"));
        System.out.println(map.toString());
    }

}
