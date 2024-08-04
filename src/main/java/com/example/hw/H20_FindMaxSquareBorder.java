package com.example.hw;

import java.util.Scanner;

/**
 * <p>平面灯阵中寻找最大正方形边界</p>
 * <p>
 *     现在有一个二维数组来模拟一个平面灯阵，平面灯阵中每个位置灯处于点亮或熄灭，分别对应数组每个元素取值只能为1或0，
 *     现在需要找一个正方形边界，其每条边上的灯都是点亮(对应数组中元素的值为1)的，且该正方形面积最大。
 * </p>
 * <p>
 *     输入描述：
 *        第一行为灯阵的高度(二维数组的行数)
 *        第二行为灯阵的宽度(二维数组的列数)
 *        紧接着为模拟平台灯阵的二维数组arr
 *        1< arr.length <= 200 1< arr[0].length <= 200
 * </p>
 * <p>
 *     输出描述：返回满足条件的面积最大正方形边界信息。
 *     返回信息[r,c,w],其中r,c分别代表方阵右下角的行号和列号，w代表正方形的宽度。如果存在多个满足条件的正方形，则返回r最小的，若r相同，返回c最小的正方形。
 * </p>
 * @author zhenwu
 * @date 2024/7/7 9:35
 */
public class H20_FindMaxSquareBorder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();int cols = in.nextInt();;
        int[][] grid = new int[rows][cols];

        // 每个位置左侧连续1的数量(包括自己)
        int[][] leftNum = new int[rows][cols];

        // 每个位置上侧连续1的数量(包括自己)
        int[][] topNum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = in.nextInt();
                if (grid[i][j] == 1) {
                    leftNum[i][j] = j - 1 >= 0 ? leftNum[i][j - 1] + 1 : 1;
                    topNum[i][j] = i - 1 >= 0 ? topNum[i - 1][j] + 1 : 1;
                }
            }
        }

        int x = 0, y = 0, c = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int border = Math.min(leftNum[i][j], topNum[i][j]);
                    if (legalBorder(leftNum, topNum, i, j, border) && border > c) {
                        x = i;
                        y = j;
                        c = border;
                    }
                }
            }
        }

        System.out.println("[" + x + "," + y + "," + c + "]");
    }

    private static boolean legalBorder(int[][] leftNum, int[][] topNum, int x, int y, int border) {
        // 以当前点作为正方形的右下角，考察正方形的左下角和右上角
        int leftBottomY = y - border + 1;
        int rightTopX = x - border + 1;
        if (leftBottomY < 0 || rightTopX < 0) {
            return false;
        }
        return topNum[x][leftBottomY] >= border && leftNum[rightTopX][y] >= border;
    }
}