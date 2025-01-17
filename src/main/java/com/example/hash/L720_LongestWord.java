package com.example.hash;

import java.util.TreeSet;

/**
 * <p>L720:词典中最长的单词</p>
 * @author zhenwu
 * @date 2025/1/17 21:11
 */
public class L720_LongestWord {
    public static void main(String[] args) {
        String[] words = {"yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"};
        System.out.println(longestWord(words));
    }

    private static String longestWord(String[] words) {
        if (words == null || words.length < 2) {
            return "";
        }
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        TreeSet<String> wordSet = new TreeSet<>((o1, o2) -> {
            int res = o2.length() - o1.length();
            return res == 0 ? o1.compareTo(o2) : res;
        });
        for (String word : words) {
            if (trie.search(word) == word.length()) {
                wordSet.add(word);
            }
        }
        return wordSet.isEmpty() ? "" : wordSet.first();
    }

    static class Trie {
        TreeNode root;

        public Trie() {
            root = new TreeNode();
        }

        public void insert(String word) {
            TreeNode cur = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TreeNode();
                }
                cur = cur.children[index];
            }
            cur.isEnd = true;
        }

        public int search(String word) {
            TreeNode cur = root;
            int i = 0, count = 1, len = word.length();
            while (i < len) {
                int index = word.charAt(i) - 'a';
                if (cur.children[index] == null) {
                    break;
                }
                if (cur.isEnd) {
                    count++;
                }
                cur = cur.children[index];
                i++;
            }
            return count;
        }
    }

    static class TreeNode {
        TreeNode[] children;
        boolean isEnd = false;

        TreeNode() {
            children = new TreeNode[26];
        }
    }
}
