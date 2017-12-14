package datastructure.stack;

import java.util.EmptyStackException;

public class StackArray {
    private static final int MAX_SIZE = 100;
    private int[] array = null;
    private int top = -1;

    public StackArray() {
        this.array = new int[MAX_SIZE];
        top = -1;
    }

    public void push(int element) {
        if (top == MAX_SIZE - 1) {
            throw new StackOverflowError();
        } else {
            array[++top] = element;
        }
    }

    public int pop() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return array[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int peek() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return array[top];
    }
}
