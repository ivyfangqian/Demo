package datastructure.princeton.bagtest;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    /**
     * 背包结点
     */
    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * 背包的构造方法
     */
    public Bag() {
        first = null;
        N = 0;
        assert check();
    }

    /**
     * 检验背包是否异常
     *
     * @return 无异常返回true，有异常返回false
     */
    private boolean check() {
        if (N == 0) {
            return false;
        } else if (N == 1) {
            if (first == null) {
                return false;
            }
            if (first.next != null) {
                return false;
            }
        } else {
            if (first.next == null) {
                return false;
            }
        }
        int numbersOfNodes = 0;
        for (Node i = first; i != null; i = i.next) {
            numbersOfNodes++;
        }
        if (numbersOfNodes != N) {
            return false;
        }
        return true;
    }

    /**
     * 判断背包是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void add(Item element) {
        Node oldFirst = first;
        first = new Node();
        first.item = element;
        first.next = oldFirst;
        N++;
        assert check();
    }

    /**
     * 使背包实现foreach循环
     *
     * @return
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Bag<String> bag = new Bag<String>();
        bag.add("sping");
        bag.add("on");
        bag.add("one's");
        bag.add("feet");
        bag.add("!");
        for (String s : bag) {
            System.out.println(s);
        }
    }
}
