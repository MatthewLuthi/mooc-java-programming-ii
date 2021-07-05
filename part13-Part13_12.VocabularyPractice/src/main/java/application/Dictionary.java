package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/**
 *
 * @author Matt
 */
public class Dictionary {
    
    private List<String> words;
    private Map<String, String> translations;

    public Dictionary() {
        this.words = new ArrayList<>();
        this.translations = new HashMap<>();

        add("sana", "word");
    }

    public String get(String word) {
        return this.translations.get(word);
    }

    public void add(String word, String translation) {
        if (!this.translations.containsKey(word)) {
            this.words.add(word);
        }

        this.translations.put(word, translation);
    }

    /**
     * Its possible to implement the random word function such that
     * you generate a new list of words from the hash map so you don't
     * need to maintain a separate list but this would slow the performance time.
     * @return 
     */
    public String getRandomWord() {
        Random random = new Random();
        return this.words.get(random.nextInt(this.words.size()));
    }
    
    public int wordCount() {
        return words.size();
    }
}
