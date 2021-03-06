import java.util.NoSuchElementException;

/**
 * Your implementation of an array-backed queue.
 *
 * @author Yuli Liu
 * @version 1.0
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    // Do not add new instance variables.
    private T[] backingArray;
    private int front;
    private int back;
    private int size;

    /**
     * Constructs a new ArrayQueue.
     */
    public ArrayQueue() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
        front = 0;
        back = 0;
    }

    /**
     * Dequeue from the front of the queue.
     *
     * Do not shrink the backing array.
     * If the queue becomes empty as a result of this call, you must not
     * explicitly reset front or back to 0.
     *
     * @see QueueInterface#dequeue()
     */
    @Override
    public T dequeue() {
        if (size <= 0) {
            throw new NoSuchElementException("The array is empty!");
        } else {
            T temp = backingArray[front];
            backingArray[front] = null;
            front = ++front % backingArray.length;
            size--;
            return temp;
        }
    }

    /**
     * Add the given data to the queue.
     *
     * If sufficient space is not available in the backing array, you should
     * regrow it to (double the current length) + 1; in essence, 2n + 1, where n
     * is the current capacity. If a regrow is necessary, you should copy
     * elements to the front of the new array and reset front to 0.
     *
     * @see QueueInterface#enqueue(T)
     */
    @Override
    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Null data passed!");
        } else if (size == backingArray.length) {
            T[] temp = (T[]) new Object[size * 2 + 1];  //why plus one?
            for (int i = 0; i < size; i++) {
                temp[i] = dequeue();
            }
            temp[size] = data;
            backingArray = temp;
            back = size;
            size++;
        } else {
            backingArray[back] = data;
            back = ++back % backingArray.length;
            size++;

        }
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the backing array of this queue.
     * Normally, you would not do this, but we need it for grading your work.
     *
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return the backing array
     */
    public Object[] getBackingArray() {
        // DO NOT MODIFY!
        return backingArray;
    }
}