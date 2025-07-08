package com.example.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L2564:子字符串异或查询</p>
 * @author zhenwu
 * @date 2025/7/8 22:09
 */
public class L2564_SubstringXorQueries {
    public static void main(String[] args) {

    }

    static final int HIGHEST_BIT = 30;

    /**
     * 时间复杂度: O(n * m + q)
     * 其中 n 是字符串 s 的长度，m 是二进制位数上限，m=31，
     * q 是数组 queries 的长度。预处理时需要遍历字符串 s 的每个下标作为起始下标，
     * 每个起始下标的计算时间是 O(m)，因此预处理的时间是 O(nm)，预处理之后每个查询的计算时间都是 O(1)，因此时间复杂度是 O(n * m + q)。
     * 空间复杂度: O(n * m + q)
     * 其中 n 是字符串 s 的长度，m 是二进制位数上限，m=31。哈希表中记录的预处理结果数量是 O(n * m)
     */
    private static int[][] substringXorQueries(String s, int[][] queries) {
        Map<Integer, int[]> ranges = new HashMap<Integer, int[]>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '0') {
                ranges.putIfAbsent(0, new int[]{i, i});
                continue;
            }
            int end = Math.min(i + HIGHEST_BIT, length - 1);
            int val = 0;
            for (int j = i; j <= end; j++) {
                val = val * 2 + s.charAt(j) - '0';
                ranges.putIfAbsent(val, new int[]{i, j});
            }
        }
        int queriesCount = queries.length;
        int[][] ans = new int[queriesCount][];
        for (int i = 0; i < queriesCount; i++) {
            int val = queries[i][0] ^ queries[i][1];
            ans[i] = ranges.getOrDefault(val, new int[]{-1, -1});
        }
        return ans;
    }
}
