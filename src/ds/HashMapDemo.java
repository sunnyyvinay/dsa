package ds;

/*
 * https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/
 *
 * Hashmaps provides the basic implementation of the Map interface of Java. It stores the data in (Key, Value) pairs.
 */

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        // Create an empty hash map
        HashMap<String, Integer> map
                = new HashMap<>();

        // Add elements to the map
        map.put("vishal", 10);
        map.put("sachin", 30);
        map.put("vaibhav", 20);

        // Print size and content
        System.out.println("Size of map is:- "
                + map.size());
        System.out.println(map);

        // Check if a key is present and if present, print value
        if (map.containsKey("vishal")) {
            Integer a = map.get("vishal");
            System.out.println("value for key"
                    + " \"vishal\" is:- "
                    + a);
        }

        // Traversal of HashMap
        for (Map.Entry<String, Integer> e : map.entrySet()) System.out.println(e.getKey() + " " + e.getValue());
    }
}
