package com.example.hw;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * <p>CPU算力分配</p>
 * <p>
 *     现有两组服务器A和B，每组有多个算力不同的CPU，其中 A 是A组第个CPU的运算能力，是 B组 第个CPU的运算能力。
 *     一组服务器的总算力是各CPU的算力之和。 为了让两组服务器的算力相等，允许从每组各选出一个CPU进行一次交换。
 *     求两组服务器中，用于交换的CPU的算力，并且要求从A组服务器中选出的CPU，算力尽可能小
 * </p>
 * <p>
 *     输入描述:
 *          第一行输入为L1和L2，以空格分隔，L1表示A组服务器中的CPU数量，L2表示B组服务器中的CPU数量
 *          第二行输入为A组服务器中各个CPU的算力值，以空格分隔.
 *          第三行输入为B组服务器中各个CPU的算力值，以空格分隔 1 ≤ L1, L2 ≤ 10000 1 ≤ A[i], B[i] ≤ 100000
 *     输出描述:
 *          对于每组测试数据，输出两个整数，以空格分隔，依次表示A组选出的CPU算力，B组选出的CPU算力。要求从A组选出的CPU的算力尽可能小。
 *          备注:保证两组服务器的初始总算力不同，答案肯定存在。
 * </p>
 * @author zhenwu
 * @date 2024/7/4 19:52
 */
public class H15_CpuAssign {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt(); int n2 = in.nextInt();
        int[] numsA = new int[n1];
        int[] numsB = new int[n2];
        for (int i = 0; i < n1; i++) {
            numsA[i] = in.nextInt();
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n2; i++) {
            int num = in.nextInt();
            numsB[i] = num;
            set.add(num);
        }
        Arrays.sort(numsA);
        int sumA = IntStream.of(numsA).sum();
        int sumB = IntStream.of(numsB).sum();

        int d = (sumA - sumB) / 2;
        for (int num : numsA) {
            int target = num - d;
            if (set.contains(target)) {
                System.out.println(num + " " + target);
                return;
            }
        }
    }
}
