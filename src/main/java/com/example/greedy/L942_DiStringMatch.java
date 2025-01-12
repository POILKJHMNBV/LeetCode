package com.example.greedy;

/**
 * <p>L942:增减字符串匹配</p>
 * @author zhenwu
 * @date 2025/1/12 8:53
 */
public class L942_DiStringMatch {
    public static void main(String[] args) {

    }

    private static int[] diStringMatch(String s) {
        int n = s.length(), low = 0, high = n;
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            ans[i] = s.charAt(i) == 'I' ? low++ : high--;
        }
        ans[n] = low;
        return ans;
    }
}
