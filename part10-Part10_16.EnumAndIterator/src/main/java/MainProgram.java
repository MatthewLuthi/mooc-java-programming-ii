
public class MainProgram {

    public static void main(String[] args) {
        Employees employees = new Employees();
        employees.add(new Person("Arto", Education.PHD));
        employees.add(new Person("Pekka", Education.BA));
        employees.add(new Person("Matti", Education.PHD));

        employees.fire(Education.PHD);
         employees.print();

    }
}
