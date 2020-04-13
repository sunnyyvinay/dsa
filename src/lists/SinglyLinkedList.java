package lists;

/*
 * Program that demonstrates singly linked lists. It uses EmployeeNode as the Node class and EmployeeSinglyLinkedList as the class for the list
 * and its methods.
 * The head is the first element of the list and each element is called a Node. The Node has a reference to the current and next object.
 * The tail is the last element and its "next" is null.
 * Adding and deleting nodes from the front is all O(1) time complexity.
 */

public class SinglyLinkedList {
    public static void main(String[] args) {
        Employee sunnyvinay = new Employee("Sunny", "Vinay", 1234);
        Employee emilyluong = new Employee("Emily", "Luong", 4567);
        Employee bendover = new Employee("Ben", "Dover", 8901);
        Employee jackbrewer = new Employee("Jack", "Brewer", 8901);

        EmployeeSinglyLinkedList list = new EmployeeSinglyLinkedList();

        System.out.println(list.isEmpty());

        list.addToFront(sunnyvinay);
        list.addToFront(emilyluong);
        list.addToFront(bendover);
        list.addToFront(jackbrewer);

        System.out.println(list.getSize());

        list.printList();

        list.removeFromFront();
        System.out.println(list.getSize());
        list.printList();
    }
}
