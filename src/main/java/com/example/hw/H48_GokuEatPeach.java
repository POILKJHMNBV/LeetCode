package com.example.hw;

import com.example.binaryserach.L875_MinEatingSpeed;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>孙悟空吃蟠桃</p>
 * <p>
 *     孙悟空爱吃蟠桃，有一天趁着蟠桃园守卫不在来偷吃。已知蟠桃园有 N 棵蟠桃树，每棵树上都桃子，守卫将在 H 小时后回来。
 *     孙悟空可以决定他吃蟠桃的速度 K （个/每小时），每个小时选一棵桃树，并从树上吃掉 K 个，如果K大于该树上所有桃子个数，则全部吃掉，并且这一小时剩余的时间里不再吃桃。
 *     孙悟空喜欢慢慢吃，但又想在守卫回来前吃完桃子。
 *     请返回孙悟空可以在 H 小时内吃掉所有桃子的最小速度 K （K 为整数）。如果以任何速度都吃不完所有桃子，则返回 0。
 * </p>
 * <p>
 *     输入描述：
 *          第一行输入为 N个数字， N 表示桃树的数量，这 N 个数字表示每棵桃树上蟠桃的数量
 *          第二行输入为一个数字，表示守卫离开的时间 H。
 *          其中数字通过空格分割， N、 H 为正整数，每棵树上都有蟠桃，且 0<N<10000, 0 < H < 10000。
 * </p>
 * <p>
 *     输入描述：
 *          输出吃掉所有蟠桃的最小速度 K，无解或输入异常时输出 0。
 * </p>
 * @see L875_MinEatingSpeed
 * @author zhenwu
 * @date 2024/7/14 16:51
 */
public class H48_GokuEatPeach {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] peaches = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int hour = in.nextInt();

        if (peaches.length > hour) {
            System.out.println(0);
            return;
        }

        int l = 1, r = Arrays.stream(peaches).max().getAsInt();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (calCostTime(mid, peaches) > hour) {
                // 时间不够，加快速度
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        System.out.println(l);
    }

    private static int calCostTime(int speed, int[] peaches) {
        int costTime= 0;
        for (int peach : peaches) {
            costTime += Math.ceil(peach * 1.0 / speed);
        }
        return costTime;
    }
}
