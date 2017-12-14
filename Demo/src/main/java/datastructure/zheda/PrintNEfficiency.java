package datastructure.zheda;


public class PrintNEfficiency {

    public static void main(String[] args) {
        int n = 20000;

        long startTime = System.currentTimeMillis();
        printNByFor(n);
        long endTime = System.currentTimeMillis();


        long startTimeR = System.currentTimeMillis();
        printNByReduce(n);
        long endTimeR = System.currentTimeMillis();

        System.out.println("for循环打印" + n + "个数字耗时：" + (endTime - startTime) + "ms!");
        System.out.println("reduce循环打印" + n + "个数字耗时：" + (endTimeR - startTimeR) + "ms!");
    }

    /**
     * for循环打印1-n
     * @param n
     */
    private static void printNByReduce(int n) {
        if (n >= 1) {
            printNByReduce(n - 1);
            System.out.println(n);
        }
    }

    /**
     * 递归打印1-n
     * @param n
     */
    private static void printNByFor(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }


}
