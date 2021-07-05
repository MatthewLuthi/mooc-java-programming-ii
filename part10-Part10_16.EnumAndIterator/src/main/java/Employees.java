
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Matt
 */
public class Employees {
    private List<Person> employees;
    
    public Employees() {
        employees = new ArrayList<>();
    }
    
    public void add(Person personToAdd) {
        employees.add(personToAdd);
    }
    
    public void add(List<Person> peopleToAdd) {
        employees = Stream
                .concat(employees.stream(), peopleToAdd.stream())
                .collect(Collectors.toList());
    }
    
    public void print() {
        Iterator<Person> it = employees.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    
    public void print(Education education) {
        Iterator<Person> it = employees.iterator();
        while (it.hasNext()) {
            Person person = it.next();
            if (person.getEducation() == education) {
                System.out.println(person);
            }
        }
//        people.stream().forEach(person -> {
//            if (person.getEducation() == education) {
//                System.out.println(person);
//            }
//        });
    }
    
    public void fire(Education education) {
        Iterator<Person> iterator = employees.iterator();
        
        while (iterator.hasNext()) {
            if (iterator.next().getEducation() == education) {
                iterator.remove();
            }
        }
    }
}
