package com.example.bit;

/**
 * <p>L2447:最大公因数等于 K 的子数组数目</p>
 * @author zhenwu
 * @date 2025/8/23 23:13
 */
public class L2447_SubarrayGCD {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n * log U), 其中 U = max(nums)
     * 空间复杂度：O(n * log U)
     */
    private static int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        // 子数组gcd列表->相同gcd最靠右的下标
        long[][] gcds = new long[n][2];
        int end = 0;
        // 子数组左端点
        int left = -1;

        // 枚举子数组右端点
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num % k != 0) {
                // 保证子数组内都是k的倍数
                end = 0;
                left = i;
                continue;
            }
            // 添加新元素
            gcds[end][0] = num;
            gcds[end][1] = i;
            end++;
            // 更新第一个元素
            gcds[0][0] = gcd(gcds[0][0], num);
            // 更新添加新元素后的列表内剩余gcd，并去重
            // 去重后的右边界
            int right = 0;
            for (int j = 1; j < end; j++) {
                long[] curGcd = gcds[j];
                curGcd[0] = gcd(curGcd[0], num);
                if (curGcd[0] == gcds[right][0]) {
                    // 相同gcd，用最新的下标覆盖
                    gcds[right][1] = curGcd[1];
                } else {
                    right++;
                    gcds[right][0] = curGcd[0];
                    gcds[right][1] = curGcd[1];
                }
            }
            end = right + 1;
            // 子数组都是k的倍数，最小gcd一定>=k
            if (gcds[0][0] == k) {
                res += gcds[0][1] - left;
            }
        }
        return res;
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
