package com.example.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>L202:快乐数</p>
 * @author zhenwu
 * @date 2024/8/15 21:15
 */
public class L202_IsHappy {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(isHappy(n));
    }

    private static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int a;
        while ((a = sum(n)) != 1) {
            if (set.contains(a)) {
                return false;
            }
            set.add(a);
            n = a;
        }
        return true;
    }

    private static int sum(int n) {
        int sum = 0;
        while (n != 0) {
            int a = n % 10;
            sum += (a * a);
            n = n / 10;
        }
        return sum;
    }
}