package com.example.matrix;

import com.example.array.L303_NumArray;

/**
 * <p>L304:二维区域和检索 - 矩阵不可变</p>
 * @author zhenwu
 * @date 2024/12/1 20:28
 * @see L303_NumArray
 */
public class L304_NumMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }

    static class NumMatrix {

        private final int[][] prefixMatrix;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            prefixMatrix = new int[m][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    prefixMatrix[i][j + 1] = prefixMatrix[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                sum += prefixMatrix[i][col2 + 1] - prefixMatrix[i][col1];
            }
            return sum;
        }
    }
}
