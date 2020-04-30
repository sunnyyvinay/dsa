package hashtable;

/*
 * Additional class for linear probing
 */

public class StoredEmployee {
    public String key; // not the hashed key
    public Employee employee;

    public StoredEmployee(String key, Employee employee) {
        this.key = key;
        this.employee = employee;
    }
}
