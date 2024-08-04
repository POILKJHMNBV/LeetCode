package com.example.binaryserach;

import com.example.util.SearchUtils;

/**
 * <p>L74:搜索二维矩阵</p>
 * <p>
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 * </p>
 */
public class L74_SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }
    
    private static boolean searchMatrixPlus(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int row = binarySearch(matrix, target);
        if (row == -1) {
            return false;
        }
        int index = SearchUtils.ceilIndex(matrix[row], target);
        return matrix[row][index] == target;
    }

    private static int binarySearch(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (target < matrix[m][0]) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        if (l == 0 && matrix[l][0] > target) {
            return -1;
        }
        return l;
    }
}
