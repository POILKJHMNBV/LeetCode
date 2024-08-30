package com.example.doublepointer;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>L345:反转字符串中的元音字母</p>
 * @author zhenwu
 * @date 2024/8/30 21:13
 */
public class L345_ReverseVowels {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }

    private static String reverseVowels(String s) {
        String vowels = "AEIOUaeiou";
        Set<Character> set = new HashSet<>();
        for (char ch : vowels.toCharArray()) {
            set.add(ch);
        }
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (set.contains(chars[i]) && set.contains(chars[j])) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            } else if (set.contains(chars[i])) {
                j--;
            } else if (set.contains(chars[j])) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return new String(chars);
    }
}
