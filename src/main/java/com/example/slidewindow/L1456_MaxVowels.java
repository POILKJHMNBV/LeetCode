package com.example.slidewindow;

/**
 * <p>L1456:定长子串中元音的最大数目</p>
 * @author zhenwu
 * @date 2024/9/1 10:22
 */
public class L1456_MaxVowels {
    public static void main(String[] args) {
        String s = "leetcode";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }

    private static int maxVowels(String s, int k) {
        int count = 0;
        for (int i = 0; i < s.length() && i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        int l = 0, r = k - 1;
        int maxCount = count;
        while (++r < s.length()) {
            if (isVowel(s.charAt(r))) {
                count++;
            }
            if (isVowel(s.charAt(l++))) {
                count--;
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    private static boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }
}
