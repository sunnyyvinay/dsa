package queue;

/*
 * Implementation of Queue backed by an array. Queues follow FIFO (first in, first out). Front refers to the front of the array
 * and changes when calling remove(). Back is the back of the array and represents the length
 *
 * add(): Adds element to back of array
 * remove(): Removes element from front of the array
 * peek(): Returns element at the front of the array
 */

import java.util.NoSuchElementException;

public class EmployeeArrayQueue {
    private Employee[] queue;
    private int front;
    private int back;

    public EmployeeArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee) {
        if (back == queue.length) { // Resize array if full
            Employee[] newArray = new Employee[2 * queue.length];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }
        queue[back] = employee;
        back++;
    }

    public Employee remove() {
         if (size() == 0) {
             throw new NoSuchElementException();
         }
         Employee employee = queue[front];
         queue[front] = null;
         front++;

         if (size() == 1) {
             front = 0;
             back = 0;
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
        return back - front;
    }

    public void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }
}
