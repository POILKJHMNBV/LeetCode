package com.example.matrix;

/**
 * <p>L867:转置矩阵</p>
 * @author zhenwu
 * @date 2024/12/11 22:03
 */
public class L867_Transpose {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(mn)
     * 空间复杂度：O(1)
     */
    private static int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}
