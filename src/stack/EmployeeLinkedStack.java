package stack;

import java.util.LinkedList;
import java.util.ListIterator;

/*
 * Stacks are LIFO (Last in, first out)
 *
 * Implementation of stack data structure using a linked list. The top is always at the head of the backing linked list.
 * This uses the push, pop, and peek methods in the LinkedList class given by the JDK. It only has methods specific to the stack,
 * not the linked list because this would not be possible in a stack.
 */

public class EmployeeLinkedStack {
    private LinkedList<Employee> stack;

    public EmployeeLinkedStack() {
        stack = new LinkedList<Employee>();
    }

    public void push(Employee employee) {
        stack.push(employee);
    }

    public Employee pop() {
        return stack.pop();
    }

    public Employee peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printStack() { // Prints from the top (head) down
        ListIterator<Employee> iterator = stack.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
