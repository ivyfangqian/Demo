package datastructure.princeton.queuetest;

import java.util.Iterator;

public class ResizingArrayQueue<Item> implements Iterable<Item> {
    private Item[] items;
    private int head;
    private int last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public ResizingArrayQueue() {
        items = (Item[]) new Object[1];
        head = last = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        if (N == items.length) {
            resize(2 * N);
        }
        items[N++] = item;
        last = N - 1;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        Item item = items[0];
        return item;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    public Iterator<Item> iterator() {
        return null;
    }
}
