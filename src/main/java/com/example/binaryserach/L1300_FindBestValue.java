package com.example.binaryserach;

/**
 * L1300:转变数组后最接近目标值的数组和
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，
 * 使得将数组中所有大于 value 的值变成 value 后，数组的和最接近 target（最接近表示两者之差的绝对值最小）。
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 * 请注意，答案不一定是 arr 中的数字。
 */
public class L1300_FindBestValue {
    public static void main(String[] args) {
        System.out.println(findBestValue(new int[]{4, 9, 3}, 10));
        System.out.println(findBestValue(new int[]{60864, 25176, 27249, 21296, 20204}, 56803));
    }

    private static int findBestValue(int[] arr, int target) {
        int left = 0;
        int right = 0;
        for (int i : arr) {
            right = Math.max(right, i);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = calculateSum(arr, mid);
            if (sum < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int sum1 = calculateSum(arr, left - 1);
        int sum2 = calculateSum(arr, left);
        return Math.abs(sum1 - target) <= Math.abs(sum2 - target) ? left - 1 : left;
    }

    private static int calculateSum(int[] arr, int threshold) {
        int sum = 0;
        for (int i : arr) {
            sum += Math.min(i, threshold);
        }
        return sum;
    }
}
