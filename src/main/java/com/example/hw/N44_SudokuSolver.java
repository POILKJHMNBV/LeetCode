package com.example.hw;

import java.util.Scanner;

/**
 * @author zhenwu
 */
public class N44_SudokuSolver {
    public static void main(String[] args) {
        int size = 9;
        Scanner in = new Scanner(System.in);
        int[][] grid = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        if (process(grid)) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static boolean process(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    // 依次尝试1~9中的每一个数
                    for (int k = 1; k <= 9; k++) {
                        if (isValid(i, j, k, grid)) {
                            grid[i][j] = k;
                            // 递归填入下一个格子
                            if (process(grid)) {
                                return true;
                            } else {
                                // 回溯
                                grid[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int i, int j, int num, int[][] grid) {
        // 检查行中是否存在该数字
        for (int k = 0; k < 9; k++) {
            if (grid[i][k] == num) {
                return false;
            }
        }

        // 检查列中是否存在该数字
        for (int k = 0; k < 9; k++) {
            if (grid[k][j] == num) {
                return false;
            }
        }

        // 检查3×3的九宫格内是否存在该数字
        int startRow = i - i % 3;
        int startCol = j - j % 3;
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (grid[startRow + k][startCol + l] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
