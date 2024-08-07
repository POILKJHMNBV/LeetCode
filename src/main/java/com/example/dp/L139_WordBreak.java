package com.example.dp;

import java.util.List;

/**
 * <p>L139:单词拆分</p>
 * <p>
 *     给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 *     注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * </p>
 * @author zhenwu
 * @date 2024/8/7 20:20
 */
public class L139_WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet","code");
        System.out.println(wordBreak(s, wordDict));
        System.out.println(wordBreakPro(s, wordDict));
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        dfs(s, wordDict, "");
        return canBreak;
    }

    private static boolean canBreak = false;

    private static void dfs(String s, List<String> wordDict, String path) {
        if (canBreak || path.length() > s.length()) {
            return;
        }
        if (path.equals(s)) {
            canBreak = true;
            return;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            dfs(s, wordDict, path + wordDict.get(i));
        }
    }

    private static boolean wordBreakPro(String s, List<String> wordDict) {
        // dp[i]表示字符串的前i个字符能否由wordDict组成
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                if (word.length() <= (i + 1)) {
                    int len = i + 1 - word.length();
                    if (len == 0) {
                        dp[i] = dp[i] || word.equals(s.substring(0, i + 1));
                    } else {
                        dp[i] = dp[i] || (dp[len - 1] && word.equals(s.substring(len, i + 1)));
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}
