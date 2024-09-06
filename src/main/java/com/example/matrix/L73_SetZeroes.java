package com.example.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>L73:矩阵置零</p>
 * <p>给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。</p>
 */
public class L73_SetZeroes {
    public static void main(String[] args) {

    }

    private static void setZeroesPro(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        boolean row0Flag = false, col0Flag = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i > 0 && j > 0 && matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        row0Flag = true;
                    }
                    if (j == 0) {
                        col0Flag = true;
                    }
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row0Flag) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col0Flag) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    private static void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int row : rowSet) {
            for (int i = 0; i < cols; i++) {
                matrix[row][i] = 0;
            }
        }
        for (int col : colSet) {
            for (int i = 0; i < rows; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}
