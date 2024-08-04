package com.example.hw;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <p>剩余银饰的重量</p>
 * <p>
 *     有N块二手市场收集的银饰，每块银饰的重量都是正整数，收集到的银饰会被熔化用于打造新的饰品。
 *     每一回合，从中选出三块 最重的 银饰，然后一起熔掉。
 *     假设银饰的重量分别为 x 、y和z，且 x <= y <= z。那么熔掉的可能结果如下：
 *      1.如果 x == y == z，那么三块银饰都会被完全熔掉；
 *      2.如果 x == y 且 y != z，会剩余重量为 z - y 的银块无法被熔掉；
 *      3.如果 x != y 且 y == z，会剩余重量为 y - x 的银块无法被熔掉；
 *      4.如果 x != y 且 y != z，会剩余重量为 z - y 与 y - x 差值 的银块无法被熔掉。
 *      5.最后，如果剩余两块，返回较大的重量（若两块重量相同，返回任意一块皆可）；
 *      6.如果只剩下一块，返回该块的重量；如果没有剩下，就返回 0。
 * </p>
 * <p>
 *     输入描述：
 *      1.输入数据为两行
 *      2.输入数据为两行
 *      3.第二行为n块银饰的重量，重量的取值范围为[1，2000]，重量之间使用空格隔开
 * </p>
 * <p>
 *     输出描述：
 *      1.如果剩余两块，返回较大的重量（若两块重量相同，返回任意一块皆可）；
 *      2.如果只剩下一块，返回该块的重量；如果没有剩下，就返回 0。
 * </p>
 * @author zhenwu
 * @date 2024/7/11 20:54
 */
public class H34_RemainJewelryWeight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] weights = new int[n];

        // 利用大根堆每次取出三块最重的银饰
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            weights[i] = in.nextInt();
            maxHeap.offer(weights[i]);
        }

        if (n < 3) {
            System.out.println(maxHeap.poll());
            return;
        }

        while (maxHeap.size() >= 3) {
            // 每次取出三块最重的银饰
            int z = maxHeap.poll();
            int y = maxHeap.poll();
            int x = maxHeap.poll();

            if (x == y && y != z) {
                maxHeap.offer(z - y);
            } else if ( x != y && y == z) {
                maxHeap.offer(y - x);
            } else if (x != y) {
                maxHeap.offer(Math.abs((z - y) - (y - x)));
            }
        }

        if (maxHeap.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(maxHeap.poll());
        }
    }
}
