package com.example.array;

/**
 * <p>L334:递增的三元子序列</p>
 * @author zhenwu
 * @date 2024/8/30 21:37
 */
public class L334_IncreasingTriplet {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 0, 4, 6};
        System.out.println(increasingTriplet(nums));
    }

    private static boolean increasingTriplet(int[] nums) {
        int one = Integer.MAX_VALUE, two = Integer.MAX_VALUE;
        for (int three : nums) {
            if (three > two) return true;
            else if (three <= one) one = three;
            else two = three;
        }
        return false;
    }
}
