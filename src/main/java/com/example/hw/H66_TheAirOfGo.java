package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>围棋的气</p>
 * <p>
 *     围棋棋盘由纵横各19条线垂直相交组成，棋盘上一共19x19=361个交点，对弈双方一方执白棋，一方执黑棋，落子时只能将棋子置于交点上。
 *     “气”是围棋中很重要的一个概念，某个棋子有几口气，是指其上下左右方向四个相邻的交叉点中，有几个交叉点没有棋子
 * </p>
 * <p>
 *     输入描述：
 *          输入包括两行数据，如:
 *          0 5 8 9 9 10
 *          5 0 9 9 9 8
 *          1、每行数据以空格分隔，数据个数是2的整数倍，每两个数是一组,代表棋子在棋盘上的坐标；
 *          2、坐标的原点在棋盘左上角点，第一个值是行号，范围从0到18;第二个值是列号，范围从0到18；
 *          3、举例说明: 第一行数据表示三个坐标 (0，5)、 (8，9)、 (9,10)；
 *          4、第一行表示黑棋的坐标，第二行表示白棋的坐标。
 *          5、题目保证输入两行数据，无空行且每行按前文要求是偶数个，每个坐标不会超出棋盘范围。
 * </p>
 * <p>
 *     输出描述：
 *          8 7
 *          两个数字以空格分隔，第一个数代表黑棋的气数，第二个数代表白棋的气数。
 * </p>
 * @author zhenwu
 * @date 2024/7/18 20:15
 */
public class H66_TheAirOfGo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] blackChess = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] whiteChess = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] board = new int[19][19];
        for (int i = 0; i < blackChess.length; i += 2) {
            board[blackChess[i]][blackChess[i + 1]] = -1;
        }
        for (int i = 0; i < whiteChess.length; i += 2) {
            board[whiteChess[i]][whiteChess[i + 1]] = 1;
        }

        int blackAir = 0, whiteAir = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        boolean[][] blackVisited = new boolean[19][19], whiteVisited = new boolean[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        int newX = i + dx[k];
                        int newY = j + dy[k];
                        if (inArea(board, newX, newY)) {
                            if (board[i][j] == -1 && !blackVisited[newX][newY] && board[newX][newY] == 0) {
                                blackAir++;
                                blackVisited[newX][newY] = true;
                            }
                            if (board[i][j] == 1 && !whiteVisited[newX][newY] && board[newX][newY] == 0) {
                                whiteAir++;
                                whiteVisited[newX][newY] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(blackAir + " " + whiteAir);
    }

    private static boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
