package com.example.array;

/**
 * <p>L2038:如果相邻两个颜色均相同则删除当前颜色</p>
 * @author zhenwu
 * @date 2025/3/24 22:03
 */
public class L2038_WinnerOfGame {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n * log n)
     * 空间复杂度：O(1)
     */
    private static boolean winnerOfGame(String colors) {
        char[] chars = colors.toCharArray();
        int cntA = 0, cntB = 0;
        for (int i = 0, n = chars.length; i < n; i++) {
            char ch = chars[i];
            int j = i;
            while (j < n && chars[j] == ch) {
                j++;
            }
            int num = j - i - 2;
            if (num > 0) {
                if (ch == 'A') {
                    cntA += num;
                } else {
                    cntB += num;
                }
            }
            i = j - 1;
        }
        return cntA > cntB;
    }
}
