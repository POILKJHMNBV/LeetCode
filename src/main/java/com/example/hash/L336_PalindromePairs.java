package com.example.hash;

import java.util.*;

/**
 * <p>L336:回文对</p>
 * @author zhenwu
 * @date 2024/12/15 21:04
 */
public class L336_PalindromePairs {
    public static void main(String[] args) {
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(palindromePairs(words));
    }

    private static List<List<Integer>> palindromePairs(String[] words) {
        PalindromePairs pp = new PalindromePairs();
        return pp.palindromePairs(words);
    }

    static class PalindromePairs {

        static class TrieNode {
            TrieNode[] children;
            int index;
            List<Integer> palindromeIndexes;

            TrieNode() {
                children = new TrieNode[26];
                index = -1;
                palindromeIndexes = new ArrayList<>();
            }
        }

        private TrieNode root;

        public List<List<Integer>> palindromePairs(String[] words) {
            root = new TrieNode();
            for (int i = 0; i < words.length; i++) {
                addWord(words[i], i);
            }

            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                search(words[i], i, result);
            }

            return result;
        }

        private void addWord(String word, int index) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                int c = word.charAt(i) - 'a';
                if (node.children[c] == null) {
                    node.children[c] = new TrieNode();
                }
                if (isPalindrome(word, 0, i)) {
                    node.palindromeIndexes.add(index);
                }
                node = node.children[c];
            }
            node.index = index;
            node.palindromeIndexes.add(index);
        }

        private void search(String word, int index, List<List<Integer>> result) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                // Check remaining substring forms a palindrome
                if (node.index >= 0 && node.index != index && isPalindrome(word, i, word.length() - 1)) {
                    result.add(Arrays.asList(index, node.index));
                }
                node = node.children[word.charAt(i) - 'a'];
                if (node == null) {
                    return;
                }
            }
            // Check all palindrome suffixes stored at this node
            for (int j : node.palindromeIndexes) {
                if (index != j) {
                    result.add(Arrays.asList(index, j));
                }
            }
        }

        private boolean isPalindrome(String word, int left, int right) {
            while (left < right) {
                if (word.charAt(left++) != word.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }
    }
}
