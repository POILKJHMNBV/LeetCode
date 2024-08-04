package com.example.hw;

import com.example.stack.L224_SimpleCalculator;

import java.util.*;

/**
 * <p>符号运算</p>
 * <p>
 *     给定一个表达式，求其分数计算结果
 *     表达式的限制如下：
 *          1.所有的输入数字皆为正整数(包括0)
 *          2.仅支持四则运算(+-/*)和括号
 *          3.结果为整数或分数, 分数必须化为最简格式(比如6, 3/4, 7/8, 90/7)
 *          4.除数可能为0，如果遇到这种情况，直接输出"ERROR"
 *          5.输入和最终计算结果中的数字都不会超出整型范围
 *     用例的输入一定合法, 不会出现括号不匹配的情况
 * </p>
 * <p>
 *     输入描述：
 *          字符串格式的表达式，仅支持+-/*，数字可能超过两位，可能带有空格，没有负数
 *          长度小于200个字符
 * </p>
 * <p>
 *     输出描述：
 *          表达式结果，以最简格式表达 如果结果为整数，那么直接输出整数 如果结果为分数，那么分子分母不可再约分，可以为假分数，不可表达为带分数 结果可能是负数, 负号放在最前面
 * </p>
 * @see L224_SimpleCalculator
 * @author zhenwu
 * @date 2024/7/14 9:47
 */
public class H44_Arithmetic {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine().replaceAll(" ", "");
        Calculator calculator = new Calculator();
        try {
            System.out.println(calculator.calculate(expression.toCharArray()));
        } catch (ArithmeticException e) {
            System.out.println("ERROR");
        }
    }

    /**
     * 计算器类，用于计算表达式结果
     */
    private static class Calculator {

        /**
         * 符号优先级map
         */
        private static final Map<Character, Integer> operatePriorityMap;

        static {
            operatePriorityMap = new HashMap<>();
            operatePriorityMap.put('+', 1);
            operatePriorityMap.put('-', 1);
            operatePriorityMap.put('*', 2);
            operatePriorityMap.put('/', 2);
        }

        public Fraction calculate(char[] expressionArray) {
            int length = expressionArray.length;
            Deque<Fraction> numStack = new ArrayDeque<>();
            Deque<Character> opsStack = new ArrayDeque<>();

            // 为了防止第一个数为负数，先往 nums 加个 0
            numStack.push(new Fraction(0, 1));

            for (int i = 0; i < length; i++) {
                char ch = expressionArray[i];
                if (ch == '(') {
                    opsStack.push(ch);
                } else if (ch == ')') {
                    // 遇到右括号，计算括号内的表达式
                    while (!opsStack.isEmpty() && opsStack.peek() != '(') {
                        calculate(numStack, opsStack);
                    }

                    // 弹出 '('
                    opsStack.pop();
                } else {
                    // 当前字符是数字或运算符
                    if (Character.isDigit(ch)) {
                        // 当前字符是数字，由于数字可能是多个字符，需要依次先后读取完整数字
                        int num = 0;
                        int j = i;
                        while (j < length && Character.isDigit(expressionArray[j])) {
                            num = 10 * num + (expressionArray[j] - '0');
                            j++;
                        }
                        numStack.push(new Fraction(num, 1));

                        // 重置i的起始位置
                        i = j - 1;
                    } else {
                        // 当前字符是运算符，比较当前运算符和栈顶运算符的运算优先级
                        if (i > 0 && expressionArray[i - 1] == '(') {
                            // 防止出现类似"(-4+5"的情况，处理负数
                            numStack.push(new Fraction(0, 1));
                        }
                        while (!opsStack.isEmpty() && opsStack.peek() != '(') {
                            char preOp = opsStack.peek();
                            if (operatePriorityMap.get(preOp) < operatePriorityMap.get(ch)) {
                                // 栈顶符合优先级小于当前符号优先级，停止计算
                                break;
                            }
                            calculate(numStack, opsStack);
                        }

                        opsStack.push(ch);
                    }
                }
            }

            while (!opsStack.isEmpty()) {
                // 计算剩余数字
                calculate(numStack, opsStack);
            }
            return numStack.pop();
        }

        /**
         * 计算栈顶两个元素的操作结果
         * @param numStack 操作数栈
         * @param opsStack 符号栈
         */
        private void calculate(Deque<Fraction> numStack, Deque<Character> opsStack) {
            if (opsStack.isEmpty() || numStack.size() < 2) {
                return;
            }
            Fraction b = numStack.pop();
            Fraction a = numStack.pop();
            char op = opsStack.pop();
            if (op == '+') {
                numStack.push(a.add(b));
            } else if (op == '-') {
                numStack.push(a.subtract(b));
            } else if (op == '*') {
                numStack.push(a.multiply(b));
            } else if (op == '/') {
                numStack.push(a.divide(b));
            }
        }
    }

    /**
     * 分数类，用于存储和计算结果
     */
    private static class Fraction {
        // 分子
        final long numerator;

        // 分母
        final long denominator;

        public Fraction(long numerator, long denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Fraction add(Fraction other) {
            long newNumerator = numerator * other.denominator + denominator * other.numerator;
            long newDenominator = denominator * other.denominator;
            return new Fraction(newNumerator, newDenominator).simplify();
        }

        public Fraction subtract(Fraction other) {
            long newNumerator = numerator * other.denominator - denominator * other.numerator;
            long newDenominator = denominator * other.denominator;
            return new Fraction(newNumerator, newDenominator).simplify();
        }

        public Fraction multiply(Fraction other) {
            long newNumerator = numerator * other.numerator;
            long newDenominator = denominator * other.denominator;
            return new Fraction(newNumerator, newDenominator).simplify();
        }

        public Fraction divide(Fraction other) {
            if (other.numerator == 0) {
                throw new ArithmeticException();
            }
            long newNumerator = numerator * other.denominator;
            long newDenominator = denominator * other.numerator;
            return new Fraction(newNumerator, newDenominator).simplify();
        }

        /**
         * 约简为最简分数
         */
        private Fraction simplify() {
            long gcd = gcd(numerator, denominator);
            return new Fraction(numerator / gcd, denominator / gcd);
        }

        /**
         * 求取两个数的最大公约数
         */
        private long gcd(long a, long b) {
            return a % b == 0 ? b : gcd(b, a % b);
        }

        @Override
        public String toString() {
            if (denominator == 1) {
                return Long.toString(numerator);
            } else {
                String res = Math.abs(numerator) + "/" + Math.abs(denominator);
                return numerator * denominator < 0 ? "-" + res : res;
            }
        }
    }
}
