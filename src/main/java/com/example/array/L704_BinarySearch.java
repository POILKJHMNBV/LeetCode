package com.example.array;


import com.example.util.SearchUtils;

/**
 * L704:二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
 */
public class L704_BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(binarySearch(new int[]{-1, 0, 3, 5, 9, 12}, 10));
        System.out.println(binarySearch1(new int[]{-1, 0, 3, 5, 9, 12}, 11));
        System.out.println(binarySearch2(new int[]{-1, 0, 3, 5, 9, 12}, 10));
        int[] nums = {1, 3, 5, 7, 9};
        System.out.println(SearchUtils.ceilIndex(nums, 0));
        System.out.println(SearchUtils.floorIndex(nums, 0));
    }

    private static int binarySearch(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }

        if (length == 1){
            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = length - 1;
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

    private static int binarySearch1(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }

        if (length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println("【binarySearch1】left = " + left);
        System.out.println("【binarySearch1】nums[left] = " + nums[left]);
        return nums[left] == target ? left : -1;
    }

    private static int binarySearch2(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }

        if (length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        System.out.println("【binarySearch2】left = " + left);
        System.out.println("【binarySearch2】nums[left] = " + nums[left]);
        return nums[left] == target ? left : -1;
    }
}
