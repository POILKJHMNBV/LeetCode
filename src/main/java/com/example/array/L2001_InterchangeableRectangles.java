package com.example.array;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L2001:可互换矩形的组数</p>
 * @author zhenwu
 * @date 2025/4/25 23:11
 */
public class L2001_InterchangeableRectangles {
    public static void main(String[] args) {

    }

    /**
     * 时间：O(n)
     * 空间：O(n)
     */
    private static long interchangeableRectangles(int[][] rectangles) {
        Map<Fraction, Integer> map = new HashMap<>();
        long ans = 0;
        for (int[] rectangle : rectangles) {
            Fraction key = new Fraction(rectangle[0], rectangle[1]);
            if (map.containsKey(key)) {
                ans += map.get(key);
            }
            map.merge(key, 1, Integer::sum);
        }
        return ans;
    }

    static class Fraction {
        final int numerator;
        final int denominator;

        public Fraction(int numerator, int denominator) {
            int gcd = gcd(numerator, denominator);
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
        }

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Fraction fraction = (Fraction) o;

            if (numerator != fraction.numerator) return false;
            return denominator == fraction.denominator;
        }

        @Override
        public int hashCode() {
            int result = numerator;
            result = 31 * result + denominator;
            return result;
        }
    }
}
