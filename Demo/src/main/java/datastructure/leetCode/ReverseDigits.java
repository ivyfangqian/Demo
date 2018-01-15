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

    /**
     * 两个正数数相加得到负数，或者两个负数相加得到正数，但某些编译器溢出或优化的方式不一样
     * 对于正数，如果最大整数减去一个数小于另一个数，或者对于负数，最小整数减去一个数大于另一个数，则溢出。这是用减法来避免加法的溢出。
     * 使用long来保存可能溢出的结果，再与最大/最小整数相比较
     *
     * @param x
     * @return
     */
    public static int reverseDigits(int x) {
        int res = 0;
        while (x != 0) {
            if (Math.abs(res) >Integer.MAX_VALUE/10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x = x / 10;
        }

        return res;

    }
}
