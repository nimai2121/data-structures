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
        LinkedList<String> thing = new LinkedList<>();
        ListIterator<String> iterator = strings.listIterator();
        ListIterator<String> iterator2 = thing.listIterator();
        while (iterator.hasNext()) {
           // iterator
            //iterator.next(); //brings it all the way to the end
            String n = iterator.next();
            thing.addFirst(n);
            iterator.remove();
        }
        
        //System.out.println(thing);

        for (String n: thing) {
            strings.add(n);
            //System.out.print(n + " ");
        } 

        //System.out.println(thing);


        
        
       
            //while (iterator.hasPrevious()) {
                //System.out.println(iterator.addLast());
                //thing.addFirst(iterator.previous()); //errors
            //}

            
        
        
    }
}