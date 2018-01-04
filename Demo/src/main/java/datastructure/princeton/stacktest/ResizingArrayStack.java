package datastructure.princeton.stacktest;

import datastructure.utils.StdIn;
import datastructure.utils.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] items;
    private int N;

    /**
     * 构造方法
     */
    public ResizingArrayStack() {
        items = (Item[]) new Object[1];
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 栈的大小
     *
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 重新定义数组大小
     *
     * @param max
     */
    private void resize(int max) {
        assert max >= N;
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = items[i];
        }
        items = temp;

    }

    /**
     * 压栈
     *
     * @param item
     */
    public void push(Item item) {
        if (N == items.length) {
            resize(2 * N);
        }
        items[N++] = item;
    }

    /**
     * 弹栈
     *
     * @return
     */
    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack overflow error");
        }
        Item item = items[N - 1];
        items[N - 1] = null;//防止游离
        N--;
        if (N > 0 && N == items.length / 4) {
            resize(items.length / 2);
        }
        return item;

    }

    /**
     * 实现迭代
     *
     * @return 迭代器
     */
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    /**
     * 用内部类实现迭代器
     */
    private class ReverseArrayIterator implements Iterator<Item> {
        private int index = N;

        public boolean hasNext() {
            return index > 0;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[--index];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> s = new ResizingArrayStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!"-".equals(item)) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }

        StdOut.print("(" + s.size() + " left on stack)");

    }
}
