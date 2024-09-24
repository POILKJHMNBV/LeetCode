package com.example.string;

/**
 * <p>L8:字符串转换整数 (atoi)</p>
 * @author zhenwu
 * @date 2024/9/23 20:53
 */
public class L8_MyAtoi {
    public static void main(String[] args) {
        String s = "42";
        System.out.println(myAtoi(s));
        System.out.println(myAtoiPro(s));
    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     */
    private static int myAtoi(String s) {
        int len = s.trim().length();
        if (len == 0) {
            return 0;
        }
        char[] charArray = s.trim().toCharArray();
        int i = (charArray[0] == '-' || charArray[0] == '+') ? 1 : 0;
        StringBuilder sb = charArray[0] == '-' ? new StringBuilder("-") : new StringBuilder();
        if (i >= len || !Character.isDigit(charArray[i])) {
            return 0;
        }
        while (i < len && Character.isDigit(charArray[i])) {
            sb.append(charArray[i]);
            i++;
        }
        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return charArray[0] == '-'? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(1)
     */
    private static int myAtoiPro(String s) {
        char[] charArray = s.toCharArray();
        int i = 0, len = charArray.length;

        // 去掉字符串开头的空格字符
        while (i < charArray.length && charArray[i] == ' ') {
            i++;
        }
        if (i == len) {
            return 0;
        }
        char first = charArray[i];
        int sign = 1;
        // 判断正负号
        if (first == '-') {
            sign = -1;
            i++;
        } else if (first == '+') {
            i++;
        }
        int ans = 0;
        while (i < len) {
            char c = charArray[i++];
            if (c < '0' || c > '9') {
                break;
            }
            int num = c - '0';

            // 注意：这里判断是否溢出需要分情况讨论，不能直接用 if (ans > Integer.MAX_VALUE / 10)
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && num > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            ans = 10 * ans + sign * num;
        }
        return ans;
    }
}
