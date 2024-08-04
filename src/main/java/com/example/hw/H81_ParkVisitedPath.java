package com.example.hw;

import com.example.dp.L62_UniquePaths;
import com.example.dp.L63_UniquePathsWithObstacles;

import java.util.Scanner;

/**
 * <p>园区参观路径</p>
 * <p>
 *     园区某部门举办了Family Day，邀请员工及其家属参加；
 *     将公司园区视为一个矩形，起始园区设置在左上角，终点园区设置在右下角；
 *     家属参观园区时，只能向右和向下园区前进，求从起始园区到终点园区会有多少条。
 * </p>
 * <p>
 *      输入描述：
 *          输入第一行为园区的长和宽；
 *          接下来每一行表示该园区是否可以参观，0表示可以参观，1表示不可以参观。
 * </p>
 * <p>
 *     输出描述：
 *          输出为不同路径的数量
 * </p>
 * @see L62_UniquePaths
 * @see L63_UniquePathsWithObstacles
 * @author zhenwu
 * @date 2024/7/21 14:25
 */
public class H81_ParkVisitedPath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt(), cols = in.nextInt();
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = in.nextInt();
            }
        }

        // dp[i][j]表示到达(i, j)的路径条数
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (grid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        System.out.println(dp[rows - 1][cols - 1]);
    }
}
