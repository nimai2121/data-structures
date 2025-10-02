/**
    Add a method lastToFirst to this implementation of a queue.
    The method moves the element at the tail of the queue
    to the head.
*/
public class LinkedListQueue
{
    private Node head;
    private Node tail;
    private int size;

    /**
        Constructs an empty queue.
    */
    public LinkedListQueue()
    {
        head = null;
        tail = null;
       // size = 0;
    }

    /**
        Moves the tail of the queue to the head.
    */
    public void lastToFirst()
    {
        //. . .

        /*for (int i = 0; i < 5; i++) {
            Object n = this.remove();
            add(n);
        }*/

        if (head != null && head != tail) { //not already having the head at the tail.
            Node current = head; //current head its on
            // Traverse to the node just before the tail
            while (current.next != tail) {
                current = current.next;
            }
            Node oldTail = tail; // store old tail
            tail = current; // update tail to the node before the old tail
            tail.next = null; // set new tail's next to null
            oldTail.next = head; // link old tail to the front of the list
            head = oldTail; // update head to be the old tail
        }

    }

    /**
        Checks whether this queue is empty.
        @return true if this queue is empty
    */
    public boolean empty()
    {
        return head == null;
    }

    /**
        Adds an element to the tail of this queue.
        @param newElement the element to add
    */
    public void add(Object newElement)
    {
        if (tail == null)    // head must also be null
        {
            Node newNode = new Node();
            newNode.data = newElement;
            newNode.next = null;
            tail = newNode;
            head = newNode;
            //size++;
        }
        else
        {
            Node newNode = new Node();
            newNode.data = newElement;
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
            //size++;
        }
    }

    /**
        Removes an element from the head of this queue.
        @return the removed element
    */
    public Object remove()
    {
        if (head == null)
            return null;
        Object element = head.data;
        head = head.next;
        if (head == null)    // queue is empty
        {
            tail = null;
        }
        return element;
    }

    class Node
    {
        public Object data;
        public Node next;
    }
}
