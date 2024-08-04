package com.example.array;

/**
 * L33:搜素旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class L33_SearchSpinSortedArray {
    public static void main(String[] args) {
        System.out.println(searchTargetInSpinSortedArray(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(searchTargetInSpinSortedArray(new int[]{4, 5, 6, 7, 0, 1, 2}, -1));
        System.out.println(searchTargetInSpinSortedArrayPlus(new int[]{4, 5, 6, 7, 0, 1, 2}, -1));
        System.out.println(searchTargetInSpinSortedArrayPlus(new int[]{3, 1}, 1));
    }

    private static int searchTargetInSpinSortedArray(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return  -1;
        }
        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int low = 0;
        int high = length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int left = target > nums[length - 1] ? 0 : low;
        int right = target > nums[length - 1] ? low - 1 : length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private static int searchTargetInSpinSortedArrayPlus(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0;
        int r = len  -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[0] <= nums[m]) {
                if (nums[0] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] < target && target <= nums[len - 1]){
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
