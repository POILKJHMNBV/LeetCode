package com.example.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L140:单词拆分 II</p>
 * @author zhenwu
 * @date 2024/10/19 21:21
 */
public class L140_WordBreak {
    public static void main(String[] args) {
        List<String> wordDict = List.of("apple", "pen", "applepen", "pine", "pineapple");
        String s = "pineapplepenapple";
        System.out.println(wordBreak(s, wordDict));
    }

    private static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        dfs(s, wordDict, ans, new ArrayList<>());
        return ans;
    }

    /**
     * 回溯
     * 超时
     * @param s 目标字符串
     * @param wordDict 字典
     * @param ans 结果
     * @param path 路径
     */
    private static void dfs(String s, List<String> wordDict, List<String> ans, List<String> path) {
        String str = path.stream().reduce((a, b) -> a + b).orElse("");
        if (str.length() > s.length()) {
            return;
        }
        if (str.equals(s)) {
            ans.add(path.stream().reduce((a, b) -> a + " " + b).get());
            return;
        }
        for (String word : wordDict) {
            path.add(word);
            dfs(s, wordDict, ans, path);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 优化
     * 避免不必要的流操作
     * @param s 目标字符串
     * @param wordDict 字典
     * @param ans 结果
     * @param path 路径
     * @param start 开始位置
     */
    private static void dfs(String s, List<String> wordDict, List<String> ans, List<String> path, int start) {
        if (start == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i));
                if (i < path.size() - 1) {
                    sb.append(" ");
                }
            }
            ans.add(sb.toString());
            return;
        }

        for (String word : wordDict) {
            if (s.startsWith(word, start)) {
                path.add(word);
                dfs(s, wordDict, ans, path, start + word.length());
                path.remove(path.size() - 1);
            }
        }
    }
}
