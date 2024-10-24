package com.example.string;

/**
 * @author zhenwu
 * @date 2024/10/24 22:30
 */
public class L171_TitleToNumber {
    public static void main(String[] args) {
        String columnTitle = "ZY";
        System.out.println(titleToNumber(columnTitle));
    }

    private static int titleToNumber(String columnTitle) {
        char[] charArray = columnTitle.toCharArray();
        int len = charArray.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            int num = charArray[i] - 'A' + 1;
            result += num * Math.pow(26, len - i - 1);
        }
        return result;
    }
}
