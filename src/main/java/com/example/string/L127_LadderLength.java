package com.example.string;

import java.util.*;

/**
 * <p>L127:单词接龙</p>
 * @author zhenwu
 * @date 2024/10/13 21:05
 */
public class L127_LadderLength {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    /**
     * 广度优先搜索
     * 时间：O(n * 26 * m) n为单词长度，m为字典中单词数量
     */
    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        Deque<String> deque = new ArrayDeque<>();
        Set<String> visitSet = new HashSet<>();
        visitSet.add(beginWord);
        deque.offer(beginWord);
        int step = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                char[] charArray = deque.poll().toCharArray();
                int len = charArray.length;
                for (int j = 0; j < len; j++) {
                    char original = charArray[j];

                    // 依次尝试替换当前字符，并判断是否在字典中
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        charArray[j] = ch;
                        String newWord = String.valueOf(charArray);
                        if (newWord.equals(endWord)) {
                            return step + 1;
                        }
                        if (!visitSet.contains(newWord) && wordSet.contains(newWord)) {
                            deque.offer(newWord);
                            visitSet.add(newWord);
                        }
                    }
                    // 恢复原字符
                    charArray[j] = original;
                }
            }
            step++;
        }
        return 0;
    }
}
