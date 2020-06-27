package ds;

import java.util.TreeMap;

/*
 * Demo of Tree Maps
 *
 * A tree map is an ordered map and supports the same operations that an unordered map supports but supports some additional
 * methods, just like the Tree Set
 */

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(3, 5); // [(3, 5)]
        map.put(11, 4); // [(3, 5); (11, 4)]
        map.put(10, 491); // [(3, 5); (10, 491); (11, 4)]

        System.out.println(map.firstKey()); // 3
        System.out.println(map.firstEntry()); // (3, 5)
        System.out.println(map.lastEntry()); // (11, 4)
        System.out.println(map.higherEntry(4)); // (10, 491)

        map.remove(11); // [(3, 5); (10, 491)]
        System.out.println(map.lowerKey(4)); // 3
        System.out.println(map.lowerKey(3)); // ERROR
    }
}
