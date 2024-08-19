package com.example.string;

/**
 * <p>L459:重复的子字符串</p>
 * <p>
 *     给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * </p>
 * @author zhenwu
 * @date 2024/8/19 20:39
 */
public class L459_RepeatedSubstringPattern {
    public static void main(String[] args) {
       String s = "abaababaab";
        System.out.println(repeatedSubstringPattern(s));
    }

    private static boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        for (int step = 1; step <= length / 2; step++) {
            if (length % step != 0) {
                continue;
            }
            String subStr = s.substring(0, step);
            StringBuilder sb = new StringBuilder(subStr);
            for (int i = 1; i < length / step; i++) {
                sb.append(subStr);
            }
            if (sb.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }
}
