package com.example.array;

import java.util.*;

/**
 * <p>L3267:统计近似相等数对 II</p>
 * @author zhenwu
 * @date 2025/5/9 22:03
 */
public class L3267_CountPairs {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n log n + n log5 U), 其中 U = max(nums)
     * 空间复杂度：O((n + log4 U)
     */
    private static int countPairs(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            Set<Integer> st = new HashSet<>();
            st.add(x); // 不交换
            char[] s = Integer.toString(x).toCharArray();
            int m = s.length;
            for (int i = 0; i < m; i++) {
                for (int j = i + 1; j < m; j++) {
                    swap(s, i, j);
                    st.add(Integer.parseInt(new String(s))); // 交换一次
                    for (int p = i + 1; p < m; p++) {
                        for (int q = p + 1; q < m; q++) {
                            swap(s, p, q);
                            st.add(Integer.parseInt(new String(s))); // 交换两次
                            swap(s, p, q);
                        }
                    }
                    swap(s, i, j);
                }
            }
            for (int v : st) {
                ans += cnt.getOrDefault(v, 0);
            }
            cnt.merge(x, 1, Integer::sum);
        }
        return ans;
    }

    private static void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
