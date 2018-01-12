package datastructure.leetCode;

public class ReverseDigits {
    public static void main(String[] args) {
        int x = 123;
        int reverse_int = reverseDigits(x);
        System.out.println(reverse_int);
        System.out.println(reverseDigits(-123));
        System.out.println(reverseDigits(1230));
        System.out.println(reverseDigits(-1230));
        System.out.println(reverseDigits(1534236469));


    }

    public static int reverseDigits(int x) {
        int res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }

        return res;

    }
}
