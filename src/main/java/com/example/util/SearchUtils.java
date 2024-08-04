package com.example.util;

public class SearchUtils {

    private SearchUtils(){}

    private static boolean isEmpty(int[] nums) {
        return nums == null || nums.length == 0;
    }

    public static int basicBinarySearch(int[] nums, int target) {
        if (isEmpty(nums)) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int basedLeftBoundBinarySearch(int[] nums, int target) {
        if (isEmpty(nums)) {
            return -1;
        }
        int leftBound = getLeftBound(nums, target);
        if (leftBound == nums.length) {
            return -1;
        }
        return nums[leftBound] == target ? leftBound : -1;
    }

    public static int getLeftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static int basedRightBoundBinarySearch(int[] nums, int target) {
        if (isEmpty(nums)) {
            return -1;
        }
        int rightBound = getRightBound(nums, target);
        if (rightBound == -1) {
            return -1;
        }
        return nums[rightBound] == target ? rightBound : -1;
    }

    public static int getRightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    public static int ceilIndex(int[] nums, int target) {
        if (isEmpty(nums)) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) /2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static int floorIndex(int[] nums, int target) {
        if (isEmpty(nums)) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left + 1) /2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}