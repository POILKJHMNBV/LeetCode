package com.example.dp;

/**
 * <p>L97:交错字符串</p>
 * <p>给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。</p>
 * <p>
 *   s = s1 + s2 + ... + sn
 *   t = t1 + t2 + ... + tm
 *   |n - m| <= 1
 * </p>
 * <p>
 *     交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 *     注意：a + b 意味着字符串 a 和 b 连接。
 * </p>
 */
public class L97_IsInterleave {
    public static void main(String[] args) {
        String s1 = "db", s2 = "b", s3 = "cbb";
        System.out.println(isInterleavePro(s1, s2, s3));
    }

    /**
     * dp[i][j]: s1 前 i 个元素与 s2 前 j 个元素能否交错组成 s3 的前 i + j 个元素
     */
    private static boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }

        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        char[] charArray3 = s3.toCharArray();

        // 初始化dp
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;

        // 开始递推
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[i][j] |= (dp[i - 1][j] && charArray1[i - 1] == charArray3[p]);
                }
                if (j > 0) {
                    dp[i][j] |= (dp[i][j - 1] && charArray2[j - 1] == charArray3[p]);
                }
            }
        }
        return dp[len1][len2];
    }

    private static boolean isInterleavePro(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }

        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        char[] charArray3 = s3.toCharArray();

        // 初始化dp
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1 && charArray1[i - 1] == charArray3[i - 1]; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <=len2 && charArray2[i - 1] == charArray3[i - 1]; i++) {
            dp[0][i] = true;
        }

        // 开始递推
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int p = i + j - 1;
                dp[i][j] = (dp[i - 1][j] && charArray1[i - 1] == charArray3[p]) || (dp[i][j - 1] && charArray2[j - 1] == charArray3[p]);
            }
        }

        return dp[len1][len2];
    }
}
