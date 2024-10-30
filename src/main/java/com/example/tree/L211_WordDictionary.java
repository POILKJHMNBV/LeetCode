package com.example.tree;

/**
 * <p>L211:添加与搜索单词 - 数据结构设计</p>
 * @author zhenwu
 * @date 2024/10/30 21:13
 */
public class L211_WordDictionary {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search(".at"));
    }

    static class WordDictionary {

        private final Trie trie;

        public WordDictionary() {
            trie = new Trie();
        }

        public void addWord(String word) {
            trie.insert(word);
        }

        public boolean search(String word) {
            return dfs(0, word.toCharArray(), trie.getRoot());
        }

        private boolean dfs(int index, char[] charArray, Trie.TrieNode trieNode) {
            if (index == charArray.length) {
                return trieNode.isEnd();
            }
            if (charArray[index] == '.') {
                Trie.TrieNode[] trieNodes = trieNode.getNext();
                // 遍历所有可能的下一个节点
                for (Trie.TrieNode child : trieNodes) {
                    if (child != null && dfs(index + 1, charArray, child)) {
                        return true;
                    }
                }
            } else {
                Trie.TrieNode child = trieNode.getNext()[charArray[index] - 'a'];
                if (child != null) {
                    return dfs(index + 1, charArray, child);
                }
            }
            return false;
        }
    }
}
