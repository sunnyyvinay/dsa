package ds;

import java.util.TreeSet;

/*
 * Demo of Tree sets.
 *
 * A tree set is an ordered set. Insertions, deletions, and searches on the ordered set require O(log n) time,
 * based on the number of elements in the set. There are additional methods than just what Hash sets contain.
 *
 * https://www.geeksforgeeks.org/set-in-java/
 * https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
 */

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1); // [1]
        set.add(14); // [1, 14]
        set.add(9); // [1, 9, 14]
        set.add(2); // [1, 2, 9, 14]

        System.out.println(set.higher(7)); // 9
        System.out.println(set.higher(9)); // 14
        System.out.println(set.lower(5)); // 2
        System.out.println(set.first()); // 1
        System.out.println(set.last()); // 14
        set.remove(set.higher(6)); // [1, 2, 14]
        System.out.println(set.higher(23)); // ERROR, no such element exists
    }
}
