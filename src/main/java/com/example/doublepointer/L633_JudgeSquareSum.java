package com.example.doublepointer;

/**
 * <p>L633:平方数之和</p>
 * @author zhenwu
 * @date 2025/2/26 21:56
 */
public class L633_JudgeSquareSum {
    public static void main(String[] args) {

    }

    /**
     * 2 * a * a >= c   =>      2 * a * a >= a * a + b * b
     * 时间复杂度：O(sqrt(c))
     * 空间复杂度：O(1)
     */
    private static boolean judgeSquareSum(int c) {
        for (int a = 0; a * a <= c / 2; a++) {
            int b = (int) Math.sqrt(c - a * a);
            if (a * a + b * b == c) return true;
        }
        return false;
    }
}
