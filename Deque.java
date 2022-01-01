/* *****************************************************************************
 *  Name: Susan Tan
 *  Date: 07/08/2020
 *  Description: Stack/Queue via LinkedList (double)
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node rear;
    private int size;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    // construct an empty deque
    public Deque() {
        first = null;
        rear = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return this.size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("item cannot be null");
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        if (isEmpty()) {
            rear = first;
        }
        else {
            first.next = oldfirst;
            oldfirst.prev = first;
        }
        size++;
    }

    // add the item to the back
    // identical to Queue: linked-list implementation
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("item cannot be null");
        Node oldlast = rear;
        rear = new Node();
        rear.item = item;
        if (isEmpty()) {
            first = rear;
        }
        else {
            oldlast.next = rear;
            rear.prev = oldlast;
        }
        size++;
    }

    // remove and return the item from the front
    // identical to Queue: linked-list implementation
    public Item removeFirst() {
        if (isEmpty()) throw new java.util.NoSuchElementException("Empty Deque");
        Item fitem = first.item;
        first = first.next;
        size--;
        return fitem;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new java.util.NoSuchElementException("Empty Deque");
        Item litem = rear.item;

        // get rid of last element, have the rear point to the element before rear ??
        rear = rear.prev;  // IMP** only shifted the pointers)
        if (rear != null) rear.next = null;  // need to get rid of element

        size--;
        return litem;
    }


    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;
        private int ss = size;  // IMP* current != null will next reach next() for e

        public boolean hasNext() {
            return ss > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException("remove is not supported");
        }

        public Item next() {
            Item item = current.item;
            if (item == null) {
                throw new java.util.NoSuchElementException();
            }
            else {
                current = current.next;
            }
            ss--;
            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> dq = new Deque<String>();

        /*
        // Testing addFirst with removeFirst
        dq.addFirst("4");
        dq.addFirst("3");
        dq.addFirst("2");
        dq.addFirst("1");
        StdOut.println("Expected Size is 4 and Actual is " + dq.size());
        StdOut.println("Expected First is 1 and Actual is " + dq.removeFirst());
        StdOut.println("Expected Next is 2 and Actual is " + dq.removeFirst());
        StdOut.println("Expected Next is 3 and Actual is " + dq.removeFirst());
        StdOut.println("Expected Last is 4 and Actual is " + dq.removeFirst());
        StdOut.println("Expected Size is 0 and Actual is " + dq.size());

        // Testing addFirst with removeLast
        dq.addFirst("4");
        dq.addFirst("3");
        dq.addFirst("2");
        dq.addFirst("1");
        StdOut.println("Expected Size is 4 and Actual is " + dq.size());
        StdOut.println("Expected First is 4 and Actual is " + dq.removeLast());
        StdOut.println("Expected Next is 3 and Actual is " + dq.removeLast());
        StdOut.println("Expected Next is 2 and Actual is " + dq.removeLast());
        StdOut.println("Expected Last is 1 and Actual is " + dq.removeLast());
        StdOut.println("Expected Size is 0 and Actual is " + dq.size());

        // Testing addLast with removeFirst
        dq.addLast("a");
        dq.addLast("b");
        dq.addLast("c");
        dq.addLast("d");
        StdOut.println("Expected Size is 4 and Actual is " + dq.size());
        StdOut.println("Expected First is a and Actual is " + dq.removeFirst());
        StdOut.println("Expected Next is b and Actual is " + dq.removeFirst());
        StdOut.println("Expected Next is c and Actual is " + dq.removeFirst());
        StdOut.println("Expected Last is d and Actual is " + dq.removeFirst());
        StdOut.println("Expected Size is 0 and Actual is " + dq.size());

        // Testing addLast with removeLast
        dq.addLast("a");
        dq.addLast("b");
        dq.addLast("c");
        dq.addLast("d");
        StdOut.println("Expected Size is 4 and Actual is " + dq.size());
        StdOut.println("Expected First is d and Actual is " + dq.removeLast());
        StdOut.println("Expected Next is c and Actual is " + dq.removeLast());
        StdOut.println("Expected Next is b and Actual is " + dq.removeLast());
        StdOut.println("Expected Last is a and Actual is " + dq.removeLast());
        StdOut.println("Expected Size is 0 and Actual is " + dq.size());

        // Testing Iterator
        dq.addLast("I ");
        dq.addLast("need ");
        dq.addLast("help ");
        dq.addLast("please, ");
        dq.addLast("thanks.");

        Iterator<String> itr = dq.iterator();

        while (itr.hasNext()) {
            System.out.print(itr.next());
        } */

        dq.addLast("1");
        dq.addLast("2");
        StdOut.println("removed is " + dq.removeLast());

        Iterator<String> itr = dq.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }


    }
}
