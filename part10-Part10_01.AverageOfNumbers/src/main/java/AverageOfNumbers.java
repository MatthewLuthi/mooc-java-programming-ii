
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = new ArrayList<>();
        
        System.out.println("Input numbers, type \"end\" to stop.");
        
        while (true) {
            String read = scanner.nextLine();
            if (read.equals("end")) {
                break;
            }
            
            numbers.add(read);
        }

        double average = numbers.stream()
                .mapToInt(s -> Integer.valueOf(s))
                .average()
                .getAsDouble();
        
        System.out.println("average of the numbers: " + average);
        
        // If the collection is of type Integer and the input is added like 
        // numbers.add(Integer.valueOf(read); then we can do
        // input.stream().mapToInt(i -> i).average().getAsDouble() 
    }
}
