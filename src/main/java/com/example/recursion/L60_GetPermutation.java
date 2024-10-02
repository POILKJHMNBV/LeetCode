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
        int n = 4, k = 20;
        System.out.println(getPermutation(n, k));
        System.out.println(getPermutationPro(n, k));
    }

    /**
     * 时间：O(n * n!)     空间：O(n)
     */
    private static String getPermutation(int n, int k) {
        List<String> ans = new ArrayList<>();
        process("", n, new boolean[n], ans, k);
        return ans.get(k - 1);
    }

    /**
     * 时间：O(n * n)     空间：O(n)
     */
    private static String getPermutationPro(int n, int k) {
        int[] factorial = new int[n + 1];
        calculateFactorial(n, factorial);
        StringBuilder ans = new StringBuilder();
        boolean[] used = new boolean[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int count = factorial[i];
            for (int j = 1; j <= n; j++) {
                if (used[j]) {
                    continue;
                }
                if (k > count) {
                    k -= count;
                    continue;
                }
                used[j] = true;
                ans.append(j);
                break;
            }
        }
        return ans.toString();
    }
    
    private static void calculateFactorial(int n, int[] factorial) {
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
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
