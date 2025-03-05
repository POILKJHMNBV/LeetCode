package com.example.doublepointer;

/**
 * <p>L1089:复写零</p>
 * @author zhenwu
 * @date 2025/3/5 21:28
 */
public class L1089_DuplicateZeros {
    public static void main(String[] args) {
        int[] arr = {0, 4, 1, 0, 0, 8, 0, 0, 3};
        duplicateZerosPro(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static void duplicateZerosPro(int[] arr) {
        int n = arr.length, i = 0, j = 0;
        while (j < n) {
            if (arr[i] == 0) j++;
            i++; j++;
        }
        i--; j--;
        while (i >= 0) {
            if (j < n) arr[j] = arr[i];
            if (arr[i] == 0 && --j >= 0) arr[j] = 0;
            i--; j--;
        }
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static void duplicateZeros(int[] arr) {
        int l = 0, r = 0, n = arr.length;
        while (r < n) {
            if (arr[r] != 0) {
                l++;
                r++;
                continue;
            }
            while (r < n && arr[r] == 0) {
                r++;
            }
            if (r == n) {
                break;
            }
            int len = r - l;
            for (int i = n - 1 - len; i >= r; i--) {
                arr[i + len] = arr[i];
            }
            for (int i = r; i < Math.min(n, r + len); i++) {
                arr[i] = 0;
            }
            r += len;
            l = r;
        }
    }
}
