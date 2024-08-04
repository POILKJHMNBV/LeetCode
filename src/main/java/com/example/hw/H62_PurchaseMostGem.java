package com.example.hw;

import java.util.Scanner;

/**
 * <p>最多购买宝石数目</p>
 * <p>
 *     橱窗里有一排宝石，不同的宝石对应不同的价格，宝石的价格标记为 gems[i],0<=i<n, n = gems.length
 *     宝石可同时出售0个或多个，如果同时出售多个，则要求出售的宝石编号连续；
 *     例如客户最大购买宝石个数为m，购买的宝石编号必须为gems[i],gems[i+1]...gems[i+m-1](0<=i<n,m<=n)
 *     假设你当前拥有总面值为value的钱，请问最多能购买到多少个宝石,如无法购买宝石，则返回 0。
 * </p>
 * <p>
 *     输入描述：
 *          第一行输入n，参数类型为int，取值范围：[0,10^6]，表示橱窗中宝石的总数量。
 *          之后n行分别表示从第0个到第n-1个宝石的价格，即gems[0]到gems[n-1]的价格，类型为int，取值范围：(0,1000]
 *          之后一行输入v，类型为int，取值范围：[0,10^9]表示你拥有的钱。
 * </p>
 * <p>
 *     输出描述：输出int类型的返回值，表示最大可购买的宝石数量。
 * </p>
 * @author zhenwu
 * @date 2024/7/17 20:51
 */
public class H62_PurchaseMostGem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] gems = new int[n];
        for (int i = 0; i < n; i++) {
            gems[i] = in.nextInt();
        }
        int money = in.nextInt();
        if (n == 0 || money == 0) {
            System.out.println(0);
            return;
        }
        int maxGems = 0;
        int left = 0, right = 0, cost = 0;
        while (right < n) {
            cost += gems[right];
            if (cost > money) {
                maxGems = Math.max(right - left, maxGems);
            }
            while (cost > money) {
                cost -= gems[left];
                left++;
            }
            right++;
        }
        System.out.println(maxGems);
    }
}