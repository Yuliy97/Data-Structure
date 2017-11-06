/**
 * Interface detailing the methods required for implementing a stack.
 */
public interface StackInterface<T> {

    public static final int INITIAL_CAPACITY = 11;

    boolean isEmpty();

    T pop();

    void push(T data);

    int size();
}
