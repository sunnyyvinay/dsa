package extras;

import java.util.*;

/*
 * JDK demo of sets.
 *
 * A set is an unordered collection of objects in which duplicate values cannot be stored.
 *
 * https://www.geeksforgeeks.org/set-in-java/
 * https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
 */

public class SetDemo {
    public static void main(String[] args) {
        // Create empty Set using HashSet
        Set<String> hash_Set = new HashSet<>();
        hash_Set.add("Geeks");
        hash_Set.add("For");
        hash_Set.add("Geeks");
        hash_Set.add("Example");
        hash_Set.add("Set");
        System.out.print("Set output without the duplicates");
        System.out.println(hash_Set);


        // Demonstration of union, intersection, and difference using sets
        Set<Integer> a = new HashSet<>();
        a.addAll(Arrays.asList(new Integer[] {1, 3, 2, 4, 8, 9, 0}));
        Set<Integer> b = new HashSet<>();
        b.addAll(Arrays.asList(new Integer[] {1, 3, 7, 5, 4, 0, 7, 5}));

        // To find union
        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);
        System.out.print("Union of the two Set");
        System.out.println(union);

        // To find intersection
        Set<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        System.out.print("Intersection of the two Set");
        System.out.println(intersection);

        // To find the symmetric difference
        Set<Integer> difference = new HashSet<>(a);
        difference.removeAll(b);
        System.out.print("Difference of the two Set");
        System.out.println(difference);
    }
}
