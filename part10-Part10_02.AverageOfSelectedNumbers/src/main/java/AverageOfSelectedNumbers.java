
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne

        List<Integer> input = new ArrayList<>();
        
        System.out.println("Input numbers, type \"end\" to stop.");
        String read = "";
        
        while (true) {
            read = scanner.nextLine();
            
            if (read.equals("end")) {
                break;
            }
            
            input.add(Integer.valueOf(read));
        }
        
        System.out.println("Print the avearge of the negative numbers or the positive numbers?(n/p)");
        read = scanner.nextLine();
        
        if (read.equals("n")) {
            double negativeNumberAverage = input.stream()
                    .mapToInt(i -> i)
                    .filter(number -> number < 0)
                    .average()
                    .getAsDouble();
            System.out.println("average of the numbers: " + negativeNumberAverage);
        }
        
        if (read.equals("p")) {
            double positiveNumberAverage = input.stream()
                    .mapToInt(i -> i)
                    .filter(number -> number > 0)
                    .average()
                    .getAsDouble();
            System.out.println("average of the numbers: " + positiveNumberAverage);
        }
    }
}
