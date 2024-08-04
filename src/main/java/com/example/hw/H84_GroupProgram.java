package com.example.hw;

import java.util.Scanner;

/**
 * <p>结队编程</p>
 * <p>
 *     某部门计划通过结队编程来进行项目开发，已知该部门有 N 名员工，每个员工有独一无二的职级，每三个员工形成一个小组进行结队编程，结队分组规则如下：
 *     从部门中选出序号分别为 i、j、k 的3名员工，他们的职级分别为 level[i]，level[j]，level[k]，结队小组满足 level[i] < level[j] < level[k] 或者 level[i] > level[j] > level[k]，其中 0 ≤ i < j < k < n。
 *     请你按上述条件计算可能组合的小组数量。同一员工可以参加多个小组
 * </p>
 * <p>
 *     输入描述：
 *          第一行输入：员工总数 n，1 <= n <= 6000
 *          第二行输入：按序号依次排列的员工的职级 level，中间用空格隔开,1 <= level[i] <= 10^5
 * </p>
 * <p>
 *     输出描述：可能结队的小组数量
 * </p>
 * @author zhenwu
 * @date 2024/7/21 15:57
 */
public class H84_GroupProgram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] levels = new int[n];
        for (int i = 0; i < n; i++) {
            levels[i] = in.nextInt();
        }

        int[][] lt = new int[n][2];
        int[][] gt = new int[n][2];
        // 求解每个位置左边比其小和比其大的元素个数
        for (int i = 0; i < n; i++) {
            int count1 = 0;
            int count2 = 0;
            for (int j = 0; j < i; j++) {
                if (levels[j] < levels[i]) {
                    count1++;
                } else {
                    count2++;
                }
            }
            lt[i][0] = count1;
            lt[i][1] = count2;
        }

        // 求解每个位置右边比其小和比其大的元素个数
        for (int i = n - 1; i >= 0; i--) {
            int count1 = 0;
            int count2 = 0;
            for (int j = i + 1; j < n; j++) {
                if (levels[j] > levels[i]) {
                    count1++;
                } else {
                    count2++;
                }
            }
            gt[i][0] = count1;
            gt[i][1] = count2;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (lt[i][0] * gt[i][0] + lt[i][1] * gt[i][1]);
        }
        System.out.println(sum);
    }
}