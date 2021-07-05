
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Matt
 */
public class DictionaryOfManyTranslations {

    private HashMap<String, ArrayList<String>> translations;
    
    public DictionaryOfManyTranslations() {
        translations = new HashMap<>();
    }

    public void add(String word, String translation) {
        translations.putIfAbsent(word, new ArrayList<String>());

        translations.get(word).add(translation);
    }
    
    public ArrayList<String> translate(String word) {
        return translations.getOrDefault(word, new ArrayList<String>());
    }

    public void remove(String word) {
        translations.remove(word);
    }
}
