package com.example.array;

/**
 * <p>L2905:找出满足差值条件的下标 II</p>
 * @author zhenwu
 * @date 2025/5/5 11:03
 */
public class L2905_FindIndices {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        // 记录便利过程中最大值和最小值的索引
        int maxIdx = 0, minIdx = 0;
        for (int j = indexDifference, n = nums.length; j < n; j++) {
            int i = j - indexDifference;
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            } else if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
            if (nums[maxIdx] - nums[j] >= valueDifference) {
                return new int[]{maxIdx, j};
            }
            if (nums[j] - nums[minIdx] >= valueDifference) {
                return new int[]{minIdx, j};
            }
        }
        return new int[]{-1, -1};
    }
}
