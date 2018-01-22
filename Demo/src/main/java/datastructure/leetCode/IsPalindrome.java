package datastructure.leetCode;

public class IsPalindrome {
    public static void main(String[] args) {
        boolean res = isPalindrome(12321);
        System.out.println(res);
    }

    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = x;
        int res = 0;
        while (y != 0) {
            res = res * 10 + y % 10;
            y = y / 10;
        }
        return x == res;
    }

}
