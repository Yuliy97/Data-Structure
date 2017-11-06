import java.util.NoSuchElementException;
/**
 *
 * @author Yuli Liu
 * @version 1.0
 */
public class SinglyLinkedList<T> implements LinkedListInterface<T> {
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int size;

    @Override
    public void addAtIndex(int index, T data) {
        if (data == null) {
            throw new IllegalArgumentException("Null data passed!");
        } else if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index less than 0 or "
                    + "greater than size.");
        } else if (index == 0) {
            addToFront(data);
        } else if (index == size) {
            addToBack(data);
        } else {
            LinkedListNode<T> temp = new LinkedListNode<T>(data);
            LinkedListNode<T> cur = head;
            for (int i = 1; i < index; i++) {
                cur = cur.getNext();
            }
            temp.setNext(cur.getNext());
            cur.setNext(temp);
            size++;
        }

    }

    @Override
    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Null element passed!");
        }
        head = new LinkedListNode<T>(data, head);
        size++;
        if (tail == null) {
            tail = head;
        }
    }

    @Override
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Null element passed!");
        } else if (size == 0) {
            addToFront(data);
        } else {
            tail.setNext(new LinkedListNode<T>(data, null));
            tail = temp;
            size++;
        }
    }

    @Override
    public T removeAtIndex(int index) {
        LinkedListNode<T> cur;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(("Index less than zero or "
                    + "greater than or equal to size"));
        } else if (index == 0) {
            return removeFromFront();
        } else {
            cur = head;
            for (int i = 1; i < index; i++) {
                cur = cur.getNext();
            }
            LinkedListNode<T> temp = cur.getNext().getNext();
            T item = cur.getNext().getData();
            cur.setNext(temp);
            if (index == size - 1){
                tail = cur;
            }
            size--;
            return item;
        }
    }

    @Override
    public T removeFromFront() {
        if (size == 0) {
            return null;
        } else {
            LinkedListNode<T> temp = head;
            head = temp.getNext();
            if (head == null) {
                tail = head;
            }
            size--;
            return temp.getData();
        }
    }

    @Override
    public T removeFromBack() {
        LinkedListNode<T> temp = head;
        if (size == 0) {
            return null;
        }
        return removeAtIndex(size - 1)
    }

    @Override
    public T removeFirstOccurrence(T data) {
        if (size == 0) {
            throw new IllegalArgumentException("Empty List!");
        } else {
            LinkedListNode<T> cur = head;
            if (head.getData().equals(data)) {
                head = head.getNext();
                return cur.getData();
            }
            while (cur != tail) {
                if (cur.getNext().getData().equals(data)) {
                    cur.setNext(cur.getNext().getNext());
                    return cur.getNext().getData();
                }
                cur = cur.getNext();
            }
            throw new NoSuchElementException("Element donot exit in the list!");
        }

    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index less than zero or "
                    + "greater than or equal to size!");
        } else if (index == 0) {
            return head.getData();
        } else if (index == size - 1) {
            return tail.getData();
        } else {
            LinkedListNode<T> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            return temp.getData();
        }
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        LinkedListNode<T> cur = head;
        for (int i = 0; i < size; i++) {
            array[i] = cur.getData();
            cur = cur.getNext();
        }
        return array;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public LinkedListNode<T> getHead() {
        return head;
    }

    @Override
    public LinkedListNode<T> getTail() {
        return tail;
    }
}
