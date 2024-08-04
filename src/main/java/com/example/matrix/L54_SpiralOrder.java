package com.example.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L54:螺旋矩阵</p>
 * <p>给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素</p>
 */
public class L54_SpiralOrder {
    public static void main(String[] args) {

    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        // 定义左、右、上、下边界
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        List<Integer> res = new ArrayList<>();
        while (true) {
            // 从左往右进行遍历
            for (int i = l; i <= r; i++) {
                res.add(matrix[t][i]);
            }
            if (++t > b) {
                break;
            }

            // 从上往下进行遍历
            for (int i = t; i <= b; i++) {
                res.add(matrix[i][r]);
            }
            if (l > --r){
                break;
            }

            // 从右往左进行遍历
            for (int i = r; i >= l ; i--) {
                res.add(matrix[b][i]);
            }
            if (t > --b) {
                break;
            }

            // 从下往上遍历
            for (int i = b; i >= t ; i--) {
                res.add(matrix[i][l]);
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }
}
