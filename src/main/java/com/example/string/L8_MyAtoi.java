package com.example.string;

/**
 * <p>L8:字符串转换整数 (atoi)</p>
 * @author zhenwu
 * @date 2024/9/23 20:53
 */
public class L8_MyAtoi {
    public static void main(String[] args) {
        String s = "20000000000000000000";
        System.out.println(myAtoi(s));
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
}
