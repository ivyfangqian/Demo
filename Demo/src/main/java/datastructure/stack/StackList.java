package datastructure.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackList<T> implements Stack<T> {
    private List<T> list = null;

    public StackList() {
        this.list = new ArrayList<T>();
    }

    public T pop() {
        if (list.size() == 0) {
            throw new EmptyStackException();
        }
        return list.remove(list.size() - 1);
    }

    public void push(T element) {
        list.add(element);
    }

    public boolean isEmpty() {
        return (list.size() == 0);
    }

    public T peek() {
        if (list.size() == 0) {
            throw new EmptyStackException();
        }
        return list.get(list.size() - 1);
    }
}
