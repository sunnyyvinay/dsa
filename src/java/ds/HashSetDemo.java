package ds;

import java.util.HashSet;

/*
 * Demo of Hash sets.
 *
 * A hash set is an unordered set. The unordered set works by hashing.
 *
 * https://www.geeksforgeeks.org/set-in-java/
 * https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
 */

public class HashSetDemo {
    public static void main(String[] args) {
        // Create empty Set using HashSet
        HashSet<Integer> set = new HashSet<>();
        set.add(1); // [1]
        set.add(4); // [1, 4] in arbitrary order
        set.add(2); // [1, 4, 2] in arbitrary order
        set.add(1); // [1, 4, 2] in arbitrary order
        // the add method did nothing because 1 was already in the set

        System.out.println(set.contains(1)); // true

        set.remove(1); // [2, 4] in arbitrary order
        System.out.println(set.contains(5)); // false
        set.remove(0); // [2, 4] in arbitrary order
        // if the element to be removed does not exist, nothing happens

        for (int element : set){
            System.out.println(element);
        }
        // You can iterate through an unordered set, but it will do so in arbitrary order
    }
}
