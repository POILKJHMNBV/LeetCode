package com.example.num;

/**
 * <p>L273:整数转换英文表示</p>
 * @author zhenwu
 * @date 2024/11/25 21:45
 */
public class L273_NumberToWords {
    public static void main(String[] args) {

    }

    static String[] num2str_small = {
            "Zero",
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    static String[] num2str_medium = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    static String[] num2str_large = {
            "Billion", "Million", "Thousand", "",
    };
    private static String num2Str(int x) {
        String ans = "";
        if (x >= 100) {
            ans += num2str_small[x / 100] + " Hundred ";
            x %= 100;
        }
        if (x >= 20) {
            ans += num2str_medium[x / 10] + " ";
            x %= 10;
        }
        if (x != 0) ans += num2str_small[x] + " ";
        return ans;
    }


    private static String numberToWords(int num) {
        if (num == 0) return num2str_small[0];
        StringBuilder sb = new StringBuilder();
        for (int i = (int)1e9, j = 0; i >= 1; i /= 1000, j++) {
            if (num < i) continue;
            sb.append(num2Str(num / i)).append(num2str_large[j]).append(" ");
            num %= i;
        }
        while (sb.charAt(sb.length() - 1) == ' ') sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
