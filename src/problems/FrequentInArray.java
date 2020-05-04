package problems;

/*
 * Find the number the occurs the most frequently in the array.
 */

import java.util.HashMap;
import java.util.Map;

public class FrequentInArray {
    public static void main(String[] args) {
        // mostFrequent(array1) should return 1.
        int[] array1 = {1, 3, 1, 3, 2, 1};
        System.out.println(most_frequent(array1));

        // mostFrequent(array2) should return 3.
        int[] array2 = {3, 3, 1, 3, 2, 1};
        System.out.println(most_frequent(array2));

        // mostFrequent(array3) should return null.
        int[] array3 = {};
        System.out.println(most_frequent(array3));

        // mostFrequent(array4) should return 0.
        int[] array4 = {0};
        System.out.println(most_frequent(array4));

        // mostFrequent(array5) should return -1.
        int[] array5 = {0, -1, 10, 10, -1, 10, -1, -1, -1, 1};
        System.out.println(most_frequent(array5));
    }

    public static Integer most_frequent(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer max = -1;
        Integer maxNum = null;
        for (int i : arr) {
            if (map.containsKey(i)) {
                Integer newVal = map.get(i) + 1;
                map.put(i, newVal);
            } else {
                map.put(i, 1);
            }

            if (map.get(i) > max) {
                max = map.get(i);
                maxNum = i;
            }
        }
        return maxNum;
    }
}
