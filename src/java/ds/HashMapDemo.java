package ds;

/*
 * Demo of Hash Map
 *
 * Hashmaps provides the basic implementation of the Map interface of Java. It stores the data in (Key, Value) pairs.
 *
 * https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/
 */

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 5); // [(1, 5)]
        map.put(3, 14); // [(1, 5); (3, 14)]
        map.put(2, 7); // [(1, 5); (3, 14); (2, 7)]
        map.remove(2); // [(1, 5); (3, 14)]
        System.out.println(map.get(1)); // 5
        System.out.println(map.containsKey(7)); // false
        System.out.println(map.containsKey(1)); // true

        // Traversal of HashMap
        for (Map.Entry<Integer, Integer> e : map.entrySet()) System.out.println(e.getKey() + " " + e.getValue());
    }
}
