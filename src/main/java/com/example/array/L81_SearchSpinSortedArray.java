package com.example.array;

/**
 * L81:搜素旋转排序数组II
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 * <p>
 * 你必须尽可能减少整个操作步骤。
 */
public class L81_SearchSpinSortedArray {
    public static void main(String[] args) {
        System.out.println(searchTargetInSpinSortedArray(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(searchTargetInSpinSortedArray(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        System.out.println(searchTargetInSpinSortedArray(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1}, 2));
    }

    private static boolean searchTargetInSpinSortedArray(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        if (len == 1) {
            return nums[0] == target;
        }

        int l = 0;
        int r = len  -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return true;
            }
            if (nums[l] == nums[m] && nums[m] == nums[r]) {
                l++;
                r--;
            } else if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target < nums[m]) {
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
        return false;
    }
}
