package com.example.bit;

/**
 * <p>L3133:数组最后一个元素的最小值</p>
 * @author zhenwu
 * @date 2025/7/16 21:52
 */
public class L3133_MinEnd {
    public static void main(String[] args) {

    }

    /**
     * x 一定是每个 nums[i] 的子集，换句话说，nums[i] 一定是 x 的超集
     * 为了让 nums[n−1] 尽量小，我们应当选择 x 的超集中最小的 n 个数
     * 时间复杂度：O(log n + log x)
     * 空间复杂度：O(1)
     */
    private static long minEnd(int n, int x) {
        n--; // 先把 n 减一，这样下面讨论的 n 就是原来的 n-1
        long ans = x;
        int i = 0, j = 0;
        while ((n >> j) > 0) {
            // x 的第 i 个比特值是 0，即「空位」
            if ((ans >> i & 1) == 0) {
                // 空位填入 n 的第 j 个比特值
                ans |= (long) (n >> j & 1) << i;
                j++;
            }
            i++;
        }
        return ans;
    }
}
