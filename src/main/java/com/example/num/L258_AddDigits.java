package com.example.num;

/**
 * <p>L258:各位相加</p>
 * @author zhenwu
 * @date 2024/11/12 21:11
 */
public class L258_AddDigits {
    public static void main(String[] args) {

    }


    /**
     * 各位相加
     * 时间复杂度：O(log num)
     * 空间复杂度：O(1)
     */
    private static int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    /**
     * 各位相加
     * 同余定理
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     */
    private static int addDigitsPro(int num) {
        return 1 + (num - 1) % 9;
    }
}
