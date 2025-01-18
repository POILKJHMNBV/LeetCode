package com.example.hash;

import java.util.*;

/**
 * <p>L648:单词替换</p>
 * @author zhenwu
 * @date 2025/1/18 9:16
 */
public class L648_ReplaceWords {
    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("a");
        dictionary.add("aa");
        dictionary.add("aaa");
        dictionary.add("aaaa");
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        System.out.println(replaceWords(dictionary, sentence));
    }

    /**
     * <p>单词替换</p>
     * 时间复杂度：O(n*m)，其中 n 是字典中的单词数，m 是句子中单词的平均长度。
     * 空间复杂度：O(1)。不考虑返回值的空间占用。
     */
    private static String replaceWords(List<String> dictionary, String sentence) {
        dictionary.sort(Comparator.comparingInt(String::length));
        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split(" ")) {
            boolean found = false;
            for (String s : dictionary) {
                if (word.startsWith(s)) {
                    sb.append(s).append(' ');
                    found = true;
                    break;
                }
            }
            if (!found) {
                sb.append(word).append(' ');
            }
        }
        return sb.toString().trim();
    }
}
