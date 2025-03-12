package com.example.doublepointer;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L1023:驼峰式匹配</p>
 * @author zhenwu
 * @date 2025/3/12 20:16
 */
public class L1023_CamelMatch {
    public static void main(String[] args) {

    }

    private static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for (String query : queries) {
            ans.add(match(query, pattern));
        }
        return ans;
    }

    /**
     * 双指针
     * 时间复杂度：O(m)
     * 空间复杂度：O(1)
     */
    private static boolean match(String query, String pattern) {
        int m = query.length(), n = pattern.length();
        if (m <= n) {
            return false;
        }
        int i = 0, j = 0;
        boolean notContainsUpperChar = true;
        while (i < m && j < n) {
            char ch1 = query.charAt(i), ch2 = pattern.charAt(j);
            if (ch1 == ch2) {
                j++;
            } else {
                if (ch1 >= 'A' && ch1 <= 'Z') {
                    notContainsUpperChar = false;
                }
            }
            i++;
        }
        while (i < m) {
            char ch = query.charAt(i++);
            if (ch >= 'A' && ch <= 'Z') {
                notContainsUpperChar = false;
                break;
            }
        }
        return notContainsUpperChar && j == n;
    }
}
