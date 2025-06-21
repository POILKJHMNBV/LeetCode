package com.example.bit;

/**
 * <p>L868:二进制间距</p>
 * @author zhenwu
 * @date 2025/6/21 15:23
 */
public class L868_BinaryGap {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(log n)
     * 空间复杂度: O(1)
     */
    private static int binaryGap(int n) {
        int ans = 0;
        for (int i = 31, j = -1; i >= 0; i--) {
            if (((n >> i) & 1) == 1) {
                if (j != -1) {
                    ans = Math.max(ans, j - i);
                }
                j = i;
            }
        }
        return ans;
    }
}
