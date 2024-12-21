package com.example.recursion;

import java.util.Arrays;

/**
 * <p>L996:平方数组的数目</p>
 * @author zhenwu
 * @date 2024/12/21 21:59
 */
public class L996_numSquarefulPerms {
    public static void main(String[] args) {
        int[] nums = {1, 1, 8, 1, 8};
        System.out.println(numSquarefulPerms(nums));
    }

    private static int numSquarefulPerms(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], new boolean[nums.length], 0, 0);
        return count;
    }

    private static int count = 0;

    private static void dfs(int[] nums,
                            boolean[] levelVisited,
                            boolean[] depthVisited,
                            long prevNum,
                            int level) {
        if (level == nums.length) {
            count++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !levelVisited[i - 1]) {
                continue;
            }
            if (depthVisited[i]){
                continue;
            }
            double sqrt = Math.sqrt(prevNum + nums[i]);
            if (prevNum == 0 || sqrt == Math.floor(sqrt)) {
                levelVisited[i] = true;
                depthVisited[i] = true;
                dfs(nums, levelVisited, depthVisited, nums[i], level + 1);
                depthVisited[i] = false;
                levelVisited[i] = false;
            }
        }
    }
}
