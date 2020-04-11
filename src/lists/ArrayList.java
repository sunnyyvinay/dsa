package lists;

import java.util.List;
import java.util.Vector;

/*
 * Demonstrates ArrayList data structure using Employee class
 *
 * Most of these operations execute in O(1) time complexity, but can vary depending on where in the list. Array lists are not
 * synchronized. They aren't thread safe if used through multiple threads. Use Vector if you need synchronization.
 * Vectors and array lists use a backing array. Vectors are array lists, just with the overhead of synchronization.
 */

public class ArrayList {
    public static void main(String[] args) {
        List<Employee> employeeList = new java.util.ArrayList<>();
        //List<Employee> employeeList = new Vector<>();

        // Adds item to the end of the list
        employeeList.add(new Employee("Sunny", "Vinay", 1234));
        employeeList.add(new Employee("Emily", "Luong", 4567));
        employeeList.add(new Employee("Ben", "Dover", 8901));
        employeeList.add(new Employee("Jack", "Brewer", 8901));

        // Prints Employee object for each one in the list
        employeeList.forEach(employee -> System.out.println(employee));

        // Retrieves element given index
        System.out.println(employeeList.get(1));

        // Returns boolean value based on whether it is empty
        System.out.println(employeeList.isEmpty());

        //employeeList.set(3, new Employee("Leo", "Dooley", 4536));
        employeeList.forEach(employee -> System.out.println(employee));

        // Number of employees currently added, not the capacity of the list
        System.out.println(employeeList.size());

        // Adds item at specific index and shifts elements, could be O(n) if adding at 0 index
        employeeList.add(3, new Employee("Kim", "Crawford", 4579));
        employeeList.forEach(employee -> System.out.println(employee));

        // Turns list into its backing array and prints
        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
        for (Employee employee : employeeArray) {
            System.out.println(employee);
        }

        // Uses equal() method in Employee to compare employees
        System.out.println(employeeList.contains(new Employee("Emily", "Luong", 4567)));
        System.out.println(employeeList.indexOf(new Employee("Jack", "Brewer", 8901)));

        // Removes element at given index by shifting
        employeeList.remove(2);
        employeeList.forEach(employee -> System.out.println(employee));
    }
}
