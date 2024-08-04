package com.example.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L131:分割回文串</p>
 * <p>给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案</p>
 */
public class L131_Partition {
    public static void main(String[] args) {
        String s = "aabc";
        System.out.println(partition(s));
    }

    private static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null) {
            return res;
        }
        if (s.length() == 1) {
            return List.of(List.of(s));
        }
        process(s, res, new ArrayList<>(), 0);
        return res;
    }

    private static void process(String s, List<List<String>> res, List<String> path, int startIndex) {
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                path.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            process(s, res, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
