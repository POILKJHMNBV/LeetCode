package com.example.binaryserach;

/**
 * <p>L744:寻找比目标字母大的最小字母</p>
 * @author zhenwu
 * @date 2025/4/1 22:08
 */
public class L744_NextGreatestLetter {
    public static void main(String[] args) {

    }

    /**
     * 时间：O(log n)  空间：O(1)
     */
    private static char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        if (target >= letters[length - 1]) {
            return letters[0];
        }
        int low = 0, high = length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (letters[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return letters[low];
    }
}
