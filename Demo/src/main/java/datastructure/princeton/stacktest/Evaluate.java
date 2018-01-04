package datastructure.princeton.stacktest;

/**
 * Dijkstra的双栈算术表达式求值算法
 * ---------------------------------
 * @author fangqian
 * @date 2018/01/03
 * ----------------------------------
 * 定义两个栈，分别存放运算符与数字
 * 遇到左括号忽略，遇到右括号的时候，弹出两个操作数，弹出一个运算符进行计算，计算后结果再次压入操作数栈
 * 直到操作结束
 */
public class Evaluate {
    public static void main(String[] args) {
        StackLinked<Character> ops = new StackLinked<Character>();
        StackLinked<Double> vals = new StackLinked<Double>();

        String expression = "(1+((2+3)*(4*5)))";
        char[] exps = expression.toCharArray();
        for (int i = 0; i < exps.length; i++) {
            char c = exps[i];
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                ops.push(c);
            } else if (c == '(') {
            } else if (c == ')') {
                char ope = ops.pop();
                double val = vals.pop();
                double res = 0;

                if (ope == '+') {
                    res = val + vals.pop();
                } else if (ope == '-') {
                    res = val - vals.pop();
                } else if (ope == '*') {
                    res = val * vals.pop();
                } else if (ope == '/') {
                    res = val / vals.pop();
                }
                vals.push(res);
            } else {
                vals.push(Double.parseDouble(String.valueOf(c)));
            }
        }
        System.out.println(vals.peek());
    }
}
