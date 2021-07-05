/**
 *
 * @author Matt
 */
public class Hideout<T> {
    
    private T inHiding;
    
    public void putIntoHideout(T toHide) {
        inHiding = toHide;
    }
    
    public T takeFromHideout() {
        T previouslyInHiding = inHiding;
        inHiding = null;
        return previouslyInHiding;
    }
    
    public boolean isInHideout() {
        return inHiding != null;
    }
}
