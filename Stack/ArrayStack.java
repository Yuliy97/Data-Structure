import java.util.NoSuchElementException;

/**
 *
 * @author Yuli Liu
 * @version 1.0
 */
public class ArrayStack<T> implements StackInterface<T> {

    private T[] backingArray;
    private int size;

    /**
     * Constructs a new ArrayStack.
     */
    public ArrayStack() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Return true if the stack is empty
     */
    public boolean isEmpty() {
        return size <= 0;
    }

   
    /**
     * Pop from the stack.
     */
    public T pop() {
        if (size <= 0) {
            throw new NoSuchElementException("The Array is empty!");
        }
        size--;
        T temp = backingArray[size];
        backingArray[size] = null;
        return temp;
    }

    /**
     * Push the given data onto the stack.
     */
    public void push(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Null data passed!");
        } else if (size == backingArray.length) {
            T[] temp = (T[]) new Object[size * 2 + 1];
            for (int i = 0; i < size; size++) {
                temp[i] = backingArray[i];
            }
            backingArray = temp;
        }
        backingArray[size++] = data;
    }

    /**
     *Return the size of the stack
     */
    public int size() {
        return size;
    }

}
