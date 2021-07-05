
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

    }
    
    public static List<Book> readBooks(String file) {
        //List<Book> books = new ArrayList<>();
        
        try {
//            // Reading the file line by line
//            Files.lines(Paths.get(file))
//                    // Splitting the row into parts on the "," character
//                    .map(row -> row.split(","))
//                    // Deleting the split rows that have less than 4 parts (should always follow the format "name, publishing year, page count, author"
//                    .filter(parts -> parts.length >= 4)
//                    // Create book from the parts
//                    .map(parts -> new Book(parts[0], Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), parts[3]))
//                    // and finally add the book to the list
//                    .forEach(book -> books.add(book));

            return Files.lines(Paths.get(file))
                    .map(row -> row.split(","))
                    .map(parts -> new Book(parts[0], Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), parts[3]))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return new ArrayList<>();
        //return books;
    }

}
