package com.example.array;

/**
 * <p>L303:区域和检索 - 数组不可变</p>
 * @author zhenwu
 * @date 2024/12/1 20:17
 */
public class L303_NumArray {
    public static void main(String[] args) {

    }

    static class NumArray {

        private final int[] nums;
        private final int[] prefixNums;

        public NumArray(int[] nums) {
            this.nums = nums;
            prefixNums = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                prefixNums[i + 1] = prefixNums[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += nums[i];
            }
            return sum;
        }

        private int doSumRange(int left, int right) {
            return prefixNums[right + 1] - prefixNums[left];
        }
    }
}
