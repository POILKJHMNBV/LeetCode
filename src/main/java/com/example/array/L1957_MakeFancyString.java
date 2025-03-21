package com.example.array;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>L1957:删除字符使字符串变好</p>
 * @author zhenwu
 * @date 2025/3/21 20:09
 */
public class L1957_MakeFancyString {
    public static void main(String[] args) {
        String s = "leeetcode";
        System.out.println(makeFancyStringPro(s));
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static String makeFancyStringPro(String s) {
        char[] chars = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        for (int i = 0, n = s.length(); i < n; i++) {
            char ch = chars[i];
            int j = i;
            while (j < n && ch == chars[j]) {
                j++;
            }
            for (int k = Math.max(i, j - 2); k < j; k++) {
                ans.append(chars[k]);
            }
            i = j - 1;
        }
        return ans.toString();
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static String makeFancyString(String s) {
        Set<Integer> delIndexSet = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0, n = s.length(); i < n; i++) {
            char ch = chars[i];
            int j = i;
            while (j < n && ch == chars[j]) {
                j++;
            }
            while (j - i >= 3) {
                delIndexSet.add(i++);
            }
            i = j - 1;
        }
        if (delIndexSet.isEmpty()) {
            return s;
        }
        char[] ans = new char[s.length() - delIndexSet.size()];
        for (int i = 0, n = s.length(), j = 0; i < n; i++) {
            if (delIndexSet.contains(i)) {
                continue;
            }
            ans[j++] = chars[i];
        }
        return new String(ans);
    }
}
