package problems;

/*
 * Return true if one string is just one edit away from being another string. Edits include adding, deleting, or replacing a character in
 * the string
 */

public class OneAwayStrings {
    public static void main(String[] args) {
        System.out.println(isOneAway("abcde", "abcd"));  // should return true
        System.out.println(isOneAway("abde", "abcde"));  // should return true
        System.out.println(isOneAway("a", "a"));  // should return true
        System.out.println(isOneAway("abcdef", "abqdef"));  // should return true
        System.out.println(isOneAway("abcdef", "abccef"));  // should return true
        System.out.println(isOneAway("abcdef", "abcde"));  // should return true
        System.out.println(isOneAway("aaa", "abc"));  // should return false
        System.out.println(isOneAway("abcde", "abc"));  // should return false
        System.out.println(isOneAway("abc", "abcde"));  // should return false
        System.out.println(isOneAway("abc", "bcc"));  // should return false
    }

    private static boolean isOneAway(String s1, String s2) {
        if (s1.length() - s2.length() >= 2 || s2.length() - s1.length() >= 2) return false;
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        if (s1.length() == s2.length()) {
            int oneAway = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (a1[i] != a2[i]) {
                    oneAway--;
                }
            }
            if (oneAway >= -1) return true;
            else if (oneAway < -1) return false;
        }

        if (s1.length() > s2.length()) {
            int p1 = 0;
            int p2 = 0;
            int oneAway = 0;
            while (p1 < a1.length && p2 < a2.length) {
                if (a1[p1] == a2[p2]) {
                    p1++;
                    p2++;
                } else {
                    oneAway--;
                    p1++;
                }
            }
            if (oneAway >= -1) return true;
            else if (oneAway < -1) return false;
        } else {
            int p1 = 0;
            int p2 = 0;
            int oneAway = 0;
            while (p1 < a1.length && p2 < a2.length) {
                if (a1[p1] == a2[p2]) {
                    p1++;
                    p2++;
                } else {
                    oneAway--;
                    p2++;
                }
            }
            if (oneAway >= -1) return true;
            else if (oneAway < -1) return false;
        }
        return false;
    }
}

/* alternate solution
 public static Boolean isOneAway(String s1, String s2) {
        if (s1.length() - s2.length() >= 2 || s2.length() - s1.length() >= 2) {
            return false;
        } else if (s1.length() == s2.length()) {
            return isOneAwaySameLength(s1, s2);
        } else if (s1.length() > s2.length()) {
            return isOneAwayDiffLengths(s1, s2);
        } else {
            return isOneAwayDiffLengths(s2, s1);
        }
    }

    public static Boolean isOneAwaySameLength(String s1, String s2) {
        int countDiff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                countDiff += 1;
                if (countDiff > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // Assumption: s1.length() == s2.length() + 1
    public static Boolean isOneAwayDiffLengths(String s1, String s2) {
        int i = 0;
        int countDiff = 0;
        while (i < s2.length()) {
            if (s1.charAt(i + countDiff) == s2.charAt(i)) {
                i += 1;
            } else {
                countDiff += 1;
            }
            if (countDiff > 1) {
                return false;
            }
        }
        return true;
    }
 */
