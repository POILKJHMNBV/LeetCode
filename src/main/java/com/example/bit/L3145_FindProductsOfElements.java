package com.example.bit;

/**
 * <p>L3145:大数组元素的乘积</p>
 * @author zhenwu
 * @date 2025/7/24 22:19
 */
public class L3145_FindProductsOfElements {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(q * log r)，其中 q 为 queries 的长度，r=max(toi)
     * 空间复杂度: O(1)
     */
    private static int[] findProductsOfElements(long[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long[] q = queries[i];
            long er = sumE(q[1] + 1);
            long el = sumE(q[0]);
            ans[i] = pow(2, er - el, q[2]);
        }
        return ans;
    }

    private static long sumE(long k) {
        long res = 0;
        long n = 0;
        long cnt1 = 0; // 之前填的 1 的个数
        long sumI = 0; // 之前填的 1 的幂次之和
        for (long i = 63 - Long.numberOfLeadingZeros(k + 1); i >= 0; i--) {
            long c = (cnt1 << i) + (i << i >> 1); // 新增的幂次个数
            if (c <= k) {
                k -= c;
                res += (sumI << i) + ((i * (i - 1) / 2) << i >> 1);
                sumI += i;
                cnt1++;
                n |= 1L << i; // 填 1
            }
        }
        // 剩余的 k 个幂次，由 n 的低 k 个 1 补充
        while (k-- > 0) {
            res += Long.numberOfTrailingZeros(n);
            n &= n - 1; // 去掉最低位的 1（置为 0）
        }
        return res;
    }

    private static int pow(long x, long n, long mod) {
        long res = 1 % mod; // 注意 mod 可能等于 1
        for (; n > 0; n /= 2) {
            if (n % 2 == 1) {
                res = res * x % mod;
            }
            x = x * x % mod;
        }
        return (int) res;
    }
}
