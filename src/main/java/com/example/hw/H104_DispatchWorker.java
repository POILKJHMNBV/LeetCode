package com.example.hw;

import java.util.Scanner;

/**
 * <p>员工派遣</p>
 * <p>
 *     某公司部门需要派遣员工去国外做项目。
 *     现在，代号为x的国家和代号为y的国家分别需要cntx名和cnty名员工。
 *     部门每个员工有一个员工号(1,2,3.....)，工号连续，从1开始。
 *     部长派遣员工的规则:
 *          规则1、从[1, k] 中选择员工派遣出去
 *          规则2、编号为x的倍数的员工不能去x国，编号为y的倍数的员工不能去y国
 *     找到最小的k，使得可以将编号在[1, k]中的员工分配给X国和y国，且满足x国和y国的需求
 * </p>
 * <p>
 *     输入描述：四个整数 x,y, cntx,cnty。(2 <= x < y <= 30000; x和y一定是质数;)
 * </p>
 * <p>
 *     输出描述：满足条件的最小的k
 * </p>
 * @author zhenwu
 * @date 2024/7/27 9:51
 */
public class H104_DispatchWorker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int cntX = in.nextInt();
        int cntY = in.nextInt();
        int l = 1, r = (int) Math.pow(10, 9);
        while (l < r) {
            int m = l + (r - l) / 2;
            if (!dispatchSuccess(m, x, y, cntX, cntY)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        System.out.println(l);
    }

    private static boolean dispatchSuccess(int k, int x, int y, int cntX, int cntY) {
        if (k < cntX + cntY) {
            return false;
        }

        // x国和y国都不能分配的人
        int count = k / (x * y);

        // 可以分配到y国，不能分配到x国的人
        int countY = k / x - count;

        // 可以分配到y国，不能分配到x国的人
        int countX = k / y - count;

        // 还差的人数
        int missing = Math.max(0, cntX - countX) + Math.max(0, cntY - countY);

        return k - countX - countY - count - missing >= 0;
    }
}
