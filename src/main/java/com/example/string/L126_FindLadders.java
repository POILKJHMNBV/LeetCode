package com.example.string;

import java.util.*;

/**
 * <p>L126:单词接龙 II</p>
 * @author zhenwu
 * @date 2024/10/13 21:55
 */
public class L126_FindLadders {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(findLadders(beginWord, endWord, wordList));
    }

    private static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return res;
        }
        Map<String, Set<String>> fromMap = new HashMap<>();
        boolean found = bfs(beginWord, endWord, wordSet, fromMap);
        if (found) {
            dfs(beginWord, endWord, fromMap, new ArrayDeque<>(), res);
        }
        return res;
    }

    /**
     * bfs
     * @param beginWord 起始字符串
     * @param endWord 结束字符串
     * @param wordSet 单词集合
     * @param fromMap key-单词  value-到达单词key的单词集合
     * @return 是否找到起始字符串到结束字符串的路径
     */
    private static boolean bfs(String beginWord,
                               String endWord,
                               Set<String> wordSet,
                               Map<String, Set<String>> fromMap) {
        boolean found = false;
        int worLen = beginWord.length();

        // 记录bfs遍历的层数
        int step = 0;
        Map<String, Integer> stepMap = new HashMap<>();
        stepMap.put(beginWord, 0);

        Deque<String> deque = new ArrayDeque<>();
        deque.offer(beginWord);
        while (!deque.isEmpty()) {
            step++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String curWord = deque.poll();
                char[] charArray = curWord.toCharArray();
                for (int j = 0; j < worLen; j++) {
                    char original = charArray[j];

                    // 依次尝试替换当前字符，并判断是否在字典中
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        charArray[j] = ch;
                        String newWord = String.valueOf(charArray);
                        if (stepMap.containsKey(newWord) && stepMap.get(newWord) == step) {
                            fromMap.get(newWord).add(curWord);
                        }

                        if (!wordSet.contains(newWord)) {
                            continue;
                        }

                        // 记录当前单词到达的层数
                        stepMap.put(newWord, step);

                        // 单词入队
                        deque.offer(newWord);

                        // 记录到达单词的路径
                        fromMap.computeIfAbsent(newWord, k -> new HashSet<>()).add(curWord);

                        // 单词已经入队(被访问)，移除单词集合
                        wordSet.remove(newWord);
                        if (newWord.equals(endWord)) {
                            found = true;
                        }
                    }
                    // 恢复原字符
                    charArray[j] = original;
                }
            }

            // 已经找到所有最短路径，提前结束循环
            if (found) {
                break;
            }
        }
        return found;
    }

    /**
     * dfs
     * @param beginWord 起始字符串
     * @param curWord 当前单词
     * @param fromMap key-单词  value-到达单词key的单词集合
     * @param path 路径
     * @param res 结果集
     */
    private static void dfs(String beginWord,
                            String curWord,
                            Map<String, Set<String>> fromMap,
                            Deque<String> path,
                            List<List<String>> res) {
        path.addFirst(curWord);
        if (curWord.equals(beginWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (String word : fromMap.get(curWord)) {
            dfs(beginWord, word, fromMap, path, res);
            path.removeFirst();
        }
    }
}
