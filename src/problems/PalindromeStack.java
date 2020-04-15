package problems;

/*
 * Problem that uses stacks to determine whether or not a word is a palindrome.
 * It ignores punctuation, spaces, and case.
 */

import java.util.LinkedList;

public class PalindromeStack {
    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {
        string = string.replaceAll("[^A-Za-z]+", "").toUpperCase();
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));
        }
        StringBuilder reversedString = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        return reversedString.toString().equals(string.toString());
    }
}
