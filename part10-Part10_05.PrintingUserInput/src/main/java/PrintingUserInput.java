
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> rows = new ArrayList<>();
        
        while (true) {
            String read = scanner.nextLine();
            
            if (read.isEmpty()) {
                break;
            }
            
            rows.add(read);
        }

        rows.stream()
                .forEach(row -> System.out.println(row));
        
    }
}
