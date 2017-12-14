package datastructure.stack;

public class StackMain {
    public static void main(String[] args) {
        StackArray sa = new StackArray();
        sa.push(1);
        sa.push(2);
        sa.push(3);

        System.out.println(sa.pop());
        System.out.println(sa.peek());
        System.out.println(sa.isEmpty());

        Stack<String> sl = new StackList<String>();
        sl.push("one");
        sl.push("two");
        sl.push("three");

        System.out.println(sl.pop());
        System.out.println(sl.peek());
        System.out.println(sl.isEmpty());

    }
}
