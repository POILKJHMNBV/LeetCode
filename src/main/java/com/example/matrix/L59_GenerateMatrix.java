package com.example.matrix;


/**
 * <p>L59:螺旋矩阵 II</p>
 * <p>给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix</p>
 */
public class L59_GenerateMatrix {
    public static void main(String[] args) {

    }

    private static int[][] generateMatrix(int n) {
        // 定义左、右、上、下边界
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] ans = new int[n][n];
        int j = 1;
        while (true) {
            // 从左往右进行遍历
            for (int i = l; i <= r; i++) {
                ans[t][i] = j++;
            }
            if (++t > b) {
                break;
            }

            // 从上往下进行遍历
            for (int i = t; i <= b; i++) {
                ans[i][r] = j++;
            }
            if (l > --r){
                break;
            }

            // 从右往左进行遍历
            for (int i = r; i >= l ; i--) {
                ans[b][i] = j++;
            }
            if (t > --b) {
                break;
            }

            // 从下往上遍历
            for (int i = b; i >= t ; i--) {
                ans[i][l] = j++;
            }
            if (++l > r) {
                break;
            }
        }
        return ans;
    }
}
