package com.example.binaryserach;

import java.util.Arrays;

/**
 * <p>L475:供暖器</p>
 * @author zhenwu
 * @date 2025/4/17 22:50
 */
public class L475_FindRadius {
    public static void main(String[] args) {

    }

    /**
     * 时间：O((n * logn + m * log m + m)，其中 m 是数组 houses 的长度，n 是数组 heaters 的长度。
     * 空间：O(1)
     */
    private static int findRadiusPro(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int j = 0, ans = 0;
        for (int house : houses) {
            while (j < heaters.length && heaters[j] < house) {
                j++;
            }
            int d;
            if (j == 0) {
                d = heaters[0] - house;
            } else if (j == heaters.length) {
                d = house - heaters[j - 1];
            } else {
                d = Math.min(heaters[j] - house, house - heaters[j - 1]);
            }
            ans = Math.max(ans, d);
        }
        return ans;
    }

    /**
     * 时间：O((n+m)logn)，其中 m 是数组 houses 的长度，n 是数组 heaters 的长度。
     * 空间：O(logn)
     */
    private static int findRadius(int[] houses, int[] heaters) {
        int ans = 0;
        Arrays.sort(heaters);
        for (int house : houses) {
            int i = binarySearch(heaters, house);
            int j = i + 1;
            int leftDistance = i < 0 ? Integer.MAX_VALUE : house - heaters[i];
            int rightDistance = j >= heaters.length ? Integer.MAX_VALUE : heaters[j] - house;
            int curDistance = Math.min(leftDistance, rightDistance);
            ans = Math.max(ans, curDistance);
        }
        return ans;
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (nums[left] > target) {
            return -1;
        }
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
