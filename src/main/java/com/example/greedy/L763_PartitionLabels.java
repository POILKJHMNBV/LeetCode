package com.example.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L763:划分字母区间</p>
 * <p>
 *     给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 *     注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 *     返回一个表示每个字符串片段的长度的列表。
 * </p>
 * @author zhenwu
 * @date 2024/8/6 20:27
 */
public class L763_PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    private static List<Integer> partitionLabels(String s) {
        // 记录每个字符最后一次出现的下标
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
