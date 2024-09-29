package com.example.recursion;

/**
 * <p>L38:外观数列</p>
 * @author zhenwu
 * @date 2024/9/29 21:01
 */
public class L38_CountAndSay {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(countAndSay(n));
        System.out.println(countAndSayPro(n));
    }

    private static String countAndSayPro(int n) {
        if (n == 1) {
            return "1";
        }
        String s = "1";
        for (int i = 2; i <= n; i++) {
            s = count(s);
        }
        return s;
    }

    private static String count(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char[] charArray = s.toCharArray();
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] != charArray[i - 1]) {
                sb.append(count).append(charArray[i - 1]);
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count).append(charArray[charArray.length - 1]);
        return sb.toString();
    }

    private static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return count(countAndSay(n - 1));
    }
}
