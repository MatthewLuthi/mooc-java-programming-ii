
import java.util.ArrayList;

/**
 *
 * @author Matt
 */
public class HashMap<K, V> {
    private ArrayList<Pair<K, V>>[] values;
    private int usedSlots;
    
    public HashMap() {
        values = new ArrayList[5];
        usedSlots = 0;
    }
    
    public V get(K key) {
         int hashValue = hashValueOf(key);
         if (values[hashValue] == null) {
             return null;
         }
         
         ArrayList<Pair<K, V>> valuesAtIndex = values[hashValue];
         
         for (int i = 0; i < valuesAtIndex.size(); i++) {
             if (valuesAtIndex.get(i).getKey().equals(key)) {
                 return valuesAtIndex.get(i).getValue();
             }
         } 
         
         return null;
    }
    
    public void add(K key, V value) {
        ArrayList<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        int index = getIndexOfKey(valuesAtIndex, key);
        
        if (index < 0) {
            valuesAtIndex.add(new Pair<>(key, value));
            usedSlots++;
        } else {
            valuesAtIndex.get(index).setValue(value);
        }
        
        // Grow the size of hashmap if the number of key-value pairs in it is greater than 75%
        if (1.0 * usedSlots / values.length > 0.75) {
            grow();
        }
    }
    
    private ArrayList<Pair<K, V>> getListBasedOnKey(K key) {
        int hashValue = hashValueOf(key);
        if (values[hashValue] == null) {
            values[hashValue] = new ArrayList<>();
        }
        
        return values[hashValue];
    }
    
    private int getIndexOfKey(ArrayList<Pair<K, V>> myList, K key) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getKey().equals(key)) {
                return i;
            }
        }
        
        return -1;
    }
    
    private void grow() {
        // Create a new array
        ArrayList<Pair<K, V>>[] newArray = new ArrayList[values.length * 2];
        
        for (int i = 0; i < values.length; i++) {
            // Copy the values of the old array into the new array
            copy(newArray, i);
        }
        
        // Replace the old array with the new one
        values = newArray;
    }
    
    private void copy(ArrayList<Pair<K, V>>[] newArray, int fromIdx) {
        //The problem is that in the array of Lists you only create a List instance in the slots/buckets when you add a key-value pair. Every unused slot/bucket in the array is null.
        //If you were to look at the contents of the field ArrayList<Pair<K, V>>[] values it would look something like [List@6833ce2c, null, null, List@7523be1c, ..., List@1234ad2c], where List@... represents a reference to a List<Pair<K, V>> object.
        //The way to deal with this is to check for null at the beginning of the copy method
        if (values[fromIdx] == null) {
            return;
        }
        
        for (int i = 0; i < values[fromIdx].size(); i++) {
            Pair<K, V> value = values[fromIdx].get(i);
            
            int hashValue = Math.abs(value.getKey().hashCode() % newArray.length);
            if (newArray[hashValue] == null) {
                newArray[hashValue] = new ArrayList<>();
            }
            
            newArray[hashValue].add(value);
            
        }
    }
    
    public V remove(K key) {
        ArrayList<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        if (valuesAtIndex.isEmpty()) {
            return null;
        }
        
        int index = getIndexOfKey(valuesAtIndex, key);
        if (index < 0) {
            return null;
        }
        
        Pair<K, V> pair = valuesAtIndex.get(index);
        valuesAtIndex.remove(pair);
        return pair.getValue();
    }
    
    private int hashValueOf(K key) {
        return Math.abs(key.hashCode() % values.length);
    }
}
