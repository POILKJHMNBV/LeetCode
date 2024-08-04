package com.example.hw;

import java.util.Scanner;

/**
 * <p>靠谱的车</p>
 * <p>
 * 程序员小明打了一辆出租车去上班。出于职业敏感，他注意到这辆出租车的计费表有点问题，总是偏大。
 * 出租车司机解释说他不喜欢数字4，所以改装了计费表，任何数字位置遇到数字4就直接跳过，其余功能都正常。
 *      23再多一块钱就变为25；
 *      39再多一块钱变为50；
 *      399再多一块钱变为500；
 * 小明识破了司机的伎俩，准备利用自己的学识打败司机的阴谋。
 * 给出计费表的表面读数，返回实际产生的费用
 * </p>
 * <p>
 *     输入描述：只有一行，数字N，表示里程表的读数(1 <= N <= 888888888)
 * </p>
 * <p>
 *     输出描述：一个数字，表示实际产生的费用。以回车结束。
 * </p>
 * @author zhenwu
 * @date 2024/7/2 21:36
 */
public class H11_ReliableTaxi {

    final static long[] dp;
    static {
        dp = new long[10];
        dp[0] = 1;
        for (int i = 1; i < 10; i++) {
            dp[i] = (long) (Math.pow(10, i) + dp[i - 1] * 9);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long num = Long.parseLong(s);
        if (num < 10) {
            if (num < 4) {
                System.out.println(num);
            } else {
                System.out.println(num - 1);
            }
            return;
        }
        long money = num;
        int len = s.length();
        if (Math.pow(10, len - 1) == num) {
            System.out.println(num - dp[len - 2]);
            return;
        }
        long exceeded = 0;
        while (len != 0) {
            if (len == 1 && num > 4) {
                exceeded++;
                break;
            }
            int highOrderPosition = (int) (num / Math.pow(10, len - 1));
            if (highOrderPosition < 4) {
                exceeded += (dp[len - 2] * highOrderPosition);
            } else {
                exceeded += (dp[len - 2] * (highOrderPosition - 1) + Math.pow(10, len - 1));
            }
            num -= (Math.pow(10, len - 1) * highOrderPosition);
            if (num == 0) {
                break;
            }
            len--;
        }
        System.out.println(money - exceeded);
    }
}
