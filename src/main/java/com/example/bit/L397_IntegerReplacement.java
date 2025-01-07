package com.example.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L397:整数替换</p>
 * @author zhenwu
 * @date 2025/1/7 20:42
 */
public class L397_IntegerReplacement {
    public static void main(String[] args) {
        System.out.println(integerReplacement(8));
        System.out.println(integerReplacement(7));
        System.out.println(integerReplacement(4));
    }

    /**
     * 位运算优化
     * 时间复杂度：O(log n)
     * 空间复杂度：O(1)
     */
    private static int integerReplacementPro(int n) {
        int ans = 0;
        long num = n;
        while (num != 1) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else if (((num >> 1) & 1) == 0 || num == 3) {
                num--;
            } else {
                num++;
            }
            ans++;
        }
        return ans;
    }

    /**
     * 暴力递归解法
     * 时间复杂度：O(log n)
     * 空间复杂度：O(log n)
     */
    private static int integerReplacement(int n) {
        return dfs(n, new HashMap<>());
    }

    /**
     * 记忆化搜索
     * @param n 当前数字
     * @param memo 记忆化搜索的缓存
     * @return n 变为 1 所需的 最小替换次数
     */
    private static int dfs(long n, Map<Long, Integer> memo) {
        if (n == 1) return 0;
        if (memo.containsKey(n)) return memo.get(n);
        int ans = (n % 2 == 0 ? dfs(n / 2, memo) :
                Math.min(dfs(n + 1, memo), dfs(n - 1, memo))) + 1;
        memo.put(n, ans);
        return ans;
    }
}
