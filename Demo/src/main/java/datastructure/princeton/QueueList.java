package datastructure.princeton;

import datastructure.StdOut;

import java.util.ArrayList;

/**
 * 用ArrayList实现队列
 *
 * @param <Item>
 */
public class QueueList<Item> {
    private ArrayList<Item> queueList;

    /* 队列长度*/
    private int length;

    /**
     * 队列构造方法
     */
    public QueueList() {
        this.queueList = new ArrayList<Item>();
        length = 0;
    }

    /**
     * 清空队列
     */
    public void clear() {
        for (int i = 0; i < length; i++) {
            queueList.remove(i);
        }
        length = 0;
    }

    /**
     * 获取队列长度
     *
     * @return 队列长度
     */
    public int length() {
        return length;
    }

    /**
     * 入队操作
     *
     * @param element
     */
    public void enQueue(Item element) {
        queueList.add(element);
        length++;
    }

    /**
     * 出队操作
     *
     * @return 队列的头上第一个元素
     */
    public Item deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        Item item = queueList.remove(0);
        length--;
        return item;
    }

    /**
     * 判断队列是否为空
     *
     * @return 队列是否为空
     */
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : queueList) {
            s.append(item.toString());
        }
        return s.toString();
    }

    public static void main(String[] args) {
        QueueList<String> queueList = new QueueList<String>();
        queueList.enQueue("After ");
        queueList.enQueue("all ");
        queueList.enQueue("this ");
        queueList.enQueue("time");
        queueList.enQueue("! ");
        StdOut.println(queueList);
        StdOut.println(queueList.deQueue());
        queueList.enQueue("Always!");
        StdOut.println(queueList);
    }
}
