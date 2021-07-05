
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        
        ArrayList<Result> results = new ArrayList<>();

        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(line -> line.split(","))
                    .map(result -> new Result(result[2].replace("(%)", "").trim(), result[3], Integer.valueOf(result[4]), Double.parseDouble(result[5])))
                    .forEach(result -> results.add(result));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        results.stream().sorted((r1, r2) -> {
            if (r1.getLiteracyPercent() > r2.getLiteracyPercent()) {
                return 1;
            }
            if (r1.getLiteracyPercent() < r2.getLiteracyPercent()) {
                return -1;
            }
            return 0;
        }).forEach(result -> System.out.println(result));
    }
}
