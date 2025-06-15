package com.example.matrix;

/**
 * <p>L909:蛇梯棋</p>
 * @author zhenwu
 * @date 2025/6/15 10:15
 */
public class L909_SnakesAndLadders {
    public static void main(String[] args) {
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        System.out.println(snakesAndLadders(board));
    }


    /**
     * BFS
     * 时间复杂度: O(n * n)
     * 空间复杂度: O(n * n)
     */
    private static int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n * n + 1];
        vis[1] = true;
        int[] q = new int[n * n];
        int head = 0, tail = 0;
        q[tail++] = 1; // 起点
        for (int step = 0; head < tail; step++) {
            for (int size = tail - head; size > 0; size--) {
                int x = q[head++];
                if (x == n * n) {
                    return step; // 终点
                }
                for (int y = x + 1; y <= Math.min(x + 6, n * n); y++) {
                    int r = (y - 1) / n;
                    int c = (y - 1) % n;
                    if (r % 2 > 0) {
                        c = n - 1 - c; // 奇数行从右到左
                    }
                    int nxt = board[n - 1 - r][c];
                    if (nxt < 0) {
                        nxt = y;
                    }
                    if (!vis[nxt]) {
                        vis[nxt] = true; // 有环的情况下，避免死循环
                        q[tail++] = nxt;
                    }
                }
            }
        }
        return -1; // 无法到达终点
    }
}
