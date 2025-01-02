package com.example.bit;

/**
 * <p>L477:汉明距离总和</p>
 * @author zhenwu
 * @date 2025/1/2 21:30
 */
public class L477_TotalHammingDistance {
    public static void main(String[] args) {
        int[] nums = {4, 14, 2};
        System.out.println(totalHammingDistance(nums));
    }

    /**
     * 优化解法
     * 时间复杂度: O(30 * n)
     * 空间复杂度: O(1)
     */
    private static int totalHammingDistancePro(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }

    /**
     * 暴力解法
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     */
    private static int totalHammingDistance(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    continue;
                }
                count += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }
        return count;
    }
}
