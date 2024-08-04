package com.example.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhenwu
 * 2024/6/22 10:22
 */
public class N93_ArrayPartition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> threeList = new ArrayList<>();
        List<Integer> fiveList = new ArrayList<>();
        List<Integer> otherList = new ArrayList<>();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            int totalSum = Arrays.stream(nums).sum();
            if (totalSum % 2 != 0) {
                System.out.println(false);
                continue;
            }
            for (int num : nums) {
                if (num % 3 == 0) {
                    threeList.add(num);
                } else if (num % 5 == 0) {
                    fiveList.add(num);
                } else {
                    otherList.add(num);
                }
            }
            int threeSum = sum(threeList);
            int fiveSum = sum(fiveList);
            if (otherList.isEmpty()) {
                System.out.println(threeSum == fiveSum);
                continue;
            }

            int halfSum = totalSum / 2;
            int threeDiff = halfSum - threeSum;
            int fiveDiff = halfSum - fiveSum;
            int otherSum = sum(otherList);
            if (otherSum == threeDiff && fiveDiff == 0) {
                System.out.println(true);
                continue;
            } else if (otherSum == fiveDiff && threeDiff == 0) {
                System.out.println(true);
                continue;
            }
            System.out.println(exist(otherList, threeDiff, fiveDiff));
        }
    }

    private static boolean exist(List<Integer> otherList, int threeDiff, int fiveDiff) {
        int otherSum = sum(otherList);
        int len = otherList.size();
        int[] nums = new int[len];
        int j = 0;
        for (int num : otherList) {
            nums[j++] = num;
        }
        for (int i = 1; i < len; i++) {
            List<List<Integer>> res = new ArrayList<>();
            backtracking(nums, 0, res, i, new ArrayList<>());
            for (List<Integer> list : res) {
                int sum = sum(list, nums);
                if (sum == threeDiff && (fiveDiff == otherSum - sum)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void backtracking(int[] nums,
                                     int startIndex,
                                     List<List<Integer>> res,
                                     int target,
                                     List<Integer> path) {
        if (path.size() == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(i);
            backtracking(nums, startIndex + 1, res, target, path);
            path.remove(path.size() - 1);
        }
    }

    private static int sum(List<Integer> list, int[] nums) {
        int sum = 0;
        for (int index : list) {
            sum += nums[index];
        }
        return sum;
    }

    private static int sum(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }
}
