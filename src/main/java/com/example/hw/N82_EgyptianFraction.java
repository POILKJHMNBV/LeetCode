package com.example.hw;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenwu
 * 2024/6/13 21:06
 */
public class N82_EgyptianFraction {

    public static List<String> decomposeFraction(int numerator, int denominator) {
        List<String> fractions = new ArrayList<>();
        int currentNumerator = numerator;
        int currentDenominator = denominator;

        while (currentNumerator > 0) {
            // 找到最大的埃及分数
            int tempDenominator = findLargestEgyptianFractionDenominator(currentNumerator, currentDenominator);
            fractions.add("1/" + tempDenominator);

            // 更新当前分数
            currentNumerator = currentNumerator * tempDenominator - currentDenominator;
            currentDenominator *= tempDenominator;

            // 为了防止无限循环（当分子分母有公约数时），进行约分
            int gcd = gcd(Math.abs(currentNumerator), Math.abs(currentDenominator));
            currentNumerator /= gcd;
            currentDenominator /= gcd;
        }

        return fractions;
    }

    // 辅助函数：找到小于或等于当前分数的最大埃及分数的分母
    private static int findLargestEgyptianFractionDenominator(int numerator, int denominator) {
        int tempDenominator = denominator;
        while (numerator * tempDenominator < denominator) {
            tempDenominator++;
        }
        return tempDenominator - 1; // 因为上一个循环检查条件为小于，所以减1
    }

    // 辅助函数：计算最大公约数
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        List<String> fractions = decomposeFraction(8, 11);
        System.out.print("8/11 = ");
        for (int i = 0; i < fractions.size(); i++) {
            System.out.print(fractions.get(i));
            if (i < fractions.size() - 1) {
                System.out.print(" + ");
            }
        }
    }
}
