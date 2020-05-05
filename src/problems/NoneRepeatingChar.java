package problems;

/*
 * Return the first character in a String that does not repeat.
 */

import java.util.HashMap;

public class NoneRepeatingChar {
    public static void main(String[] args) {
        System.out.println(non_repeating("abcab"));
        System.out.println(non_repeating("abab"));
        System.out.println(non_repeating("aabbbc"));
        System.out.println(non_repeating("aabbdbc"));
    }

    private static Character non_repeating(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                Integer newVal = map.get(c) + 1;
                map.put(c, newVal);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : s.toCharArray()) {
            if (map.get(c) == 1) return c;
        }
        return null;
    }
}
