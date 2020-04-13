package lists;

import java.util.Iterator;
import java.util.LinkedList;

/*
 * Demonstrates doubly linked lists in the JDK
 */

public class JDKLinkedLists {
    public static void main(String[] args) {
        Employee sunnyvinay = new Employee("Sunny", "Vinay", 1234);
        Employee emilyluong = new Employee("Emily", "Luong", 4567);
        Employee bendover = new Employee("Ben", "Dover", 8901);
        Employee jackbrewer = new Employee("Jack", "Brewer", 8901);
        Employee billEnd = new Employee("Bill", "End", 78);

        LinkedList<Employee> list = new LinkedList<>();
        list.addFirst(sunnyvinay); // adds to the beginning of the list
        list.addFirst(emilyluong);
        list.addFirst(bendover);
        list.addFirst(jackbrewer);

        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next());
        }

        list.add(billEnd); // adds to the end of the list
        iter = list.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next());
        }

        list.removeFirst(); // removes the head
        iter = list.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next());
        }

        list.removeLast(); // removes the tail
        iter = list.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next());
        }

        /*
        for (Employee employee: list) {
            System.out.println(employee);
        }
         */
    }

}
