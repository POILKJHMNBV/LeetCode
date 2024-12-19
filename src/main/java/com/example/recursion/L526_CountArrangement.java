package com.example.recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>L526:优美的排列</p>
 * @author zhenwu
 * @date 2024/12/19 22:20
 */
public class L526_CountArrangement {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(countArrangementDfs(n));
        System.out.println(countArrangementMemoDfs(n));
        System.out.println(countArrangementDp(n));
    }

    /**
     * 时间复杂度：O(n * 2^n)
     * 空间复杂度：O(2^n)
     */
    private static int countArrangementDp(int n) {
        // dp[mask] 表示当前状态为 mask 时的优美排列个数
        int[] dp = new int[1 << n];
        dp[0] = 1;
        for (int mask = 1; mask < dp.length; mask++) {
            int index = Integer.bitCount(mask);
            for (int i = 1; i <= n; i++) {
                if (((mask >> (i - 1)) & 1) == 1 && (i % index == 0 || index % i == 0)) {
                    dp[mask] += dp[mask ^ (1 << (i - 1))];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[(1 << n) - 1];
    }

    /**
     * 时间复杂度：O(n * 2^n)
     * 空间复杂度：O(2^n)
     */
    private static int countArrangementMemoDfs(int n) {
        int[] memo = new int[1 << n];
        int ans = countArrangementMemoDfs(n, (1 << n) - 1, memo);
        System.out.println(Arrays.toString(memo));
        return ans;
    }

    private static int countArrangementMemoDfs(int n, int mask, int[] memo) {
        if (mask == 0) {
            return 1;
        }
        int res = 0;
        int index = Integer.bitCount(mask);
        for (int i = 1; i <= n; i++) {
            if (((mask >> (i - 1)) & 1) == 1 && (i % index == 0 || index % i == 0)) {
                res += countArrangementMemoDfs(n, mask ^ (1 << (i - 1)), memo);
            }
        }
        memo[mask] = res;
        return res;
    }

    /**
     * 时间复杂度：O(n!)
     * 空间复杂度：O(n)
     */
    private static int countArrangementDfs(int n) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(n, 1, new boolean[n], new LinkedList<>(), res);
        System.out.println(res);
        return res.size();
    }
    
    private static void dfs(int n,
                            int index,
                            boolean[] used,  
                            LinkedList<Integer> path, 
                            List<List<Integer>> res) {
        if (index - 1 == n) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (used[i - 1] || (index % i != 0 && i % index != 0)) {
                continue;
            }
            path.add(i);
            used[i - 1] = true;
            dfs(n, index + 1, used, path, res);
            path.removeLast();
            used[i - 1] = false;
        }
    }
}
