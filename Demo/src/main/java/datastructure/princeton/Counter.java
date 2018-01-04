package datastructure.princeton;

import datastructure.utils.StdOut;
import datastructure.utils.StdRandom;

public class Counter implements Comparable<Counter> {
    private String name;
    private int count;

    public Counter(String id) {
        name = id;
    }

    public void increment() {
        count++;
    }

    public int tally() {
        return count;
    }

    @Override
    public String toString() {
        return count + "  " + name;
    }


    public int compareTo(Counter that) {
        if (this.count < that.count) {
            return -1;
        } else if (this.count > that.count) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);

        Counter[] hits = new Counter[N];
        for (int i = 0; i < N; i++) {
            hits[i] = new Counter("counter" + i);
        }

        for (int i = 0; i < T; i++) {
            hits[StdRandom.uniform(N)].increment();
        }

        for (int i = 0; i < N; i++) {
            StdOut.println(hits[i]);
        }

    }
}
