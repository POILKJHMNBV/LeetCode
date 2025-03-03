package com.example.doublepointer;

import java.util.Arrays;

/**
 * <p>L2122:还原原数组</p>
 * @author zhenwu
 * @date 2025/3/3 21:25
 */
public class L2122_RecoverArray {
    public static void main(String[] args) {
        int[] nums = {2, 10, 6, 4, 8, 12};
        System.out.println(Arrays.toString(recoverArray(nums)));
    }

    /**
     * 双指针 + 排序
     * 时间复杂度：O(n log n + n^2)
     * 空间复杂度：O(n)
     */
    private static int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, m = n / 2;
        int[] ans = new int[m];
        for (int i = 1; i < n; i++) {
            // nums[0]一定在lower中
            int diff = nums[i] - nums[0];
            if (diff == 0 || diff % 2 == 1) {
                continue;
            }
            if (n - i < m) {
                break;
            }
            int k = diff / 2;
            ans[0] = nums[0] + nums[i] >> 1;

            // 假定nums[i]在higher中, 枚举[i + 1, n - 1]中的值
            int idx = 1, l = 1, r = i + 1;
            boolean[] visited = new boolean[n];
            visited[i] = true;
            while (r < n) {
                while (l < n && visited[l]) {
                    l++;
                }
                while (r < n && nums[r] - nums[l] < 2 * k) {
                    r++;
                }
                // nums[r]无法加入higher
                if (r == n || nums[r] - nums[l] > 2 * k) {
                    break;
                }
                visited[r] = true;
                ans[idx++] = nums[l++] + nums[r++] >> 1;
            }
            if (idx == m) {
                break;
            }
        }
        return ans;
    }
}
