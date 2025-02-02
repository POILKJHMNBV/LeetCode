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

    /**
     * 滑动窗口求最大元音字母数
     * 滑动窗口大小为k，初始时窗口内元音字母数为count
     * 向右滑动窗口，每次将右边界符合条件的字符加入到count中
     * 向左滑动窗口，每次将左边界符合条件的字符从count中移除
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
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
