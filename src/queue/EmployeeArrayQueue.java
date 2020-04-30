package queue;

/*
 * Implementation of a circularQueue backed by an array. Queues follow FIFO (first in, first out). Front refers to the front of the
 * array and changes when calling remove(). Back is the back of the array and represents the length. The circular queue allows the back
 * variable to loop around to the front of the array instead of having to increase the array size.
 *
 * add(): Adds element to back of array
 * remove(): Removes element from front of the array
 * peek(): Returns element at the front of the array
 */

import hashtable.Employee;

import java.util.NoSuchElementException;

public class EmployeeArrayQueue {
    private hashtable.Employee[] queue;
    private int front;
    private int back;

    public EmployeeArrayQueue(int capacity) {
        queue = new hashtable.Employee[capacity];
    }

    public void add(hashtable.Employee employee) {
        if (size() == queue.length-1) { // Resize array if full
            int numItems = size();
            hashtable.Employee[] newArray = new hashtable.Employee[2 * queue.length];

            System.arraycopy(queue, front, newArray, 0, queue.length-front);
            System.arraycopy(queue, 0, newArray, queue.length-1, back);

            queue = newArray;

            front = 0;
            back = numItems;
        }

        queue[back] = employee;
        if (back < queue.length - 1) {
            back++;
        } else {
            back = 0;
        }
    }

    public hashtable.Employee remove() {
         if (size() == 0) {
             throw new NoSuchElementException();
         }
         hashtable.Employee employee = queue[front];
         queue[front] = null;
         front++;

         if (size() == 1) {
             front = 0;
             back = 0;
         } else if (front == queue.length) {
            front = 0;
         }
         return employee;
    }

    public Employee peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public int size() {
        if (front <= back) {
            // queue has not wrapped
            return back - front;
        } else {
            return back - front + queue.length;
        }
    }

    public void printQueue() {
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        } else {
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            for (int i = 0; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
    }
}
