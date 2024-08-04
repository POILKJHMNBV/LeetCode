package com.example.sort;

/**
 * <p>LCR170:交易逆序对的总数</p>
 * <P>
 * 在股票交易中，如果前一天的股价高于后一天的股价，则可以认为存在一个「交易逆序对」。请设计一个程序，输入一段时间内的股票交易记录 record，返回其中存在的「交易逆序对」总数。
 * </P>
 * <P>
 * 输入：record = [9, 7, 5, 4, 6]
 * 输出：8
 * 解释：交易中的逆序对为 (9, 7), (9, 5), (9, 4), (9, 6), (7, 5), (7, 4), (7, 6), (5, 4)。
 * </P>
 */
public class L170_ReversePairs {
    public static void main(String[] args) {
        int[] record = {9, 7, 5, 4, 6};
        System.out.println(reversePairs(record));
    }

    private static int reversePairs(int[] record) {
        if (record == null || record.length == 0) {
            return 0;
        }
        return process(record, 0, record.length - 1);
    }

    private static int process(int[] record, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = l + ((r - l) >> 1);
        return process(record, l, m) +
                process(record, m + 1, r) +
                merge(record, l, m, r);
    }

    private static int merge(int[] record, int l, int m, int r) {
        int[] hep = new int[r - l + 1];
        int i = 0;
        int p1 = l, p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            // 归并过程中记录结果数量
            res += record[p1] > record[p2] ? (r - p2 + 1) : 0;
            hep[i++] = record[p1] > record[p2] ? record[p1++] : record[p2++];
        }
        while (p1 <= m) {
            hep[i++] = record[p1++];
        }
        while (p2 <= r) {
            hep[i++] = record[p2++];
        }
        // 将归并结果拷贝回原数组
        System.arraycopy(hep, 0, record, l, hep.length);
        return res;
    }
}
