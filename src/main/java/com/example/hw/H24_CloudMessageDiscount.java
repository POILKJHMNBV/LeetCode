package com.example.hw;

import com.example.dp.L322_CoinChange;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>云短信平台优惠活动</p>
 * <p>
 *     某云短信厂商，为庆祝国庆，推出充值优惠活动。
 *     现在给出客户预算，和优惠售价序列，求最多可获得的短信总条数。
 * </p>
 * <p>
 *      输入描述：
 *          第一行客户预算M，其中 0<=M<=100
 *          第二行给出售价表，P1,P2,... Pn, 其中 1 <= n <= 100
 *          Pi为充值i元获得的短信条数.
 *          1 <= Pi <= 1000,1 <= n <= 100
 * </p>
 * <p>
 *     输出描述：
*          最多获得的短信条数。
 * </p>
 * @see L322_CoinChange
 * @author zhenwu
 * @date 2024/7/8 20:06
 */
public class H24_CloudMessageDiscount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int budget = Integer.parseInt(in.nextLine());
        int[] messages = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // dp[i]表示充值i元最多获得的短信条数，则dp[i] = max(dp[i], dp[i - j] + messages[j - 1]), 其中 (i - j) >= 0 && (j - 1) < messages.length
        int[] dp = new int[budget + 1];
        for (int i = 1; i <= budget; i++) {
            // 将当前充值的金额进行拆分，依次尝试每一种情况，取其最大值
            for (int j = 1; i - j >= 0 && (j - 1) < messages.length; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + messages[j - 1]);
            }
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(dp[budget]);
    }
}
