package com.example.num;

/**
 * <p>L299:猜数字游戏</p>
 * @author zhenwu
 * @date 2024/11/20 23:10
 */
public class L299_GetHint {
    public static void main(String[] args) {

    }

    private static String getHint(String secret, String guess) {
        int n = secret.length();
        int a = 0, b = 0;
        int[] cnt1 = new int[10], cnt2 = new int[10];
        for (int i = 0; i < n; i++) {
            int c1 = secret.charAt(i) - '0', c2= guess.charAt(i) - '0';
            if (c1 == c2) {
                a++;
            } else {
                cnt1[c1]++;
                cnt2[c2]++;
            }
        }
        for (int i = 0; i < 10; i++) b += Math.min(cnt1[i], cnt2[i]);
        return a + "A" + b + "B";
    }
}
