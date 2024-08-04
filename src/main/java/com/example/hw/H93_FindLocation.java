package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>小明找位置</p>
 * <p>
 *     小朋友出操，按学号从小到大排成一列；小明来迟了，请你给小明出个主意，让他尽快找到他应该排的位置。
 * </p>
 * <p>
 *     输入描述：
 *          第一行：输入已排成队列的小朋友的学号（正整数），以空格隔开。
 *          第二行：小明的学号；
 *          算法复杂度要求不高于 nlog(n)。
 *          学号为整数类型，队列规模 ≤ 10000。
 * </p>
 * <p>
 *     输出描述：
 *          输出一个数字，代表队列位置（从 1 开始）。
 * </p>
 * @author zhenwu
 * @date 2024/7/23 20:11
 */
public class H93_FindLocation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(in.nextLine());
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (l == nums.length - 1 && nums[l] < target) {
            System.out.println(nums.length + 1);
        } else {
            System.out.println(l + 1);
        }
    }
}
