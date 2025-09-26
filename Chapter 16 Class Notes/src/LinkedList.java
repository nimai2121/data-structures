import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList
{

    // first refers to the first node in the list
    // if the list is empty, first will be null
    //creating a class inside of class makes it only accessible to the outer class

    private Node first;

    /**
        Constructs an empty linked list.
    */

    public LinkedList()
    {
        this.first = null; //the only thing we need to construct an empty linked list
    }


    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */

    public Object getFirst() {
        if (this.first == null) {
            throw new NoSuchElementException(); //if first element is null, throw exception
        }
        return this.first.data;
    }




    /**
        Removes the first element in the linked list.
        @return the removed element


    */

    public Object removeFirst() {
        if (this.first == null) {
            throw new NoSuchElementException(); //if first element is null, throw exception
        } 
        //remove the first element in the linked list

        Object n1data = this.first.data; //store the data of the first node
        this.first = this.first.next; //update first to point to the next node      
        return n1data; //return the data of the removed node


    }




    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */

    public void addFirst(Object element) {
        Node newNode = new Node(); //create a new node
        newNode.data = element; //set the data of the new node to the element
        newNode.next = this.first; //set the next of the new node to the current first node
        this.first = newNode; //update first to point to the new node 
    }




    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */

    public LinkedListIterator listIterator() {
        return new LinkedListIterator();
    }




    //Class Node
    //Node is static because it does NOT need to access anything in LinkedList
    //The object will store information, not interact.  
    //class that stores information, doesn't have/need methods, so its static 

    static class Node {
        public Node next; 
        public Object data;
    }

    class LinkedListIterator implements ListIterator
    {
      //private data
      private Node position;
      private Node previous;
      private boolean isAfterNext;


        /**
            Constructs an iterator that points to the front
            of the linked list.
        */

        public LinkedListIterator() {
            position = null; 
            previous = null; 
            isAfterNext = false;
        }


        /**
            Moves the iterator past the next element.
            @return the traversed element
        */

        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            previous = position; 

            if (position == null) {
                position = first; 
            }
            else {
                position = position.next;
            }

            isAfterNext = true; 

            return position.data;
        }






        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */
        public boolean hasNext() {
            // check if the list is empty 
            if (position == null) {
                return first != null;
            }

            // the iterator has moved so check the next node 
            return position.next != null;
        }


        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */

        public void add(Object element) {
            // check if the iterator is at the beginning of the list 
            if (position == null) {
                addFirst(element);
                position = first;
            } else {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;

                // set the next element of the CURRENT position to point to our new node 
                position.next = newNode;
                position = newNode;
            }

            isAfterNext = false;
        }






        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */

        public void remove() {
            if (!isAfterNext) {
                throw new IllegalStateException();
            }

            //check if the iterator is at the beginning
            if (position == first) {
                removeFirst();
                position = null;
            } else {
                previous.next = position.next;
                position = previous;
            }
            isAfterNext = false;

        }


        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */


    }//LinkedListIterator
}//LinkedList
