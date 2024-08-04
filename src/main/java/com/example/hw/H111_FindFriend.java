package com.example.hw;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * <p>找朋友</p>
 * <p>
 *     在学校中，N个小朋友站成一队，第i个小朋友的身高为height[i] 第i个小朋友可以看到的第一个比自己身高更高的小朋友j，那么是i的好朋友(要求j>i)
 *     请重新生成一个列表，对应位置的输出是每个小朋友的好朋友位置，如果没有看到好朋友，请在该位置用0代替。 小朋友人数范围是[0,40000]。
 * </p>
 * <p>
 *     输入描述：
 *          第一行输入N，N表示有N个小朋友
 *          第二行输入N个小朋友的身高height[i]，都是整数
 * </p>
 * <p>
 *     输出描述：输出N个小朋友的好朋友的位置
 * </p>
 * @author zhenwu
 * @date 2024/7/27 16:13
 * @see H110_RevolveSushi
 */
public class H111_FindFriend {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = in.nextInt();
        }
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                // 利用单调递减栈寻找第一个比当前元素大的元素
                res[stack.poll()] = i;
            }
            stack.push(i);
        }
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
