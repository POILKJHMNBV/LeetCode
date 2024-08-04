package com.example.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>中文分词模拟器</p>
 * <p>
 *     给定一个连续不包含空格字符的字符串，该字符串仅包含英文小写字母及英文标点符号（逗号、句号、分号），同时给定词库，对该字符串进行精确分词。
 *     说明：
 *          精确分词：字符串分词后，不会出现重叠。例如 "ilovechina"，不同切分后可得到 "i", "love", "china"。
 *          标点符号不分词，仅用于断句。
 *          词库：根据常识及词库统计出来的常用词汇。例如：dictionary={"i","love","china","ilovechina","lovechina"}。
 *          分词原则:采用分词顺序优先且最长匹配原则。“ilovechina”，假设分词结果[i,ilove,lo,love,ch,china,lovechina] 则输出 [ilove,china]
 *              错误输出：[i, lovechina]，原因："ilove" > 优先于 "lovechina" 成词。
 *              错误输出：[i, love, china]，原因："ilove" > "i"，遵循最长匹配原则。
 * </p>
 * <p>
 *     输入描述：
 *          字符串长度限制：0 < length < 256；
 *          词库长度限制：0 < length < 100000；
 *          第一行输入待分词语句 "ilovechina"
 *          第二行输入中文词库 "i, love, china, ch, na, ve, lo, this, is, the, word"
 * </p>
 * <p>
 *     输出描述：
 *          按顺序输出分词结果 "i, love, china"
 * </p>
 * @author zhenwu
 * @date 2024/7/27 16:51
 */
public class H113_ChineseSegmentSimulation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        String[] dict = in.nextLine().split(",");
        Trie trie = new Trie();
        for (String word : dict) {
            trie.insert(word);
        }
        int begin = 0;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == ',' || ch == '.' || ch == ';') {
                res.addAll(trie.split(text.substring(begin, i)));
                begin = i + 1;
            }
        }
        res.addAll(trie.split(text.substring(begin)));
        for (int i = 0; i < res.size() - 1; i++) {
            System.out.print(res.get(i) + ",");
        }
        System.out.print(res.get(res.size() - 1));
    }

    /**
     * 字典树
     */
    private static class Trie {
        final TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.end = true;
        }

        public List<String> split(String text) {
            List<String> res = new ArrayList<>();
            int len = text.length();
            char[] chars = text.toCharArray();
            for (int i = 0; i < len;) {
                TrieNode cur = root;
                int j = i;
                for (; j < len; j++) {
                    int idx = chars[j] - 'a';
                    if (cur.children[idx] == null) {
                        break;
                    }
                    cur = cur.children[idx];
                }
                res.add(text.substring(i, j));
                i = j;
            }
            return res;
        }
    }

    private static class TrieNode {
        final TrieNode[] children;
        boolean end;
        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
}
