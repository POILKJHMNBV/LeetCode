package com.example.slidewindow;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L2831:找出最长等值子数组</p>
 * @author zhenwu
 * @date 2025/2/12 20:41
 */
public class L2831_LongestEqualSubarray {

    public static void main(String[] args) {

    }

    /**
     * 分组滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int longestEqualSubarray(List<Integer> nums, int k) {
        // 按照元素进行分组，保存每个元素的下标
        // pos[r] - pos[l] + 1 - (r - l + 1) <= k
        // pos[r] - r - (pos[l] - l) <= k
        // pos[r] - pos[l] <= k
        int n = nums.size();
        List<List<Integer>> posList = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            posList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            int size = posList.get(num).size();
            posList.get(num).add(i - size);
        }

        int maxLen = 0;
        for (List<Integer> pos : posList) {
            for (int l = 0, r = 0, size = pos.size(); r < size; r++) {
                while (pos.get(r) - pos.get(l) > k) {
                    l++;
                }
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }
        return maxLen;
    }
}
