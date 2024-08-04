package com.example.hw;

import java.util.Scanner;

/**
 * <p>分月饼</p>
 * <p>
 *     中秋节，公司分月饼，m个员工，买了n个月饼，m<=n，每个员工至少分1个月饼，但可以分多个，
 *     单人分到最多月饼的个数是Max1，单人分到第二多月饼个数是Max2，Max1-Max2<=3，
 *     单人分到第n-1多月饼个数是Max(n-1)，单人分到第n多月饼个数是Max(n)，Max(n-1)-Max(n)<=3问有多少种分月饼的方法?
 * </p>
 * <p>
 *     输入描述：每一行输入m n，表示m个员工，n个月饼，m<=n
 * </p>
 * <p>
 *     输出描述：输出有多少种月饼分法
 * </p>
 * @author zhenwu
 * @date 2024/7/13 13:17
 */
public class H36_AllocateMoonCake {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int staffNum = in.nextInt();
        int moonCakeNum = in.nextInt();
        for (int i = 1; i <= moonCakeNum / staffNum; i++) {
            dfs(staffNum, 1, i, moonCakeNum - i);
        }
        System.out.println(count);
    }

    static int count = 0;

    /**
     * 暴力递归求解
     * @param staffNum 员工数量
     * @param staff 当前员工编号
     * @param allocatedMoonCake 当前员工分配的月饼个数
     * @param remainMoonCake 还剩余的月饼个数
     */
    private static void dfs(int staffNum, int staff, int allocatedMoonCake, int remainMoonCake) {
        if (staff == staffNum - 1) {
            if (remainMoonCake < allocatedMoonCake) {
                return;
            }
            if (remainMoonCake - allocatedMoonCake <= 3) {
                count++;
            }
            return;
        }
        for (int i = allocatedMoonCake; i <= allocatedMoonCake + 3; i++) {
            dfs(staffNum, staff + 1, i, remainMoonCake - i);
        }
    }
}
