package ds;

import java.util.Stack;

/*
 * Demo of Stacks.
 *
 * A stack is a Last In First Out (LIFO) data structure that supports three operations: push(), pop(), and peek().
 */

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>(); s.push(1); // [1]
        s.push(13); // [1, 13]
        s.push(7); // [1, 13, 7]

        System.out.println(s.peek()); // 7
        s.pop(); // [1, 13]

        System.out.println(s.size()); // 2
    }
}
