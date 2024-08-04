package com.example.hw;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * <p>转盘寿司</p>
 * <p>
 *     寿司店周年庆，正在举办优惠活动回馈新老用户。
 *     寿司转盘上总共有 n(1 ≤ n ≤ 500) 盘寿司， prices[i](1≤ prices[i] ≤1000) 是第 i 盘寿司的价格。
 *     如果客户选择了第 i 盘寿司， 寿司店免费赠送客户距离第 i 盘寿司最近的下一盘寿司 j ，前提是 prices[j] < prices[i]，如果没有满足条件的 i ，则不赠送寿司。
 *     每个价格的寿司都可无限供应。
 * </p>
 * <p>
 *     输入描述：输入的每一个数字代表寿司的价格，每盘寿司的价格之间使用空格分隔
 * </p>
 * <p>
 *     输出描述：输出享受优惠后的一组数据，每个值表示客户端选择第 i 盘寿司实际得到的寿司的总价格，使用空格进行分隔，例如：
 * </p>
 * @author zhenwu
 * @date 2024/7/27 15:52
 * @see H1_DailyStockPrice
 */
public class H110_RevolveSushi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] prices = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = prices.length;
        int[] gifts = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * length; i++) {
            int index = i % length;
            while (!stack.isEmpty() && prices[index] < prices[stack.peek()]) {
                // 利用单调递增栈寻找第一个比当前元素小的元素
                gifts[stack.pop()] = prices[index];
            }
            stack.push(index);
        }
        for (int i = 0; i < length; i++) {
            System.out.print(prices[i] + gifts[i] + " ");
        }
    }
}
