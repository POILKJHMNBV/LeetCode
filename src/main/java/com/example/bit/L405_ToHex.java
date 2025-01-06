package com.example.bit;

/**
 * <p>L405:数字转换为十六进制数</p>
 * @author zhenwu
 * @date 2025/1/6 21:43
 */
public class L405_ToHex {
    public static void main(String[] args) {
        long num = -1;

        long a = (long) (Math.pow(2, 32) - 1);
        long b = num & Integer.MAX_VALUE;
        System.out.println(Long.toBinaryString(num));
        System.out.println(Long.toBinaryString(a));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Long.toBinaryString(b));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
    }

    public String toHexPro(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int u = num & 15;
            if (u < 10) sb.append(u);
            else sb.append((char) ('a' + u - 10));
            num >>>= 4;
        }
        return sb.reverse().toString();
    }

    private static String toHex(int num) {
        if (num == 0) return "0";
        long n = num;
        if (n < 0) n = (long) (Math.pow(2, 32) + n);
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int x = (int) (n & 15);
            if (x < 10) sb.append(x);
            else sb.append((char) ('a' + x - 10));
            n >>= 4;
        }
        return sb.reverse().toString();
    }
}
