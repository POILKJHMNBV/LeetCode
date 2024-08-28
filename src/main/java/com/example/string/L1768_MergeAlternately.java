package com.example.string;

/**
 * <p>L1768:交替合并字符串</p>
 * @author zhenwu
 * @date 2024/8/28 21:09
 */
public class L1768_MergeAlternately {
    public static void main(String[] args) {
        String word1 = "ab", word2 = "pqrs";
        System.out.println(mergeAlternately(word1, word2));
    }

    private static String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int i = 0, j = 0;
        boolean next = false;
        while (i < word1.length() || j < word2.length()) {
            if (next) {
                res.append(word2.charAt(j++));
                if (i < word1.length()) {
                    next = false;
                }
            } else {
                res.append(word1.charAt(i++));
                if (j < word2.length()) {
                    next = true;
                }
            }
        }
        return res.toString();
    }

    private static String mergeAlternatelyPro(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        for (;i < word1.length() && i < word2.length(); i++) {
            res.append(word1.charAt(i)).append(word2.charAt(i));
        }
        if (word1.length() > word2.length()) {
            res.append(word1.substring(i));
        } else if (word2.length() > word1.length()) {
            res.append(word2.substring(i));
        }
        return res.toString();
    }
}
