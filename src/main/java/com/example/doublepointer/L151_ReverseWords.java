package com.example.doublepointer;

/**
 * <p>L151:反转字符串中的单词</p>
 * @author zhenwu
 * @date 2024/8/18 15:00
 */
public class L151_ReverseWords {
    public static void main(String[] args) {
        String s = " the  sky is  blue ";
        System.out.println(reverseWords(s));
    }

    private static String reverseWords(String s) {
        char[] chars = removeExtraSpace(s).toCharArray();
        int length = chars.length;
        // 反转字符串
        reverseStr(chars, 0, length - 1);

        // 反转单词
        int l = 0, r = 0;
        while (l < length) {
            while (r < length && chars[r] != ' ') {
                r++;
            }
            reverseStr(chars, l, r - 1);
            l = r + 1;
            r = l;
        }
        return new String(chars);
    }

    private static void reverseStr(char[] chars, int l, int r) {
        while (l < r) {
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
    }

    /**
     * 移除字符串中多余空格
     */
    private static String removeExtraSpace(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;

        // 移除字符串前后空格
        while (chars[l] == ' ') {
            l++;
        }
        while (chars[r] == ' ') {
            r--;
        }

        StringBuilder res = new StringBuilder();
        // 移除单词间的空格
        while (l <= r) {
            if (chars[l] != ' ' || res.charAt(res.length() - 1) != ' ') {
                res.append(chars[l]);
            }
            l++;
        }
        return res.toString();
    }
}
