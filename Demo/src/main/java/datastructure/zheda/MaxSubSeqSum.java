package datastructure.zheda;

public class MaxSubSeqSum {
    public static void main(String[] args) {
        int[] array = {4, -3, 5, -2, -1, 2, 6, -2, 5, 1};

        int maxSum1 = 0;

        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            maxSum1 = maxSubSeqSum1(array, array.length);
        }

        long endTime1 = System.currentTimeMillis();
        System.out.println("算法一，三层for循环得到最大子列和：" + maxSum1 + "，耗时：" + (endTime1 - startTime1) + "ms");


        int maxSum2 = 0;
        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            maxSum2 = maxSubSeqSum2(array, array.length);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("算法二，两层for循环得到最大子列和：" + maxSum2 + "，耗时：" + (endTime2 - startTime2) + "ms");


        int maxSum3 = 0;
        long startTime3 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            maxSum3 = maxSubSeqSum3(array, array.length);
        }
        long endTime3 = System.currentTimeMillis();
        System.out.println("算法三，两层for循环得到最大子列和：" + maxSum3 + "，耗时：" + (endTime3 - startTime3) + "ms");
    }

    /**
     * 在线处理的方式，一层for循环解决问题
     * @param array
     * @param n
     * @return
     */
    private static int maxSubSeqSum3(int[] array, int n) {
        int thisSum = 0;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            thisSum += array[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }

    /**
     * 三层for循环嵌套，复杂度是O(n^3)
     *
     * @param array
     * @param n
     * @return
     */
    private static int maxSubSeqSum2(int[] array, int n) {
        int thisSum = 0;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            thisSum = 0;
            for (int j = i; j < n; j++) {
                thisSum += array[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * 两层for循环嵌套，复杂度是O(n^2)
     *
     * @param array
     * @param n
     * @return
     */
    private static int maxSubSeqSum1(int[] array, int n) {
        int thisSum = 0;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {//i代表左边界
            for (int j = 0; j < n; j++) {//j代表右边界
                thisSum = 0;
                for (int k = i; k <= j; k++) {
                    thisSum += array[k];
                    if (thisSum > maxSum) {
                        maxSum = thisSum;
                    }
                }
            }
        }
        return maxSum;
    }

}
