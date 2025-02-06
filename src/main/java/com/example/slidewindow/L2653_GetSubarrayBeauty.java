package com.example.slidewindow;

import java.util.Map;
import java.util.TreeMap;

/**
 * <p>L2653:滑动子数组的美丽值</p>
 * @author zhenwu
 * @date 2025/2/6 21:35
 */
public class L2653_GetSubarrayBeauty {
    public static void main(String[] args) {

    }

    private static int[] getSubarrayBeautyPro(int[] nums, int k, int x) {
        Map<Integer, Integer> cntMap = new TreeMap<>();
        for (int i = 0; i < k - 1; i++) {
            cntMap.put(nums[i], cntMap.getOrDefault(nums[i], 0) + 1);
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = k - 1; i < n; i++) {
            cntMap.put(nums[i], cntMap.getOrDefault(nums[i], 0) + 1);
            int l = x;
            for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
                int key = entry.getKey(), value = entry.getValue();
                if (key >= 0) {
                    break;
                }
                l -= value;
                if (l <= 0) {
                    res[i - k + 1] = key;
                    break;
                }
            }
            if (cntMap.get(nums[i - k + 1]) == 1) {
                cntMap.remove(nums[i - k + 1]);
            } else {
                cntMap.put(nums[i - k + 1], cntMap.get(nums[i - k + 1]) - 1);
            }
        }
        return res;
    }


    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int basicsNum = 50, n = nums.length;
        // 计数数组
        int[] cnt = new int[2 * basicsNum + 1];
        for (int i = 0; i < k - 1; i++) {
            cnt[nums[i] + basicsNum]++;
        }
        int[] res = new int[n - k + 1];
        for (int i = k - 1; i < n; i++) {
            cnt[nums[i] + basicsNum]++;
            int l = x;
            for (int j = 0; j < basicsNum; j++) {
                // 枚举[-50, -1]的所有负数
                l -= cnt[j];
                if (l <= 0) {
                    // 找到美丽值
                    res[i - k + 1] = j - basicsNum;
                    break;
                }
            }
            // 滑出窗口
            cnt[nums[i - k + 1] + basicsNum]--;
        }
        return res;
    }
}
