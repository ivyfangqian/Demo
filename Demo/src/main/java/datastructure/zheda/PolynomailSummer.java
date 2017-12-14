package datastructure.zheda;

import java.lang.Math;

/**
 * 求多项式的和的效率研究
 * @
 */
public class PolynomailSummer {
    public static void main(String[] args) {
        double x = 1.1;

        //多项式的项数，即最大值加1
        int n = 10;
        double[] array = new double[n];
        initArray(array);
        long startTime = System.currentTimeMillis();
        double sum1 = 0;

        //直接计算多项式的和
        for (int i = 0; i < 1000000; i++) {
            sum1 = poly1(n-1, array, x);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(sum1 + " 耗时：" + (endTime - startTime) + "ms");


        //通过结合律来计算多项式的和
        long startTime2 = System.currentTimeMillis();
        double sum2 = 0;
        for (int i = 0; i < 1000000; i++) {
            sum2 = poly2(n-1, array, x);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println(sum2 + " 耗时：" + (endTime2 - startTime2) + "ms");

    }

    /**
     * 通过结合律来计算多项式的和
     * @param n
     * @param array
     * @param x
     * @return 多项式的和
     */
    private static double poly2(int n, double[] array, double x) {
        double sum2 = array[n];
        for (int i = n; i > 0; i--) {
            sum2 = x*sum2 +array[i-1];
        }
        return sum2;
    }

    /**
     * 初始化数组
     *
     * @param array
     */
    private static void initArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    /**
     * 求ai*x^i的多项式的和
     *
     * @param n
     * @param array
     * @param x
     * @return 多项式的和
     */
    private static double poly1(int n, double[] array, double x) {
        double sum1 = array[0];
        for (int i = 1; i <= n; i++) {
            sum1 += (array[i] * Math.pow(x, i));
        }
        return sum1;
    }

}
