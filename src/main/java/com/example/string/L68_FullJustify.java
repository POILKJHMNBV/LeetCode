package com.example.string;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L68:文本左右对齐</p>
 * @author zhenwu
 * @date 2024/10/4 9:56
 */
public class L68_FullJustify {
    public static void main(String[] args) {
        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth = 16;
        List<String> list = fullJustify(words, maxWidth);
        list.forEach(s -> System.out.println(s.length()));
        list.forEach(System.out::println);
    }

    /**
     * 时间：O(n)  空间：O(1)
     */
    private static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int n = words.length, i = 0, j = 0;

        // 遍历单词
        while (j < n) {
            int len = -1;
            while (j < n) {
                // 计算当前行单词的数量
                len += words[j].length() + 1;
                if (len > maxWidth) {
                    len -= (words[j].length() + 1);
                    break;
                }
                j++;
            }
            StringBuilder sb = new StringBuilder();

            // 计算单词间的间隙数量
            int gapCount = j - i - 1;

            // 处理最后一行或中间行的情况
            if (j < n && gapCount != 0) {
                // 该行单词数量不止一个

                // 需要插入的总的空格数量
                int totalSpaceCount = maxWidth - (len - gapCount);

                // 已经插入的空格数量
                int curSpaceCount = 0;
                while (i < j) {
                    sb.append(words[i++]);
                    // 计算每个单词之间插入的空格数量，按照贪心思路，尽可能均匀分配单词间的空格数量
                    int spaceLen = (int) Math.ceil((totalSpaceCount - curSpaceCount) * 1.0 / gapCount--);
                    curSpaceCount += spaceLen;
                    while (spaceLen-- > 0) {
                        sb.append(' ');
                    }
                }
            } else {
                // 该行只有一个单词或为最后一行
                while (i < j) {
                    sb.append(words[i++]);
                    if (sb.length() < maxWidth) {
                        sb.append(' ');
                    }
                }
                while (sb.length() < maxWidth) {
                    sb.append(' ');
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
