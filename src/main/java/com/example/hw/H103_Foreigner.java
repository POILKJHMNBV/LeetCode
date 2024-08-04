package com.example.hw;

import java.util.Scanner;

/**
 * <p>来自异国的客人</p>
 * <p>
 *     有位客人来自异国，在该国使用m进制计数。
 *     该客人有个幸运数字n(n<m)，每次购物时，其总是喜欢计算本次支付的花费(折算为异国的价格后)中存在多少幸运数字。
 *     问: 当其购买一个在我国价值k的产品时，其中包含多少幸运数字?
 * </p>
 * <p>
 *     输入描述：
 *          第一行输入为 k,n,m。其中:
 *          k 表示 该客人购买的物品价值 (以十进制计算的价格)
 *          n 表示该客人的幸运数字
 *          m 表示 该客人所在国度的采用的进制
 * </p>
 * <p>
 *     输出描述：输出幸运数字的个数，行未无空格。
 * </p>
 * @author zhenwu
 * @date 2024/7/27 9:35
 */
public class H103_Foreigner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();

        int cnt = 0;

        while (k > 0) {
            int t = k % m;
            if (t == n) {
                cnt++;
            }
            k /= m;
        }

        System.out.println(cnt);
    }
}
