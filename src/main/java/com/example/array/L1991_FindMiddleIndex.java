package com.example.array;

import java.util.Arrays;

/**
 * 1991.找到数组的中间位置
 *
 * 给你一个下标从 0 开始的整数数组nums，请你找到 最左边的中间位置middleIndex（也就是所有可能中间位置下标最小的一个）。
 * 中间位置middleIndex是满足nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1]的数组下标。
 * 如果middleIndex == 0，左边部分的和定义为 0。类似的，如果middleIndex == nums.length - 1，右边部分的和定义为0。
 * 请你返回满足上述条件 最左边的middleIndex，如果不存在这样的中间位置，请你返回-1
 */
public class L1991_FindMiddleIndex {
    public static void main(String[] args) {
        int[] nums = {2, 3, -1, 8, 4};
        int middleIndex = findMiddleIndex(nums);
        System.out.println(middleIndex);
    }
    /**
     *  思路：
     *      设数组 a 的全部元素之后为total，左侧元素之和为sum，则最右侧元素之后为total-sum-a[i]，则有
     *         sum = total-sum-a[i]   ===>     2 * sum + a[i] = total
     */
    public static int findMiddleIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums [i];
        }
        return -1;
    }
}
