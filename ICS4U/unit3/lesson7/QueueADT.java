/*
Author: Roy Lu
Date: November 5th, 2026
Description: Lists the operations supported by a generic queue.
*/

public interface QueueADT<T> {
    void enqueue(T element);
    T dequeue();
    T peek();
    boolean isEmpty();
    int size();
}
