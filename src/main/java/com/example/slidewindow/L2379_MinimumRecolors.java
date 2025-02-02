package com.example.slidewindow;

/**
 * <p>L2379:得到 K 个黑块的最少涂色次数</p>
 * @author zhenwu
 * @date 2025/2/2 16:28
 */
public class L2379_MinimumRecolors {
    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBBWWBBWBW", 7));
        System.out.println(minimumRecolors("WBWBBBW", 2));
    }

    /**
     * 滑动窗口算法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int minimumRecolors(String blocks, int k) {
        char[] blockArray = blocks.toCharArray();
        int n = blockArray.length;
        int min = 0;
        for (int i = 0; i < k; i++) {
            if (blockArray[i] == 'W') {
                min++;
            }
        }
        int res = min;
        int l = 0, r = k;
        while (r < n) {
            if (blockArray[r++] == 'W') {
                min++;
            }
            if (blockArray[l++] == 'W') {
                min--;
            }
            res = Math.min(min, res);
        }
        return res;
    }
}
