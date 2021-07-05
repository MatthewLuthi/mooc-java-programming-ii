
import java.util.Scanner;

/**
 *
 * @author Matt
 */
public class UserInterface {
    private Scanner scanner;
    private TodoList list;
    
    public UserInterface(TodoList list, Scanner scanner) {
        this.scanner = scanner;
        this.list = list;
    }
    
    public void start() {
        while (true) {
            System.out.print("Command: ");
            String command = scanner.nextLine();
            
            if (command.equals("add")) {
                System.out.print("To add: ");
                String task = scanner.nextLine();
                list.add(task);
            }
            
            if (command.equals("list")) {
                list.print();
            }
            
            if (command.equals("remove")) {
                System.out.print("Which one is removed? ");
                int nRemove = Integer.valueOf(scanner.nextLine());
                list.remove(nRemove);
            }
            
            if (command.equals("stop")) {
                break;
            }
        }
    }
}
