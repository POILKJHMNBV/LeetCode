package com.example.matrix;

/**
 * <p>L223:矩形面积</p>
 * @author zhenwu
 * @date 2024/11/5 21:26
 */
public class L223_ComputeArea {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     */
    private static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int x = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int y = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - x * y;
    }
}
