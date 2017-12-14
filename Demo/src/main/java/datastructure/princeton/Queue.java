package datastructure.princeton;


import datastructure.StdOut;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class Queue<Item> implements Iterable<Item> {
    private int N;
    private Node first;
    private Node last;

    private class Node {
        public Item item;
        public Node next;
    }

    public Queue() {
        first = null;
        last = null;
        N = 0;
    }

    public boolean isEmpty() {
        return first == null; //or N==0
    }

    public void enQueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.item;
    }

    public int size() {
        return N;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + "-->");
        }
        return s.toString();
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        Node current = first;

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

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        queue.enQueue("to");
        queue.enQueue("be");
        queue.enQueue("or");
        queue.enQueue("not");
        queue.enQueue("to");
        queue.enQueue("be");

        System.out.println(queue.size());

        System.out.println(queue.deQueue());
        System.out.println(queue.peek());
        System.out.println(queue.toString());

        StdOut.print(queue.toString());
    }
}
