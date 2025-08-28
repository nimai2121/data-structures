import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        ListIterator<String> iterator = strings.listIterator();
        while (iterator.hasNext()) {
           // iterator
            iterator.next(); //brings it all the way to the end
        }
        
       
            while (iterator.hasPrevious()) {
                //System.out.println(iterator.addLast());
                strings.addLast(iterator.previous()); //errors
            }

            
        
        System.out.println();
        
        
    }
}