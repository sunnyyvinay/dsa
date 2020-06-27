package ds;

import java.util.PriorityQueue;

/*
 * Demo of Priority Queues
 *
 * In priority queues, objects are sorted based on priority or natural order. The lowest value is always at the front of the queue
 *
 *
 * https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html
 * https://www.geeksforgeeks.org/priority-queue-class-in-java-2/
 */

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(7); // [7]
        pq.add(2); // [7, 2]
        pq.add(1); // [7, 2, 1]
        pq.add(5); // [7, 5, 2, 1]

        System.out.println(pq.peek()); // 1
        pq.poll(); // [7, 5, 2]
        pq.poll(); // [7, 5]
        pq.add(6); // [7, 6, 5]
    }
}
