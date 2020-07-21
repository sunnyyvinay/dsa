package extras;

/*
 * Demo of Comparator class used to sort custom objects or sort elements in a custom order
 *
 * Comparator is its own class. When sorting primitive types such as integers in a custom order, use the Integer object class
 * with Array.sort() and Comparator.
 */

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {
        Person2[] people = {new Person2(30, 50), new Person2(10, 20), new Person2(100, 50),
                            new Person2(60, 40), new Person2(30, 60)};
        Arrays.sort(people, new Comp()); // (10, 20), (30, 50), (30, 60), (60, 40), (100, 50)

        for (Person2 p : people) {
            System.out.println(p.height + " " + p.weight);
        }
    }
}

class Person2 {
    int height, weight;
    public Person2(int h, int w) {
        height = h; weight = w;
    }
}

class Comp implements Comparator<Person2> {
    public int compare(Person2 a, Person2 b) {
        if (a.height == b.height) {
            return Integer.compare(a.weight, b.weight);
        } else {
            return Integer.compare(a.height, b.height);
        }
    }
}
