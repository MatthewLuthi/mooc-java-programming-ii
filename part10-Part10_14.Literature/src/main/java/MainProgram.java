
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Book> books = new ArrayList<>();

        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String name = scanner.nextLine();
            
            if (name.isEmpty()) {
                break;
            }
            
            System.out.print("Input the age recommendation: ");
            int ageRecommendation = Integer.parseInt(scanner.nextLine());
            System.out.println("");
            
            books.add(new Book(name, ageRecommendation));
        }

        System.out.println("\n" + books.size() + " books in total.\n");
        
        // Also valid implementation due to natural order without Book object implementing comparable interface
//        Comparator<Book> comparator = Comparator
//                .comparing(Book::getAgeRecommendation)
//                .thenComparing(Book::getName);
//        
//        Collections.sort(books, comparator);
//        books.stream().forEach(b -> System.out.println(b));
        books.stream().sorted().forEach(book -> System.out.println(book));
    }
}
