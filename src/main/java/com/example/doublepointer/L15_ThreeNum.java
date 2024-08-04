package com.example.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>L15:三数之和 </p>
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class L15_ThreeNum {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        if (nums[length - 1] < 0) {
            return result;
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = Math.abs(nums[i]);
            int left = i + 1, right = length - 1;
            while (left < right) {
                int leftValue = nums[left];
                int rightValue = nums[right];
                if (leftValue + rightValue == target) {
                    result.add(List.of(nums[i], leftValue, rightValue));
                    while (nums[left] == leftValue && nums[right] == rightValue && left < right) {
                        left++;
                        right--;
                    }
                } else if (leftValue + rightValue > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
