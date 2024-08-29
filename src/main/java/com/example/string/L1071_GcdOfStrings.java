package com.example.string;

/**
 * <p>L1071:字符串的最大公因子</p>
 * @author zhenwu
 * @date 2024/8/28 21:57
 */
public class L1071_GcdOfStrings {
    public static void main(String[] args) {
        String str1 = "ABABAB", str2 = "ABAB";
        System.out.println(gcdOfStrings(str1, str2));
    }

    private static String gcdOfStrings(String str1, String str2) {
        if (str1.equals(str2)) {
            return str1;
        }
        String gcdOfStr = "";
        if (str1.length() > str2.length()) {
            for (int i = 1; i <= str2.length(); i++) {
                String subStr = str2.substring(0, i);
                if (compose(subStr, str1) && compose(subStr, str2)) {
                    gcdOfStr = subStr;
                }
            }
        } else {
            for (int i = 1; i <= str1.length(); i++) {
                String subStr = str1.substring(0, i);
                if (compose(subStr, str1) && compose(subStr, str2)) {
                    gcdOfStr = subStr;
                }
            }
        }
        return gcdOfStr;
    }

    private static boolean compose(String subStr, String s) {
        if (subStr.equals(s)) {
            return true;
        }
        StringBuilder res = new StringBuilder(subStr);
        while (true) {
            res.append(subStr);
            if (s.equals(res.toString())) {
                return true;
            }
            if (s.length() < res.length()) {
                return false;
            }
        }
    }
}
