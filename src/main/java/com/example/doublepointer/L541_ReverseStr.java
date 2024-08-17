package com.example.doublepointer;

/**
 * <p>L541:反转字符串 II</p>
 *
 * @author zhenwu
 * @date 2024/8/17 21:59
 */
public class L541_ReverseStr {
    public static void main(String[] args) {
        String s = "abcd";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }

    private static String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i += 2 * k) {
            int start = i;
            // 判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length - 1, start + k - 1);
            while (start < end) {

                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;

                start++;
                end--;
            }
        }
        return new String(ch);
    }
}
