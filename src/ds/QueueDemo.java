package ds;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Demo of a standard Queue.
 *
 * A queue is a First In First Out (FIFO) data structure that supports three operations: add(), poll(), peek().
 */

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>(); q.add(1); // [1]
        q.add(3); // [3, 1]
        q.add(4); // [4, 3, 1]
        q.poll(); // [4, 3]
        System.out.println(q.peek()); // 3
    }
}
