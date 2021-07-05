package dictionary;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Matt
 */
public class SaveableDictionary {

    private Map<String, String> dictionary;
    private String file;

    public SaveableDictionary() {
        dictionary = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this();
        this.file = file;
    }

    public boolean load() {
        try {
            Files.lines(Paths.get(file))
                    .map(line -> line.split(":"))
                    .forEach(parts -> {
                        this.add(parts[0], parts[1]);
                    });
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(new File(file));
            saveWords(writer);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        
        return true;
    }

    private void saveWords(PrintWriter writer) throws IOException {
        List<String> alreadySaved = new ArrayList<>();
        dictionary.keySet().stream().forEach(word -> {
            if (alreadySaved.contains(word)) {
                return;
            }

            String pair = word + ":" + dictionary.get(word);
            writer.println(pair);

            alreadySaved.add(word);
            alreadySaved.add(dictionary.get(word));
        });

    }

    public void add(String words, String translation) {
        if (dictionary.containsKey(words)) {
            return;
        }

        dictionary.put(words, translation);
        dictionary.put(translation, words);
    }

    public String translate(String word) {
        return dictionary.get(word);
    }

    public void delete(String word) {
        String translation = this.translate(word);
        dictionary.remove(word);
        dictionary.remove(translation);
    }
}
