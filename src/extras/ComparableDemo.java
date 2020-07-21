package extras;

/*
 * Demo of Comparable class used to sort custom objects or sort elements in a custom order
 *
 * Comparable is a function implemented within the class containing the custom object.
 */

public class ComparableDemo {
    public static void main(String[] args) {
        Person a = new Person(50, 80);
        Person b = new Person(40, 70);
        if (a.compareTo(b) > 0) System.out.println("Person A is taller than Person B");
        else if (a.compareTo(b) < 0) System.out.println("Person B is taller than Person A");
        else System.out.println("Person A and B are the same height.");
    }
}

class Person implements Comparable<Person> {
    int height, weight;
    public Person(int h, int w) {
        height = h; weight = w;
    }

    public int compareTo(Person p) {
        return Integer.compare(height, p.height);
    }
}
