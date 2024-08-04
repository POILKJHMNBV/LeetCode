package com.example.hw;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * <p>最大N个数与最小N个数的和</p>
 * <p>
 *     给定一个数组，编写一个函数来计算它的最大N个数与最小N个数的和。你需要对数组进行去重。
 *     说明：
 *          数组中数字范围[0,1000]
 *          最大N个数与最小N个数不能有重叠，如有重叠，输入非法返回-1
 *          输入非法返回-1
 * </p>
 * <p>
 *     输入描述：
 *          第一行输入M, M标识数组大小
 *          第二行输入M个数，标识数组内容
 *          第三行输入N，N表示需要计算的最大、最小的N个数
 * </p>
 * <p>
 *     输出描述：输出最大N个数与最小N个数的和。
 * </p>
 * @author zhenwu
 * @date 2024/7/17 21:25
 */
public class H65_MaxNAndMinNSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        if (m < 1) {
            System.out.println(-1);
            return;
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            int num = in.nextInt();
            if (num < 0 || num > 1000) {
                System.out.println(-1);
                return;
            }
            treeSet.add(num);
        }
        int n = in.nextInt();
        if (n > treeSet.size() / 2) {
            // 有重叠
            System.out.println(-1);
            return;
        }
        int sum = 0, count = 0;
        while (!treeSet.isEmpty() && count != n) {
            count++;
            sum += treeSet.pollFirst();
        }
        count = 0;
        while (!treeSet.isEmpty() && count != n) {
            count++;
            sum += treeSet.pollLast();
        }
        System.out.println(sum);
    }
}
