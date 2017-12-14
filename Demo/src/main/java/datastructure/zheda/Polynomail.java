package datastructure.zheda;

import java.util.ArrayList;

public class Polynomail {
    private int front;
    private int rear;

    public Polynomail() {
        this.front = 0;
        this.rear = 0;
    }

    public static void main(String[] args) {
        int[] p1 = {4, 3, 4, -5, 2, 6, 1};
        int[] p2 = {3, 5, 20, -7, 4, 3, 1};

        Polynomail polynomail1 = new Polynomail();
        Polynomail polynomail2 = new Polynomail();
        polynomail1.readPoly(p1);
        polynomail2.readPoly(p2);
        Polynomail multi = Polynomail.multiPoly(polynomail1, polynomail2);
        Polynomail sum = Polynomail.addPoly(polynomail1, polynomail2);
        ;

    }

    private static Polynomail addPoly(Polynomail polynomail1, Polynomail polynomail2) {
        return null;
    }

    private static Polynomail multiPoly(Polynomail polynomail1, Polynomail polynomail2) {
        return null;
    }


    private static void readPoly(int[] p1) {
        Polynomail poly = new Polynomail();
        int n = p1[0];
        for (int i = 0; i < n; i++) {
            int coef = p1[2 * i - 1];
            int expon = p1[2 * i];

            poly.attach(poly, coef, expon);


        }
    }

    private void attach(Polynomail poly, int coef, int expon) {


    }

}
