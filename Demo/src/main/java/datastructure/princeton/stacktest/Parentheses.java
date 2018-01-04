package datastructure.princeton.stacktest;

import datastructure.utils.StdIn;

public class Parentheses {
    public static void main(String[] args) {
        //正确
        String exp1 = "[()]{}{[()()]()}";
        boolean isParent1 = isParentheses(exp1);
        System.out.println(isParent1);

        //缺少左边括号
        String exp2 = "[)]{}{[()()]()}";
        boolean isParent2 = isParentheses(exp2);
        System.out.println(isParent2);

        //缺少右边括号
        String exp3 = "[(){}{[()()]()}";
        boolean isParent3 = isParentheses(exp3);
        System.out.println(isParent3);
    }

    /**
     * 判断表达式中括号是不是完整配对
     * @param exp 表达式
     * @return 完整配对返回true，非完整配对返回false
     */
    private static boolean isParentheses(String exp) {
        char[] exps = exp.toCharArray();//转化为字符数组
        Stack<Character> s = new Stack<Character>();
        boolean isParentheses = true;//完整配对标识
        for (int i = 0; i < exps.length; i++) {
            char oper = exps[i];
            if (oper == '{' || oper == '[' || oper == '(') {//左边括号的话，压栈
                s.push(oper);
            } else if (oper == '}') {//右边括号就弾栈，弹出的左括号与之不配对的话，就不是完整配对
                if (s.pop() != '{') {
                    isParentheses = false;
                    break;
                }
            } else if (oper == ']') {
                if (s.pop() != '[') {
                    isParentheses = false;
                    break;
                }
            } else if (oper == ')') {
                if (s.pop() != '(') {
                    isParentheses = false;
                    break;
                }
            }
        }
        //如果缺少的是右括号，最后的stack一定不为空，那么最后的标识也为false
        if (!s.isEmpty()) {
            isParentheses = false;
        }
        //返回判断标识
        return isParentheses;
    }
}
