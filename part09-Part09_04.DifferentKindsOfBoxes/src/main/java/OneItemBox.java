/**
 *
 * @author Matt
 */
public class OneItemBox extends Box {
    
    private Item singleItem;

    @Override
    public void add(Item item) {
        if (null == singleItem) {
            singleItem = item;
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return singleItem != null && singleItem.equals(item);
    }
}
