package application;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            } 
            
            if (command.equals("1")) {
                list();
            } else if (command.equals("2")) {
                add();
            } else if (command.equals("3")) {
                markAsDone();
            } else if (command.equals("4")) {
                remove();
            }
        }

        System.out.println("Thank you!");
    }

    private void list() throws SQLException {
        System.out.println("Listing the database contents");
        database.list().stream().forEach(System.out::println);
    }

    private void add() throws SQLException {
        System.out.println("Adding a new todo\nEnter name");
        String name = scanner.nextLine();
        System.out.println("Enter description");
        String description = scanner.nextLine();

        database.add(new Todo(name, description, false));
    }

    private void markAsDone() throws SQLException {
        System.out.println("which todo should be marked as done (give the id)?");
        int id = scanner.nextInt();
        database.markAsDone(id);
    }

    private void remove() throws SQLException {
        System.out.println("Which todo should be removed (give the id)?");
        int id = scanner.nextInt();
        database.remove(id);
    }
}
