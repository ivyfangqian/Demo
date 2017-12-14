package datastructure.princeton;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 用链表的方式实现堆栈
 * 在链表的头部进行压栈和弾栈
 *
 * @param <Item>
 */
public class StackLinked<Item> implements Iterable<Item> {

    private int N;
    private Node first;


    /**
     * 链表的结点
     */
    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * 栈的构造函数
     */
    public StackLinked() {
        N = 0;
        first = null;
    }

    /**
     * 压栈
     *
     * @param element
     */
    public void push(Item element) {
        Node oldFirst = first;
        first = new Node();
        first.item = element;
        first.next = oldFirst;
        N++;
    }

    /**
     * 弾栈
     *
     * @return 弹出的栈的元素
     */
    public Item pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Item item = first.item;
        first = first.next;
        N--;
        return item;

    }

    /**
     * 判断栈是否为空
     *
     * @return 栈为空返回true，栈不为空返回false
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 返回栈顶元素
     *
     * @return 栈顶元素
     */
    public Item peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return first.item;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + "-->");
        }
        return s.toString();
    }

    /**
     * 栈的大小
     *
     * @return 栈的大小
     */
    public int size() {
        return N;
    }

    /**
     * 栈的计数器
     *
     * @return 栈的计数器
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
        StackLinked<String> stackLinked = new StackLinked<String>();
        stackLinked.push("to");
        stackLinked.push("be");
        stackLinked.push("or");
        stackLinked.push("not");
        stackLinked.push("to");
        stackLinked.push("be");

        System.out.println(stackLinked.toString());
        System.out.println(stackLinked.pop());

        System.out.println(stackLinked.size());
        System.out.println(stackLinked.peek());
        System.out.println(stackLinked.toString());
    }
}
