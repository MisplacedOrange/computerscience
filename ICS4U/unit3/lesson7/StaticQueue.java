/*
Author: Roy Lu
Date: November 5th, 2026
Description: Stores queue elements in a fixed-size array in first-in, first-out order.
*/

import java.util.Arrays;

public class StaticQueue<T> implements QueueADT<T> {
    private final Object[] elements;
    private int count;

    public StaticQueue(int capacity) {
        elements = new Object[Math.max(0, capacity)];
    }

    public void enqueue(T element) {
        if (count < elements.length) {
            elements[count++] = element;
        }
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T first = (T) elements[0];
        System.arraycopy(elements, 1, elements, 0, --count);
        elements[count] = null;
        return first;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        return isEmpty() ? null : (T) elements[0];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, count));
    }
}
