package com.example.slidewindow;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>L2271:毯子覆盖的最多白色砖块数</p>
 * @author zhenwu
 * @date 2025/2/12 20:55
 */
public class L2271_MaximumWhiteTiles {
    public static void main(String[] args) {

    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(1)
     */
    private static int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparing(tile -> tile[0]));
        int maxLen = 0;
        for (int l = 0, r = 0, n = tiles.length, cover = 0; r < n; r++) {
            int tl = tiles[r][0], tr = tiles[r][1];
            cover += tr - tl + 1;
            while (tiles[l][1] < tr - carpetLen + 1) {
                // 窗口左边界小于毯子的左端点，毯子不能覆盖窗口
                cover -= tiles[l][1] - tiles[l][0] + 1;
                l++;
            }
            // 毯子未能覆盖的部分
            int uncover = Math.max(0, tr - carpetLen + 1 - tiles[l][0]);
            maxLen = Math.max(maxLen, cover - uncover);
        }
        return maxLen;
    }
}
