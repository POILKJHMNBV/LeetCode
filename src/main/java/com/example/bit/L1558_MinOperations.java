package com.example.bit;

/**
 * <p>L1558:得到目标数组的最少函数调用次数</p>
 * @author zhenwu
 * @date 2025/7/20 23:32
 */
public class L1558_MinOperations {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n * m) 其中 n 是数组 nums 的长度，m 是数组中元素的二进制表示的最大位数
     * 空间复杂度：O(1)
     */
    private static int minOperations(int[] nums) {
        int ret = 0, maxn = 0;
        for (int num : nums) {
            maxn = Math.max(maxn, num);
            while (num != 0) {
                if ((num & 1) != 0) {
                    ret++;
                }
                num >>= 1;
            }
        }
        if (maxn != 0) {
            while (maxn != 0) {
                ret++;
                maxn >>= 1;
            }
            ret--;
        }
        return ret;
    }
}
