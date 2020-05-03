package hashtable;

import java.util.HashMap;
import java.util.Map;

/*
 * Demonstration of Hashmaps in the JDK
 *
 * Hashtables are synchronized, while maps aren't. Don't use hashtables unless synchronization is needed
 */

public class JDKMap {
    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        Map<String, Employee> hashMap = new HashMap<>();
        hashMap.put("Jones", janeJones);
        hashMap.put("Doe", johnDoe);
        hashMap.put("Smith", marySmith);

        hashMap.putIfAbsent("Doe", mikeWilson); // Will only put if key is available, also returns employee at that existing key

        System.out.println(hashMap.get("Smith"));
        System.out.println(hashMap.getOrDefault("someone", mikeWilson));

    }
}
