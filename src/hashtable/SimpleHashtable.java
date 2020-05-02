package hashtable;

/*
 * Implementation of a simple hashtable backed by an array, using Employee class
 *
 * Hashtables store key/value pairs. Before storing values, the key must be hashed. Collisions occur when two different values get hashed
 * to the same index. There are ways to deal with these collisions. Hashtables are best for retrieval because of constant time retrieval.
 * This implementation uses linear probing to handle collisions
 *
 * Linear probing handles collisions by moving up indexes until there is an empty spaces.
 */

public class SimpleHashtable {
    private StoredEmployee[] hashtable;

    public SimpleHashtable() {
        hashtable = new StoredEmployee[10];
    }

    // Add a key/value pair
    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        if (occupied(hashedKey)) { // linear probing
            int stopIndex = hashedKey; // Will keep probing and loop around until this index is hit
            if (hashedKey == hashtable.length - 1) { // wrap around
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex) { // loop for linear probing after checking if needed
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (occupied(hashedKey)) { // If array is full after linear probing
            System.out.println("Sorry, there's already an employee at position " + hashedKey);
        } else {
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    // Get value given key. This is done in O(1) time
    public Employee get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }
        return hashtable[hashedKey].employee;
    }

    public Employee remove(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }
        Employee employee = hashtable[hashedKey].employee;
        hashtable[hashedKey] = null;

        // Without this there would be a higher load factor
        // This rehashes the hashtable
        StoredEmployee[] oldHashtable = hashtable; // Create a temporary hashtable
        hashtable = new StoredEmployee[oldHashtable.length];
        for (int i = 0; i < oldHashtable.length; i++) {
            if (oldHashtable[i] != null) {
                put(oldHashtable[i].key, oldHashtable[i].employee);
            }
        }

        return employee;
    }

    // Hash the given key to a specific index
    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null
                && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        int stopIndex = hashedKey;
        if (hashedKey == hashtable.length - 1) { // wrap around
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stopIndex &&
                hashtable[hashedKey] != null &&
                !hashtable[hashedKey].key.equals(key)) { // linear probing to find employee with key
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        } else {
            return -1;
        }
    }

    private boolean occupied(int index) {
        return hashtable[index] != null;
    }

    public void printHashTable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] == null) {
                System.out.println("Empty");
            } else {
                System.out.println("Position " + i + ": " + hashtable[i].employee);
            }
        }
    }
}
