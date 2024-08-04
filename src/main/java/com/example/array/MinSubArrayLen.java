package com.example.array;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen1(arr, 7));
        System.out.println(minSubArrayLen2(arr, 3));
    }

    // 暴力解法     时间复杂度：O(n^n)    空间复杂度：O(1)
    private static int minSubArrayLen1(int[] arr, int s) {
        int result = Integer.MAX_VALUE;
        int subLength;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum >= s) {
                    subLength = j- i + 1;
                    result = Math.min(result, subLength);
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    // 滑动窗口法    时间复杂度：O(n)    空间复杂度：O(1)
    private static int minSubArrayLen2(int[] arr, int s) {
        int result = Integer.MAX_VALUE;
        int sum = 0;    // 滑动窗口数值之和
        int i = 0;      // 滑动窗口起始位置
        int subLength;  // 滑动窗口长度
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            while (sum >= s) {
                subLength = j - i + 1;
                result = Math.min(result, subLength);
                sum -= arr[i++];        // 缩小滑动窗口的大小
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
