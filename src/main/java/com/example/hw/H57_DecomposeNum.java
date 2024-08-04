package com.example.hw;

import java.util.Scanner;

/**
 * <p>数的分解</p>
 * <p>
 *  给定一个正整数n，如果能够分解为m(m > 1)个连续正整数之和，请输出所有分解中，m最小的分解。
 *  如果给定整数无法分解为连续正整数，则输出字符串"N"。
 * </p>
 * <p>
 *     输入描述：输入数据为一整数，范围为 (1,2^30]
 *     输出描述：21 = 10 + 11
 * </p>
 * @author zhenwu
 * @date 2024/7/16 21:28
 */
public class H57_DecomposeNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        /*
            假设n可以被m个连续正整数之和表示，记这m个连续正整数为a, a+1, a+2, ..., a+(m-1)。
            那么，这m个数的和可以表示为等差数列的和，即 n = ma + m(m-1)/2 => a = (2n - m(m-1)) / (2m)
            即从最小的 m = 2开始，逐渐增加m的值，并检查是否存在整数a满足上述方程
         */
        for (int m = 2; m <= n; m++) {
            int numerator = 2 * n - m * (m - 1);
            if (numerator > 0 && numerator % (2 * m) == 0) {
                int a = numerator / (2 * m);
                System.out.print(n + "=");
                for (int i = a; i < a + m - 1; i++) {
                    System.out.print(i + "+");
                }
                System.out.println(a+(m-1));
                return;
            }
        }
        System.out.println("N");
    }
}
