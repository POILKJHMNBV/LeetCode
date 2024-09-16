package com.example.binaryserach;

/**
 * <p>L852:山脉数组的峰顶索引</p>
 * @author zhenwu
 * @date 2024/9/16 16:47
 */
public class L852_PeakIndexInMountainArray {
    public static void main(String[] args) {

    }

    private static int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}