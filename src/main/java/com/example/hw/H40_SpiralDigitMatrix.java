package com.example.hw;

import com.example.matrix.L54_SpiralOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <p>螺旋数字矩阵</p>
 * <p>
 *     疫情期间，小明隔离在家，百无聊赖，在纸上写数字玩。他发明了一种写法:
 *     给出数字个数n和行数m (0 < n <= 999，0 < m <= 999)，从左上角的1开始，按照顺时针螺旋向内写方式，依次写出2,3...n，最终形成一个m行矩阵。
 *     小明对这个矩阵有些要求:
 *          1.每行数字的个数一样多
 *          2.列的数量尽可能少
 *          3.填充数字时优先填充外部
 *          4.数字不够时，使用单个*号占位
 * </p>
 * <p>
 *     输入描述：两个整数，空格隔开，依次表示n、m
 * </p>
 * <p>
 *     输出描述：符合要求的唯一矩阵
 * </p>
 * @see L54_SpiralOrder
 * @author zhenwu
 * @date 2024/7/13 15:21
 */
public class H40_SpiralDigitMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int cols = (int) Math.ceil(n * 1.0 / m);
        String[][] matrix = new String[m][cols];
        // 定义左、右、上、下边界
        int l = 0, r = cols - 1, t = 0, b = m - 1;
        int count = 0;
        while (true) {
            // 从左往右进行遍历
            for (int i = l; i <= r; i++) {
                count++;
                matrix[t][i] = count > n ? "*" : String.valueOf(count);
            }
            if (++t > b) {
                break;
            }

            // 从上往下进行遍历
            for (int i = t; i <= b; i++) {
                count++;
                matrix[i][r] = count > n ? "*" : String.valueOf(count);
            }
            if (l > --r){
                break;
            }

            // 从右往左进行遍历
            for (int i = r; i >= l ; i--) {
                count++;
                matrix[b][i] = count > n ? "*" : String.valueOf(count);
            }
            if (t > --b) {
                break;
            }

            // 从下往上遍历
            for (int i = b; i >= t ; i--) {
                count++;
                matrix[i][l] = count > n ? "*" : String.valueOf(count);
            }
            if (++l > r) {
                break;
            }
        }
        for (String[] strings : matrix) {
            System.out.println(Arrays.toString(strings));
        }
    }
}
