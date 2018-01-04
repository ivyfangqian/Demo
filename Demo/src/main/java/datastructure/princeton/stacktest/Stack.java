package datastructure.princeton.stacktest;

import sun.nio.cs.ext.ISCII91;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    /**
     * 内部私有类实现链表的结点
     */
    private class Node {
        Item item;
        Node next;
    }

    /**
     * 构造方法
     */
    public Stack() {
        first = null;
        N = 0;
    }

    /**
     * 判断是否为空
     *
     * @return 空返回true，非空返回false
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 栈的大小
     *
     * @return 栈元素的个数
     */
    public int size() {
        return N;
    }

    /**
     * 压栈
     *
     * @param item 压入的栈元素
     */
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    /**
     * 弾栈
     *
     * @return 弹出的栈元素
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
     * 实现集合的迭代函数
     *
     * @return 集合的迭代器
     */
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    /**
     * 获取栈顶元素
     *
     * @return 栈顶的元素，注意不进行弹出
     */
    public Item peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return first.item;
    }

    /**
     * 用内部类实现迭代器
     */
    private class StackIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
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
     * 琢磨着是个笨办法，待改进
     * @param s
     * @return
     */
    public static Stack copy(Stack s) {
        Stack temp = new Stack();
        Stack newStack = new Stack();
        for (Object item : s) {
            temp.push(s.pop());
        }
        for (Object item : temp) {
            newStack.push(temp.pop());
        }

        return newStack;
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        s.push("world");
        s.push("hello");

        System.out.println(s.toString());
        Stack<String> copyStack = Stack.copy(s);
        System.out.println(copyStack.toString());
    }
}
