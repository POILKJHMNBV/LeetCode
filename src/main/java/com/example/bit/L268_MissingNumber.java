package com.example.bit;

import java.util.Arrays;

/**
 * <p>L268:丢失的数字</p>
 * <p>给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。</p>
 * @author zhenwu
 * @date 2024/11/14 21:39
 */
public class L268_MissingNumber {
    public static void main(String[] args) {

    }

    /**
     * 方法一：排序
     * 时间复杂度：O(n logn)
     * 空间复杂度：O(1)
     */
    private static int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 方法二：原地哈希
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int missingNumber2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i && nums[i] < n) {
                swap(nums, i, nums[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 方法三：异或运算
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int missingNumber3(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length + 1; i++) {
            xor ^= i;
        }
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

    /**
     * 方法四：数组哈希
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int missingNumber4(int[] nums) {
        boolean[] hash = new boolean[nums.length + 1];
        for (int num : nums) {
            hash[num] = true;
        }
        for (int i = 0; i < hash.length; i++) {
            if (!hash[i]) {
                return i;
            }
        }
        return nums.length;
    }
}
