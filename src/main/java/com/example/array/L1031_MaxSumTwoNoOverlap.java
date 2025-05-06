package com.example.array;

/**
 * <p>L1031:两个非重叠子数组的最大和</p>
 * @author zhenwu
 * @date 2025/5/6 21:29
 */
public class L1031_MaxSumTwoNoOverlap {

    public static void main(String[] args) {
        int[] nums = {0, 6, 5, 2, 2, 5, 1, 9, 4};
        int firstLen = 1, secondLen = 2;
        System.out.println(maxSumTwoNoOverlap(nums, firstLen, secondLen));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 1, n = nums.length; i <= n; i++) {
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1];
        }
        return Math.max(process(prefixSum, firstLen, secondLen), process(prefixSum, secondLen, firstLen));
    }

    private static int process(int[] prefixSum, int lenA, int lenB) {
        // maxSumA 为长度为 lenA 的子数组的最大元素和
        int maxSumA = 0, ans = 0;
        for (int i = lenA + lenB, n = prefixSum.length; i < n; i++) {
            maxSumA = Math.max(maxSumA, prefixSum[i - lenB] - prefixSum[i - lenB - lenA]);
            ans = Math.max(ans, maxSumA + prefixSum[i] - prefixSum[i - lenB]);
        }
        return ans;
    }
}
