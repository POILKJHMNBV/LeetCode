package com.example.binaryserach;

/**
 * <p>L274:H 指数II</p>
 * @author zhenwu
 * @date 2024/11/15 20:19
 */
public class L275_HIndex {
    public static void main(String[] args) {

    }

    private static int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (citations[mid] >= n - mid) r = mid;
            else l = mid + 1;
        }
        return citations[r] >= n - r ? n - r : 0;
    }
}
