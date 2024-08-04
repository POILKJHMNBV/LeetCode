package com.example.hw;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * <p>每日股票价格</p>
 * <p>给定某只股票连续N天的价格列表stockPrices，其中stockPricesi表示股票某天的价格，请生成一个新列表，对应位置输出为:要想等到股票价格上涨，至少需要等待的天数，如果股票价格不上涨，对应位置输出为0。</p>
 * <p>
 *  第一行 表示第二行元素的个数N
 *  第二行为用空格隔开的整数，表示每天股票的价格
 *  其中0<N<=1000000每天股票价格为正整数
 * </p>
 * <p>
 *  输出为用空格分隔的长度为N的列表，对应位置为:要想等到股票价格上涨至少需要等待的天数
 * </p>
 * @author zhenwu
 * @date 2024/6/26 21:00
 */
public class H1_DailyStockPrice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] stockPrice = new int[n];
            for (int i = 0; i < n; i++) {
                stockPrice[i] = in.nextInt();
            }
            calAndPrintStockUpDay(stockPrice);
        }
    }

    /**
     * 单调栈解决(利用单调栈存储索引)
     */
    private static void calAndPrintStockUpDay(int[] stockPrice) {
        int length = stockPrice.length;
        int[] res = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && stockPrice[i] > stockPrice[stack.peek()]) {
                // 利用单调递减栈寻找第一个比当前元素大的元素
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
