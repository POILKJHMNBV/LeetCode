package com.example.greedy;

import java.util.Arrays;

/**
 * <p>L135:分发糖果</p>
 * @author zhenwu
 * @date 2024/10/17 21:41
 */
public class L135_Candy {
    public static void main(String[] args) {

    }

    /**
     * 贪心算法
     * @param ratings 孩子评分数组
     * @return 最少糖果总数
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int candy(int[] ratings) {
        int[] candies = new int[ratings.length];

        // 初始化糖果数组为1，因为每个孩子至少需要一个糖果
        Arrays.fill(candies, 1);

        // 从左向右遍历，如果右边的孩子比左边的孩子大，那么右边的孩子就需要比左边的多一个糖果
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // 从右向左遍历，如果左边的孩子比右边的孩子大，那么左边的孩子就需要比右边的多一个糖果
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // 计算总和
        return Arrays.stream(candies).sum();
    }
}
