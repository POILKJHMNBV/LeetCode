package com.example.array;

/**
 * <p>L66:加一</p>
 * @author zhenwu
 * @date 2024/10/4 9:24
 */
public class L66_PlusOne {
    public static void main(String[] args) {
        int[] digits = {9, 9};
        int[] result = plusOne(digits);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    /**
     * 时间：O(n)  空间：O(1)
     */
    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
