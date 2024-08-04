package com.example.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhenwu
 */
public class L18_FourSum {
    public static void main(String[] args) {
        int[] nums = {-1000000000, -1000000000, 1000000000, -1000000000, -1000000000};
        int target = 294967296;
        System.out.println(fourSum(nums, target));
        System.out.println((long) (-1000000000 + -1000000000 + 1000000000 + -1000000000 + -1000000000));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len < 4) {
            return res;
        }
        if (len == 4) {
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum > target || sum < target) {
                return res;
            }
            if (sum == target) {
                res.add(List.of(nums[0], nums[1], nums[2], nums[3]));
                return res;
            }
        }
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> list = threeSum(nums, i + 1, len - 1, target - nums[i]);
            if (!list.isEmpty()) {
                for (List<Integer> integerList : list) {
                    integerList.add(nums[i]);
                    res.add(integerList);
                }
            }
        }
        return res;
    }


    private static List<List<Integer>> threeSum(int[] nums, int i, int j, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        for (int k = i; k < j - 1; k++) {
            if (k > i && nums[k] == nums[k - 1]) {
                continue;
            }
            int target = sum - nums[k];
            int left = k + 1, right = j;
            while (left < right) {
                int leftValue = nums[left];
                int rightValue = nums[right];
                if (leftValue + rightValue < target) {
                    left++;
                } else if (leftValue + rightValue > target) {
                    right--;
                } else {
                    res.add(new ArrayList<>(List.of(leftValue, rightValue, nums[k])));
                    while (left < right && nums[left] == leftValue && nums[right] == rightValue) {
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
