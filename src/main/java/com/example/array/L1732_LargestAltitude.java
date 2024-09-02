package com.example.array;

/**
 * <p>L1732:找到最高海拔</p>
 * @author zhenwu
 * @date 2024/9/2 20:27
 */
public class L1732_LargestAltitude {
    public static void main(String[] args) {

    }

    private static int largestAltitude(int[] gain) {
        int maxAltitude = 0, altitude = 0;
        for (int num : gain) {
            maxAltitude = Math.max(maxAltitude, altitude += num);
        }
        return maxAltitude;
    }
}
