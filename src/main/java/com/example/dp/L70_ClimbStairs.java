package com.example.dp;

/**
 * <p>L70：爬楼梯</p>
 * <p>假设你正在爬楼梯。需要 n 阶你才能到达楼顶</p>
 * <p>每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？</p>
 */
public class L70_ClimbStairs {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(climbStairs(n));
    }

    /**
     * 递推公式：F(n) = F(n - 1) + F(n - 2)
     * F(0) = 1, F(1) = 1
     */
    private static int climbStairs(int n) {
        int a = 1, b = 1;
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
