package com.example.array;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>L2441:与对应负数同时存在的最大正整数</p>
 * @author zhenwu
 * @date 2025/5/12 22:14
 */
public class L2441_FindMaxK {

    public static void main(String[] args) {
        int[] nums = {-1, 2, -3, 3};
        System.out.println(findMaxK(nums));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int findMaxK(int[] nums) {
        int ans = -1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.contains(-num)) {
                ans = Math.max(ans, Math.abs(num));
            }
        }
        return ans;
    }
}
