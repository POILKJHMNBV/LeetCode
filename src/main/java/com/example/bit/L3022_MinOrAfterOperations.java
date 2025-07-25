package com.example.bit;

/**
 * <p>L3022:给定操作次数内使剩余元素的或值最小</p>
 * @author zhenwu
 * @date 2025/7/25 21:31
 */
public class L3022_MinOrAfterOperations {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n log U), 其中 U = max(nums)
     * 空间复杂度：O(1)
     */
    private static int minOrAfterOperations(int[] nums, int k) {
        int ans = 0;
        int mask = 0;
        for (int b = 29; b >= 0; b--) {
            mask |= 1 << b;
            int cnt = 0; // 操作次数
            int and = -1; // -1 的二进制全为 1
            for (int x : nums) {
                and &= x & mask;
                if (and != 0) {
                    cnt++; // 合并 x，操作次数加一
                } else {
                    and = -1; // 准备合并下一段
                }
            }
            if (cnt > k) {
                ans |= 1 << b; // 答案的这个比特位必须是 1
                mask ^= 1 << b; // 后面不考虑这个比特位
            }
        }
        return ans;
    }
}
