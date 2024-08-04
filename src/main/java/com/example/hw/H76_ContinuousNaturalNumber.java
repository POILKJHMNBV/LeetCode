package com.example.hw;

import java.util.Scanner;

/**
 * <p>用连续自然数之和来表达整数</p>
 * <p>
 *      一个整数可以由连续的自然数之和来表示。给定一个整数，计算该整数有几种连续自然数之和的表达式，且打印出每种表达式
 * </p>
 * <p>
 *      输入描述：一个目标整数T (1 <=T<= 1000)
 * </p>
 * <p>
 *     输出描述：
 *          该整数的所有表达式和表达式的个数。如果有多种表达式，输出要求为：
 *          1.自然数个数最少的表达式优先输出
 *          2.每个表达式中按自然数递增的顺序输出，具体的格式参见样例。在每个测试数据结束时，输出一行”Result:X”，其中X是最终的表达式个数。
 * </p>
 * @see H57_DecomposeNum
 * @author zhenwu
 * @date 2024/7/21 10:01
 */
public class H76_ContinuousNaturalNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = 0;
        for (int m = 1; m <= n; m++) {
            int numerator = 2 * n - m * (m - 1);
            if (numerator > 0 && numerator % (2 * m) == 0) {
                int a = numerator / (2 * m);
                System.out.print(n + "=");
                for (int i = a; i < a + m - 1; i++) {
                    System.out.print(i + "+");
                }
                System.out.println(a+(m-1));
            }
        }
        System.out.println("Result:" + result);
    }
}
