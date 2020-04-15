package stack;

/*
 * Demonstration of stack using a linked list. (See EmployeeLinkedStack.java for implementation)
 */

public class LinkedStack {
    public static void main(String[] args) {
        Employee sunnyvinay = new Employee("Sunny", "Vinay", 1234);
        Employee johndoe = new Employee("John", "Doe", 5678);
        Employee bendover = new Employee("Ben", "Dover", 1459);
        Employee marysmith = new Employee("Mary", "Smith", 8094);
        Employee mikewilson = new Employee("Mike", "Wilson", 7893);

        EmployeeLinkedStack stack = new EmployeeLinkedStack();
        stack.push(sunnyvinay);
        stack.push(johndoe);
        stack.push(bendover);
        stack.push(marysmith);
        stack.push(mikewilson);

        stack.printStack();
        System.out.println();

        System.out.println(stack.peek());
        System.out.println();

        stack.pop();
        stack.printStack();
    }
}
