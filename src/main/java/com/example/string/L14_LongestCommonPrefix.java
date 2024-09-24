package com.example.string;

/**
 * <p>L14:最长公共前缀</p>
 * @author zhenwu
 * @date 2024/9/24 21:02
 */
public class L14_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"ab","a"};
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * 时间复杂度：O(m * n)  空间复杂度：O(1)
     */
    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        char[] chars = strs[0].toCharArray();
        int index = 0, len = chars.length;
        for (; index < len; index++) {
            char c = chars[index];
            int j = 1;
            for (; j < strs.length; j++) {
                if (strs[j].length() <= index || strs[j].charAt(index) != c) {
                    break;
                }
            }
             if (j < strs.length) {
                break;
            }
        }
        return strs[0].substring(0, index);
    }
}
