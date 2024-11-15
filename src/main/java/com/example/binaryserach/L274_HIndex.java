package com.example.binaryserach;

/**
 * <p>L274:H 指数</p>
 * @author zhenwu
 * @date 2024/11/15 10:50
 */
public class L274_HIndex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(hIndexPro(citations));
    }

    /**
     * H指数
     * 时间复杂度：O(n * n)
     * 空间复杂度：O(n)
     */
    private static int hIndex(int[] citations) {
        int n = citations.length + 1;
        int[] count = new int[n];
        // count[i] 引用次数大于等于i的论文数量
        count[0] = citations.length;
        for (int i = 1; i < n; i++) {
            for (int citation : citations) {
                if (citation >= i) {
                    count[i]++;
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (count[i] >= i) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 优化后的H指数
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int hIndexPro(int[] citations) {
        int n = citations.length;
        int[] cnt = new int[n + 1];
        // count[i] 引用次数恰好为i的论文数量
        for (int c : citations) cnt[Math.min(c, n)]++;
        for (int i = n, tot = 0; i >= 0; i--) {
            tot += cnt[i];
            if (tot >= i) return i;
        }
        return -1;
    }
}
