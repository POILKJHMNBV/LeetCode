package com.example.matrix;

/**
 * <p>L566:重塑矩阵</p>
 * @author zhenwu
 * @date 2024/12/10 21:34
 */
public class L566_MatrixReshape {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(rc)
     */
    private static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < m * n; ++i) {
            res[i / c][i % c] = mat[i / n][i % n];
        }
        return res;
    }
}
