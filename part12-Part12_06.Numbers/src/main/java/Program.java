
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("How many random numbers should be printed?");
        int amount = scanner.nextInt();
        
        Random r = new Random();
        for (int i = 0; i < amount; i++) {
            System.out.println(r.nextInt(11));
        }
    }

}
