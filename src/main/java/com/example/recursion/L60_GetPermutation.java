package com.example.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L60:排列序列</p>
 * @author zhenwu
 * @date 2024/9/30 21:04
 */
public class L60_GetPermutation {
    public static void main(String[] args) {
        int n = 9, k = 214267;
        System.out.println(getPermutation(n, k));
    }

    private static String getPermutation(int n, int k) {
        List<String> ans = new ArrayList<>();
        process("", n, new boolean[n], ans, k);
        return ans.get(k - 1);
    }

    private static void process(String s,
                                int n,
                                boolean[] used,
                                List<String> ans, int k) {
        if (s.length() == n) {
            ans.add(s);
            return;
        }
        if (ans.size() >= k) {
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!used[i - 1]) {
                used[i - 1] = true;
                process(s + i, n, used, ans, k);
                used[i - 1] = false;
            }
        }
    }
}
