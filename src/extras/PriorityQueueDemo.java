package extras;

import java.util.PriorityQueue;

/*
 * JDK demo of priority queue.
 *
 * In priority queues, objects are sorted based on priority or natural order. The "head" is always the smallest value and the
 * "tail" is the largest.
 *
 * https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html
 * https://www.geeksforgeeks.org/priority-queue-class-in-java-2/
 */

public class PriorityQueueDemo {
    public static void main(String[] args) {
        // Creating empty priority queue
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        // Adding items to the pQueue using add()
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);

        // Printing the top element of PriorityQueue
        System.out.println(pQueue.peek());

        // Printing the top element and removing it
        // from the PriorityQueue container
        System.out.println(pQueue.poll());

        // Printing the top element again
        System.out.println(pQueue.peek());
    }
}
