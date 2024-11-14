package com.example.num;

/**
 * <p>L263:丑数</p>
 * <p>
 *     丑数 就是只包含质因数 2、3 和 5 的正整数。实现一个程序判断给定的正整数是否是丑数。
 * </p>
 * @author zhenwu
 * @date 2024/11/13 21:23
 */
public class L263_IsUgly {
    public static void main(String[] args) {
        int n = 14;
        System.out.println(isUgly(n));
    }

    /**
     * 时间复杂度：O(log n)
     * 空间复杂度：O(1)
     */
    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
