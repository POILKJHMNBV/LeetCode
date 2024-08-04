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
