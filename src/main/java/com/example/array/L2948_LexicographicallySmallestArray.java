package com.example.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>L2948:交换得到字典序最小的数组</p>
 * @author zhenwu
 * @date 2025/3/30 10:27
 */
public class L2948_LexicographicallySmallestArray {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(n)
     */
    private static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, Comparator.comparingInt(i -> nums[i]));
        int[] ans = new int[n];
        for (int i = 0; i < n;) {
            int j = i + 1;
            while (j < n && nums[idx[j]] - nums[idx[j - 1]] <= limit) {
                j++;
            }
            Integer[] range = Arrays.copyOfRange(idx, i, j);
            Arrays.sort(range);
            for (int k = 0; k < range.length; k++) {
                ans[range[k]] = nums[idx[i + k]];
            }
            i = j;
        }
        return ans;
    }
}
