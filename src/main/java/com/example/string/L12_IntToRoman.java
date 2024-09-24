package com.example.string;

/**
 * <p>L12:整数转罗马数字</p>
 * @author zhenwu
 * @date 2024/9/24 20:31
 */
public class L12_IntToRoman {
    public static void main(String[] args) {
        int num = 1794;
        System.out.println(intToRoman(num));
    }

    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    /**
     * 时间复杂度：O(1)  空间复杂度：O(1)
     */
    private static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                sb.append(romans[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}
