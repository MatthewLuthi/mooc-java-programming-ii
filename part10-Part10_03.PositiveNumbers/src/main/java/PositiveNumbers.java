
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        List<Integer> randomValues = new ArrayList<>();
//        randomValues.add(5);
//        randomValues.add(8);
//        randomValues.add(10);
//        randomValues.add(-1);
//        randomValues.add(-5);
//
//        System.out.println(positive(randomValues));
        
List<Integer> numbers = new ArrayList<>();
for (int i = 0; i < 10; i++) {
    numbers.add(i);
}

long howManyNumbers = numbers.stream()
    .filter(i -> i < 4)
    .map(i -> i * 2)
    .filter(i -> i > 10)
    .count();

System.out.println("Numbers: " + howManyNumbers);
        
    }

    public static List<Integer> positive(List<Integer> numbers) {
        return numbers.stream()
                .filter(value -> value > 0)
                .collect(Collectors.toCollection(ArrayList::new));

        //return numbers.stream().filter(number -> number > 0).collect(Collectors.toList());
    }
}
