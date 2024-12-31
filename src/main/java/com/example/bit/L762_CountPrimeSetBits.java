package com.example.bit;

/**
 * <p>L762:二进制表示中质数个计算置位</p>
 * @author zhenwu
 * @date 2024/12/31 20:05
 */
public class L762_CountPrimeSetBits {
    public static void main(String[] args) {
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));
        System.out.println(isPrime(5));
        int left = 6, right = 10;
        System.out.println(countPrimeSetBits(left, right));
    }

    private static int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(Integer.bitCount(i))) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int num) {
        int k = (int) Math.sqrt(num);
        for (int i = 2; i <= k; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return num > 1;
    }
}
