import java.util.NoSuchElementException;

/**
 *
 * @author Yuli Liu
 * @version 1.0
 */
public class LinkedStack<T> implements StackInterface<T> {

    private LinkedNode<T> head;
    private int size;

    /**
     * Return true if the stack is empty
     */
    public boolean isEmpty() {
        return size <= 0;
    }

    /**
     *Pop from the stack
     */
    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("The list is empty!");
        }
        LinkedNode<T> temp = head;
        head = head.getNext();
        size--;
        return temp.getData();
    }

    /**
     * Push the data into the stack
     */
    public void push(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Null data passed!");
        } else if (size == 0) {
            head = new LinkedNode<T>(data, null);
            size++;
        } else {
            head = new LinkedNode<T>(data, head);
            size++;
        }
    }

    /**
     * Return the size of the stack
     */
    public int size() {
        return size;
    }
}
