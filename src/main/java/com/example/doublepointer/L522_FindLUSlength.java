package com.example.doublepointer;

/**
 * <p>L522:最长特殊序列 II</p>
 * @author zhenwu
 * @date 2025/3/13 21:53
 */
public class L522_FindLUSlength {
    public static void main(String[] args) {

    }

    /**
     * 双指针
     * 时间复杂度：O(n * n * m)，其中n是数组strs的长度，m是字符串的平均长度
     * 空间复杂度：O(1)
     */
    private static int findLUSlength(String[] strs) {
        int maxLen = -1, n = strs.length;
        for (int i = 0; i < n; i++) {
            String str = strs[i];
            if (str.length() < maxLen) {
                continue;
            }
            boolean needSkip = false;
            for (int j = 0; j < n; j++) {
                if (i != j && isSubsequence(str, strs[j])) {
                    needSkip = true;
                    break;
                }
            }
            if (needSkip) {
                continue;
            }
            maxLen = str.length();
        }
        return maxLen;
    }

    /**
     * 判断s是否是t的子序列
     */
    private static boolean isSubsequence(String s, String t) {
        for (int i = 0, j = 0, n = t.length(); i < n; i++) {
            if (s.charAt(j) == t.charAt(i) && ++j == s.length()) {
                return true;
            }
        }
        return false;
    }
}
