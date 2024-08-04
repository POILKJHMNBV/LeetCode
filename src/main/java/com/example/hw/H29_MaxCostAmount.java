package com.example.hw;

import com.example.doublepointer.L15_ThreeNum;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>最大花费金额</p>
 * <p>
 *     双十一众多商品进行打折销售，小明想购买自己心仪的一些物品，但由于受购买资金限制，所以他决定从众多心仪商品中购买三件，而且想尽可能的花完资金现在请你设计一个程序帮助小明计算尽可能花费的最大资金数额。
 * </p>
 * <p>
 *     输入描述：
 *      第一行为一维整型数组M，数组长度Q小于100，数组元素记录单个商品的价格,单个商品价格小于1000。
 *      第二行为购买资金的额度R，R小于100000。
 * </p>
 * <p>
 *     输出描述：
 *      输出为满足上述条件的最大花费额度，如果不存在满足上述条件的商品，请返回-1。
 * </p>
 * @see L15_ThreeNum
 * @author zhenwu
 * @date 2024/7/9 21:22
 */
public class H29_MaxCostAmount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] prices = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int amount = Integer.parseInt(in.nextLine());
        Arrays.sort(prices);
        int length = prices.length;
        if (length < 3 || prices[2] >= amount) {
            // 当前金额不足以购买三件商品
            System.out.println(-1);
            return;
        }
        int maxCostAmount = 0;
        for (int i = 0; i < length; i++) {
            if (prices[i] >= amount) {
                break;
            }
            int target = amount - prices[i];
            int left = i + 1, right = length - 1;
            // 双指针求解
            while (left < right) {
                int leftValue = prices[left];
                int rightValue = prices[right];
                if (leftValue + rightValue <= target) {
                    maxCostAmount = Math.max(maxCostAmount, leftValue + rightValue + prices[i]);
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(maxCostAmount);
    }
}