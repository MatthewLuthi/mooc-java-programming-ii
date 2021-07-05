/**
 *
 * @author Matt
 */
public class Person {
    private String name, address;
    
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    @Override
    public String toString() {
        return name + "\n  " + address;
    }
}
