package com.example.bit;

/**
 * <p>L476:数字的补数</p>
 * @author zhenwu
 * @date 2025/1/4 21:00
 */
public class L476_FindComplement {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(findComplement(num));
    }


    /**
     * 时间复杂度：O(log num)
     * 空间复杂度：O(1)
     */
    private static int findComplement(int num) {
        int power = 0, res = 0;
        while (num > 0) {
            if ((num & 1) == 0) res += Math.pow(2, power);
            power++;
            num >>= 1;
        }
        return res;
    }
}
