package com.example.array;

import java.util.Arrays;

/**
 * <p>L203:计数质数</p>
 * @author zhenwu
 * @date 2024/10/29 21:21
 */
public class L204_CountPrimes {
    public static void main(String[] args) {

    }

    /**
     * 计算小于非负整数 n 的质数的数量。
     * 时间复杂度：O(n * sqrt(n))
     * 空间复杂度：O(1)
     * 超时
     * @param n 非负整数 n
     * @return 小于非负整数 n 的质数的数量
     */
    private static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 优化：埃拉托斯特尼筛法
     * 时间复杂度：O(n * log(log(n)))
     * 空间复杂度：O(n)
     */
    private static int countPrimesPro(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        // 从 2 开始枚举到 sqrt(n)。
        for (int i = 2; i * i < n; i++) {
            // 如果当前是素数
            if (isPrim[i]) {
                // 就把从 i*i 开始，i 的所有倍数都设置为 false。
                for (int j = i * i; j < n; j+=i) {
                    isPrim[j] = false;
                }
            }
        }

        // 计数
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}
