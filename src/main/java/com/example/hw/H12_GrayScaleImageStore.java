package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>灰度图存储</p>
 * <p>
 *     黑白图像常采用灰度图的方式存储，即图像的每个像素填充一个灰色阶段值，256节阶灰图是一个灰阶值取值范围为0-255的灰阶矩阵，0表示全黑，255表示全白，范围内的其他值表示不同的灰度。
 *     但在计算机中实际存储时，会使用压缩算法，其中一个种压缩格式描述如如下：
 *          10 10 255 34 0 1 255 8 0 3 255 6 0 5 255 4 0 7 255 2 0 9 255 21
 *        1.所有的数值以空格分隔；
 *        2.前两个数分别表示矩阵的行数和列数；
 *        3.从第三个数开始，每两个数一组，每组第一个数是灰阶值，第二个数表示该灰阶值从左到右，从上到下（可理解为二维数组按行存储在一维矩阵中）的连续像素个数。
 *          比如题目所述的例子， “255 34” 表示有连续 34 个像素的灰阶值是 255。
 *     如此，图像软件在打开此格式灰度图的时候，就可以根据此算法从压缩数据恢复出原始灰度图矩阵。
 * </p>
 * <p>
 *     输入描述:
 *          10 10 255 34 0 1 255 8 0 3 255 6 0 5 255 4 0 7 255 2 0 9 255 21
 *          3   4
 *     输出描述:
 *          输出数据表示的灰阶矩阵的指定像素的灰阶值。
 * </p>
 * @author zhenwu
 * @date 2024/7/3 20:28
 */
public class H12_GrayScaleImageStore {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] metaDataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] location = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = metaDataArray[0];
        int cols = metaDataArray[1];
        int[][] grid = new int[rows][cols];
        int x = 0, y = 0;
        for (int i = 2; i < metaDataArray.length; i += 2) {
            for (int l = 0; l < metaDataArray[i + 1]; l++) {
                if (y == cols) {
                    x++;
                    y = 0;
                }
                grid[x][y++] = metaDataArray[i];
            }
        }
        System.out.println(grid[location[0]][location[1]]);
    }
}
