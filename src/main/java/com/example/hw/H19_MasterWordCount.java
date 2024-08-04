package com.example.hw;

import java.util.Scanner;

/**
 * <p>掌握的单词个数 </p>
 * <p>
 *  有一个字符串数组 words 和一个字符串 chars。假如可以用 chars 中的字母拼写出 words 中的某个"单词"（字符串)，那么我们就认为你掌握了这个单词。
 *  words 的字等仅由 a-z 英文小写宁母组成，例如“abc”。
 *  chars 由 a- z 英文小写字母和“?”组成，其中英文“?"表示万能字符，能够在拼写时当作任意一个英文字母。例如“?"可以当作"a"等字母。
 *  注意: 每次拼写时，chars 中的每个字母和万能字符都只能使用一次。输出词汇表 words 中你掌握的所有单词的个数。没有掌握任何单词，则输出0。
 * </p>
 * <p>
 *     输入描述：
 *          第一行: 输入数组 words 的个数，记作N。
 *          第二行~第N+1行: 依次输入数组words的每个字符串元素。
 *          第N+2行: 输入字符串 chars
 * </p>
 * <p>
 *     输出描述：输出一个整数，表示词汇表 words 中你掌握的单词个数
 * </p>
 * @author zhenwu
 * @date 2024/7/7 8:33
 */
public class H19_MasterWordCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int wordCount = in.nextInt();
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            words[i] = in.next();
        }
        String dictionary = in.next();
        Counter dictionaryCounter = new Counter(dictionary);
        int count = 0;
        for (String word : words) {
            Counter wordCounter = new Counter(word);
            if (dictionaryCounter.master(wordCounter)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static class Counter {
        final int[] count;
        int specialCount;

        public Counter(String s) {
            count = new int[26];
            specialCount = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '?') {
                    specialCount++;
                    continue;
                }
                count[ch - 'a']++;
            }
        }

        public boolean master(Counter wordCounter) {
            int length = count.length;
            for (int i = 0; i < length; i++) {
                if (wordCounter.count[i] > count[i]) {
                    specialCount -= (wordCounter.count[i] - count[i]);
                }
            }
            return specialCount >= 0;
        }
    }
}
