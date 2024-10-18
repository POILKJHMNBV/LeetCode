package com.example.array;

/**
 * <p>L137:只出现一次的数字 II</p>
 * @author zhenwu
 * @date 2024/10/18 21:22
 */
public class L137_SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        System.out.println(singleNumber(nums));
    }

    private static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            // Step 1: 更新 ones
            ones = (ones ^ num) & ~twos;
            // Step 2: 更新 twos
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
}
