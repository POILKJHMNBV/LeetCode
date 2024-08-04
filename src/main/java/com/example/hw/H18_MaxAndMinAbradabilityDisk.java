package com.example.hw;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * <p>找磨损度最高和最低的硬盘</p>
 * <p>
 *     存储阵列上使用的一批固态硬盘，根据硬盘磨损值给定一个数组endurances,数组中每个元素表示单块硬盘的磨损度(0到10000之间)。
 *     磨损度越大，表示此盘需要更换的概率越高。需要找出磨损度最高三块盘下标和磨损度最低的三块盘下标。
 * </p>
 * <p>
 *     输入描述：
 *          一组硬盘磨损度的数组。
 *          说明:
 *          (1) 数组endurances中无重复值
 *          (2) 数组的长度范围:[6,200]
 *          (3) 数组的下标从0开始。
 * </p>
 * <p>
 *     输出描述：
 *          第一行:磨损度最高三块盘下标，按下标升序展示
 *          第二行:磨损度最低的三块盘下标，按下标升序展示
 * </p>
 * @author zhenwu
 * @date 2024/7/7 8:21
 */
public class H18_MaxAndMinAbradabilityDisk {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] endurances = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = endurances.length;
        int[][] nums = new int[length][2];
        for (int i = 0; i < length; i++) {
            nums[i] = new int[] {endurances[i], i};
        }
        Arrays.sort(nums, Comparator.comparingInt(o -> o[0]));
        int[] maxThreeArray = new int[3];
        int[] minThreeArray = new int[3];
        for (int i = 0; i < 3; i++) {
            minThreeArray[i] = nums[i][1];
        }
        for (int i = 0; i < 3; i++) {
            maxThreeArray[i] = nums[i + length - 3][1];
        }
        Arrays.sort(maxThreeArray);
        Arrays.sort(minThreeArray);
        System.out.println(Arrays.toString(maxThreeArray));
        System.out.println(Arrays.toString(minThreeArray));
    }
}
