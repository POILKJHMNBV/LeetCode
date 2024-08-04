package com.example.array;

public class L825_SearchPeakIndexInMountainArray {
    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{1, 0}));
    }

    private static int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return 0;
        }

        int l = 0;
        int r = len -1;
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
