package com.example.doublepointer;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>L1898:可移除字符的最大数目</p>
 * @author zhenwu
 * @date 2025/3/13 22:00
 */
public class L1898_MaximumRemovals {
    public static void main(String[] args) {
        String s = "abcbddddd";
        String p = "abcd";
        int[] removable = {3, 2, 1, 4, 5, 6};
        System.out.println(maximumRemovalsPro(s, p, removable));
    }

    /**
     * 二分查找 + 双指针
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(n)
     */
    private static int maximumRemovalsPro(String s, String p, int[] removable) {
        char[] sChars = s.toCharArray(), pChars = p.toCharArray();
        int l = 0, r = removable.length;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (!isSubsequence(sChars, pChars, removable, m)) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        return l;
    }

    private static boolean isSubsequence(char[] sChars, char[] pChars, int[] removable, int k) {
        boolean[] used = new boolean[sChars.length];
        for (int i = 0; i < k; i++) {
            used[removable[i]] = true;
        }
        for (int i = 0, j = 0, n = sChars.length; i < n; i++) {
            if (used[i]) {
                continue;
            }
            if (sChars[i] == pChars[j] && ++j == pChars.length) {
                return true;
            }
        }
        return false;
    }

    /**
     * 暴力求解(超时)
     * 时间复杂度：O(n * n)
     * 空间复杂度：O(n)
     */
    private static int maximumRemovals(String s, String p, int[] removable) {
        Set<Integer> removeSet = new HashSet<>();
        for (int idx : removable) {
            removeSet.add(idx);
        }
        char[] sChars = s.toCharArray(), pChars = p.toCharArray();
        for (int k = removable.length; k > 0; k--) {
            if (isSubsequence(sChars, pChars, removeSet)) {
                return k;
            }
            removeSet.remove(removable[k - 1]);
        }
        return 0;
    }

    private static boolean isSubsequence(char[] sChars, char[] pChars, Set<Integer> removeSet) {
        int n = sChars.length;
        for (int i = 0, j = 0; i < n; i++) {
            if (removeSet.contains(i)) {
                continue;
            }
            if (sChars[i] == pChars[j] && ++j == pChars.length) {
                return true;
            }
        }
        return false;
    }
}
