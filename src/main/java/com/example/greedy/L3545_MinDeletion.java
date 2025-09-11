package com.example.greedy;

import java.util.Arrays;

/**
 * <p>L3545:不同字符数量最多为 K 时的最少删除数</p>
 * @author zhenwu
 * @date 2025/9/11 21:50
 */
public class L3545_MinDeletion {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int minDeletion(String s, int k) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        Arrays.sort(cnt);
        int ans = 0;
        for (int i = 0; i < 26 - k; i++) {
            ans += cnt[i];
        }
        return ans;
    }
}
