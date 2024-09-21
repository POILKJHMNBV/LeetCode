package com.example.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>L208:实现 Trie (前缀树)</p>
 * <p>
 *     请你实现 Trie 类：
 *          Trie() 初始化前缀树对象。
 *          void insert(String word) 向前缀树中插入字符串 word 。
 *          boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 *          boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false
 * </p>
 */
public class L208_TrieTest {
    public static void main(String[] args) {

    }
}

class Trie {

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode("");
    }

    public void insert(String word) {
        char[] charArray = word.toCharArray();
        TrieNode curNode = this.root;
        StringBuilder sb = new StringBuilder(curNode.s);
        for (char ch : charArray) {
            int index = ch - 'a';
            sb.append(ch);
            if (curNode.next[index] == null) {
                curNode.next[index] = new TrieNode(sb.toString());
            }
            curNode = curNode.next[index];
        }
        curNode.isEnd = true;
    }

    public boolean search(String word) {
        char[] charArray = word.toCharArray();
        TrieNode curNode = this.root;
        for (char ch : charArray) {
            int index = ch - 'a';
            if (curNode.next[index] == null) {
                return false;
            }
            curNode = curNode.next[index];
        }
        return curNode.isEnd;
    }

    public List<String> startsWithStrings(String prefix) {
        char[] charArray = prefix.toCharArray();
        TrieNode curNode = this.root;
        if (!startsWith(prefix)) {
            return Collections.emptyList();
        }
        for (char ch : charArray) {
            int index = ch - 'a';
            curNode = curNode.next[index];
        }
        List<String> ans = new ArrayList<>();
        if (curNode.isEnd) {
            ans.add(curNode.s);
        }
        for (TrieNode trieNode : curNode.next) {
            if (trieNode != null) {
                dfs(trieNode, ans);
            }
        }
        return ans;
    }

    private void dfs(TrieNode trieNode, List<String> ans) {
        if (trieNode.isEnd) {
            ans.add(trieNode.s);
        }
        for (TrieNode node : trieNode.next) {
            if (node != null) {
                dfs(node, ans);
            }
        }
    }

    public boolean startsWith(String prefix) {
        char[] charArray = prefix.toCharArray();
        TrieNode curNode = this.root;
        for (char ch : charArray) {
            int index = ch - 'a';
            if (curNode.next[index] == null) {
                return false;
            }
            curNode = curNode.next[index];
        }
        return true;
    }

    static class TrieNode {
        private final String s;
        private boolean isEnd;
        private final TrieNode[] next;

        public TrieNode(String s) {
            this.s = s;
            this.isEnd = false;
            this.next = new TrieNode[26];
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }
    }
}
