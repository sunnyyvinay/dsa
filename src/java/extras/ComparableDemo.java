package extras;

/*
 * Demo of Comparable class used to sort custom objects or sort elements in a custom order
 *
 * Comparable is a function implemented within the class containing the custom object. To sort in decreasing order, use
 * -Integer.compare(x, y). Sorting by two criteria is also possible.
 *
 */

import java.util.Arrays;

public class ComparableDemo {
    public static void main(String[] args) {
        Person[] people = {new Person(30, 50), new Person(10, 20), new Person(100, 50),
                new Person(60, 40), new Person(30, 60)};
        Arrays.sort(people); // (10, 20), (30, 50), (30, 60), (60, 40), (100, 50)

        for (Person p : people) {
            System.out.println(p.height + " " + p.weight);
        }
    }

    static class Person implements Comparable<Person> {
        public int height, weight;
        public Person(int h, int w) {
            height = h; weight = w;
        }

        public int compareTo(Person p) {
            return Integer.compare(height, p.height);
        }
    }
}
