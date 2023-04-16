package BookQueue;

import Books.Books;
import BorrowingSystem.*;
import Books.WaitingListFormat;


public interface BookQueue {

    /**
     * Adds an element at the back of the queue
     *
     * @param newElement
     * @return false is capacity full
     */
    public boolean Enqueue(WaitingListFormat newElement);

    /**
     * Removes an element from the front of the queue
     *
     * @return null if queue is empty
     */
    public WaitingListFormat Dequeue();

    /**
     * First element of the queue without removing it
     *
     * @return null if empty
     */
    public String First();

    /**
     * Last element of the queue without removing it
     *
     * @return null if empty
     */
    public String Last();

    /**
     * Number of elements in the queue
     *
     * @return
     */
    public int size();

    /**
     * True if there is no elements in the queue
     *
     * @return
     */
    public boolean isEmpty();
    
     /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    public WaitingListFormat peek();

}
