package com.example.bit;

import java.util.Arrays;

/**
 * <p>L1356:根据数字二进制下 1 的数目排序</p>
 * @author zhenwu
 * @date 2025/6/18 21:45
 */
public class L1356_SortByBits {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(n log n)
     * 空间复杂度: O(n)
     */
    private static int[] sortByBits(int[] arr) {
        int n = arr.length;
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = arr[i];
        }
        Arrays.sort(nums, (o1, o2) -> {
            int ans = Integer.bitCount(o1) - Integer.bitCount(o2);
            return ans != 0 ? ans : o1 - o2;
        });
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }
        return arr;
    }
}
