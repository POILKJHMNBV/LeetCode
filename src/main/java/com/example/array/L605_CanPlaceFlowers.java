package com.example.array;

/**
 * <p>L605:种花问题</p>
 * @author zhenwu
 * @date 2024/8/29 21:50
 */
public class L605_CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 0,1};
        int n = 2;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    private static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0, pre = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (pre == 0 && (i + 1 == flowerbed.length || flowerbed[i + 1] == 0)) {
                if (flowerbed[i] == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
            pre = flowerbed[i];
        }
        return count >= n;
    }
}
