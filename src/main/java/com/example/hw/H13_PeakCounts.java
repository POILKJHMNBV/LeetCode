package com.example.hw;

/**
 * <p>山峰个数</p>
 * <p>
 *      给定一个数组，数组中的每个元素代表该位置的海拔高度。0表示平地，>=1时表示属于某个山峰，山峰的定义为当某个位置的左右海拔均小于自己的海拔时，该位置为山峰。
 *      数组起始位置计算时可只满足一边的条件。
 * </p>
 * <p>
 *      输入描述: 一个整数数组
 *      输出描述: 输出符合条件的山峰的个数
 * </p>
 * @author zhenwu
 * @date 2024/7/3 20:59
 */
public class H13_PeakCounts {
    public static void main(String[] args) {
        int[] nums = {3, 0, 3, 4, 1};
        System.out.println(peakCounts(nums));
    }

    private static int peakCounts(int[] nums) {
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                if (nums[0] > nums[i + 1]) {
                    count++;
                }
                continue;
            }
            if (i == length - 1) {
                if (nums[i] > nums[i - 1]) {
                    count++;
                }
                break;
            }
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                count++;
            }
        }
        return count;
    }
}
