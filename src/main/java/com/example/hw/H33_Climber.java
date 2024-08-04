package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>攀登者1</p>
 * <p>
 *     攀登者喜欢寻找各种地图，并且尝试攀登到最高的山峰。
 *     地图表示为一维数组，数组的索引代表水平位置，数组的元素代表相对海拔高度。其中数组元素0代表地面。
 *     例如：[0,1,2,4,3,1,0,0,1,2,3,1,2,1,0]，代表如下图所示的地图，地图中有两个山脉位置分别为 1,2,3,4,5 和 8,9,10,11,12,13，最高峰高度分别为 4,3。最高峰位置分别为3,10。
 *     一个山脉可能有多座山峰(高度大于相邻位置的高度，或在地图边界且高度大于相邻的高度)。
 * </p>
 * <p>
 *     输入描述：输入为一个整型数组，数组长度大于1。
 * </p>
 * <p>
 *     输出描述：输出地图中山峰的数量。
 * </p>
 * @author zhenwu
 * @date 2024/7/11 20:46
 */
public class H33_Climber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] heights = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (isPeak(heights, i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isPeak(int[] heights, int i) {
        return (i == 0 || heights[i] > heights[i - 1]) && (i == heights.length - 1 || heights[i] > heights[i + 1]);
    }
}
