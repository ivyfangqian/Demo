import sun.font.TrueTypeFont;


public class StringOperation {

    /**
     * 判断一个字符串是不是回文字符串
     *
     * @param str
     * @return boolean
     * @author fangqian
     */
    private static boolean isPalindromic(String str) {
        boolean isPal = true;
        if (str.length() > 0 && str != null && str != "") {
            for (int i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                    isPal = false;
                }
            }
        }
        return isPal;
    }

    public static void main(String[] args) {
        String word = "hello";
        System.out.println(isPalindromic(word));
    }
}
