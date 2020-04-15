package stack;

import java.util.EmptyStackException;

/*
 * Stacks are LIFO (Last in, first out)
 *
 * The top of the stack is the end of the array and the top is a number representing the length of the backing array.
 *
 * Push(): Adds element to the top of the stack
 * Pop(): Removes element from the top of the stack
 * Peek(): Returns element at the top of the stack
 */

public class EmployeeArrayStack {
    private Employee[] stack;
    private int top;

    public EmployeeArrayStack(int capacity) {
        stack = new Employee[capacity];
    }

    public void push(Employee employee) {
        if (top == stack.length) {
            // need to resize the backing array
            Employee[] newArray = new Employee[2 * stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }

        stack[top++] = employee;
    }

    public Employee pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        Employee employee = stack[--top];
        stack[top] = null;
        return employee;
    }

    public Employee peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void printStack() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

}
