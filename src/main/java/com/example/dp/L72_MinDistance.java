package com.example.dp;

/**
 * <p>L72:编辑距离</p>
 * <p>给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数</p>
 * <p>你可以对一个单词进行如下三种操作：</p>
 * <p>
 *  插入一个字符
 *  删除一个字符
 *  替换一个字符
 * </p>
 */
public class L72_MinDistance {
    public static void main(String[] args) {
        String word1 = "ucyfsmg", word2 = "zuixhuhyjgksyhqkjqxwylkoubykjxtcvkyqjpzgltbemmbmqibxxqpkgbvwbmjotixanvciibubglizmumcrjavakiygyuv";
        System.out.println(minDistance(word1, word2));
    }

    /**
     * dp[i][j]: word1 前 i 个字符组成的子串转换成 word2 前 j 个字符组成子串所使用的最少操作数
     */
    private static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();

        // 初始化dp
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }

        // 开始递推
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (charArray1[i - 1] == charArray2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[len1][len2];
    }
}
