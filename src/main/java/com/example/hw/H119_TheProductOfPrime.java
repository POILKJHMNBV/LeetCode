package com.example.hw;

import java.util.Scanner;

/**
 * <p>素数之积</p>
 * <p>
 *     RSA加密算法只在网络安全世界中无处不在，它利用了极大整数因数分解的困难度，数据越大，安全系数越高，给定一个32 位正整，请对其进行因数分解，找出是哪两个素数的乘积。
 * </p>
 * <p>
 *     输入描述：一个正整数num
 * </p>
 * <p>
 *     输出描述：如果成功找到，以单个空格分割，从小到大输出两个素数，分解失败，请输出-1,-1
 * </p>
 * @author zhenwu
 * @date 2024/7/28 15:57
 */
public class H119_TheProductOfPrime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int a = -1, b = -1;
        int k = (int) (Math.sqrt(num) + 1);
        for (int i = 2; i <= k; i++) {
            if (num % i == 0 && isPrime(i) && isPrime(num / i)) {
                a = i;
                b = num / i;
                break;
            }
        }
        System.out.println(a + " " + b);
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        int k = (int) (Math.sqrt(n) + 1);
        for (int i = 2; i <= k; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
