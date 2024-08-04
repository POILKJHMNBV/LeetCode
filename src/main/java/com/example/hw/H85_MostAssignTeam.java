package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>求最多可以派出多少只团队</p>
 * <p>
 *     用数组代表每个人的能力，一个比赛活动要求参赛团队的最低能力值为 N，每个团队可以由 1 人或 2 人组成，且 1 个人只能参加 1 个团队，
 *     请计算出最多可以派出多少支符合要求的团队
 * </p>
 * <p>
 *     输入描述：
 *          第一行代表总人数，范围[1,500000]
 *          第二行数组代表每个人的能力，每个元素的取值范围为[1,500000],数组的大小范围[1,500000]
 *          第三行数值为团队要求的最低能力值，范围[1,500000]
 * </p>
 * <p>
 *     输出描述：最多可以派出的团队的数量
 * </p>
 * @author zhenwu
 * @date 2024/7/21 21:15
 */
public class H85_MostAssignTeam {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] levels = new int[n];
        for (int i = 0; i < n; i++) {
            levels[i] = in.nextInt();
        }
        int minLevel = in.nextInt();

        Arrays.sort(levels);
        int count = 0;
        int l = 0, r = n - 1;
        while (l <= r) {
            if (levels[r] >= minLevel) {
                r--;
            } else if (levels[l] + levels[r] >= minLevel) {
                l++;
                r--;
            } else {
                l++;
                continue;
            }
            count++;
        }
        System.out.println(count);
    }
}
