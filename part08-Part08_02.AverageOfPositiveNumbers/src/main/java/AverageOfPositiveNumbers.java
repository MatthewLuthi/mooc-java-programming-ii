
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0, count = 0;
        while (true) {
            int n = Integer.valueOf(scanner.nextLine());
            if (0 == n) {
                break;
            }
            
            if (n > 0) {
                sum += n;
                count++;
            }
        }
        
        if (sum < 1) {
            System.out.println("Cannot calculate the average");
        } else {
            System.out.println(1.0 * sum / count);
        }
    }
}
