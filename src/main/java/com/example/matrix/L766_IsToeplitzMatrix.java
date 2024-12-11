package com.example.matrix;

/**
 * <p>L766:托普利茨矩阵</p>
 * @author zhenwu
 * @date 2024/12/11 21:53
 */
public class L766_IsToeplitzMatrix {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(mn)
     * 空间复杂度：O(1)
     */
    private static boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) return false;
            }
        }
        return true;
    }

    /**
     * 时间复杂度：O(mn)
     * 空间复杂度：O(1)
     */
    private static boolean isToeplitzMatrixPro(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int rows = m, cols = n;
        while (cols-- > 0) {
            for(int i = 0, j = cols, val = matrix[i++][j++]; i < m && j < n; i++, j++) {
                if(matrix[i][j] != val) return false;
            }
        }
        while (rows-- > 0) {
            for (int i = rows, j = 0, val = matrix[i++][j++]; i < m && j < n; i++, j++) {
                if (matrix[i][j] != val) return false;
            }
        }
        return true;
    }
}
