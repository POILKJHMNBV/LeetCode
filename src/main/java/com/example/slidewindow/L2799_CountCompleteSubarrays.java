package com.example.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L2799:统计完全子数组的数目</p>
 * @author zhenwu
 * @date 2025/2/19 20:27
 */
public class L2799_CountCompleteSubarrays {
    public static void main(String[] args) {

    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            idxMap.put(nums[i], i);
        }
        int size = idxMap.size(), ans = 0;
        idxMap.clear();
        for (int l = 0, r = 0; r < n; r++) {
            idxMap.put(nums[r], r);
            while (idxMap.size() == size) {
                if (idxMap.get(nums[l]) == l) {
                    idxMap.remove(nums[l]);
                }
                l++;
            }
            ans += l;
        }
        return ans;
    }
}
