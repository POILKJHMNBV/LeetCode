package com.example.hw;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <p>整数对最小和</p>
 * <p>
 *     给定两个整数数组array1、array2，数组元素按升序排列。
 *     假设从array1、array2中分别取出一个元素可构成一对元素，现在需要取出k对元素，并对取出的所有元素求和，计算和的最小值。
 *     注意：两对元素如果对应于array1、array2中的两个下标均相同，则视为同一对元素。
 * </p>
 * <p>
 *     输入描述：
 *          输入两行数组array1、array2，每行首个数字为数组大小size(0 < size <= 100);
 *          0 <array1[i] <=1000；0 <array2[i] <= 1000
 *          接下来一行为正整数 k
 *          0 < k <= array1.size() * array2.size()
 * </p>
 * <p>
 *     输出描述：满足要求的最小和
 * </p>
 * @author zhenwu
 * @date 2024/7/15 21:25
 */
public class H53_IntegerPairMinSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len1 = in.nextInt();
        int[] nums1 = new int[len1];
        for (int i = 0; i < len1; i++) {
            nums1[i] = in.nextInt();
        }
        int len2 = in.nextInt();
        int[] nums2 = new int[len2];
        for (int i = 0; i < len2; i++) {
            nums2[i] = in.nextInt();
        }
        int k = in.nextInt();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                minHeap.offer(nums1[i] + nums2[j]);
            }
        }

        int sum = 0;
        while (!minHeap.isEmpty() && k != 0) {
            sum += minHeap.poll();
            k--;
        }
        System.out.println(sum);
    }
}
