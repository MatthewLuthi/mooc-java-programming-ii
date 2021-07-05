
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, String> map = new HashMap<>();
        map.add("bb", "Bumblebee");
        map.add("op", "Optimus Prime");
        map.add("megs", "Megatron");
        map.add("str", "Starscream");
        map.add("bar", "Barricade");
        map.add("bo", "Blackout");
        
        System.out.println(map.get("bb"));
        System.out.println(map.get("op"));
        System.out.println(map.get("megs"));
    }

}
