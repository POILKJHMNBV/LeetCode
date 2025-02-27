package com.example.doublepointer;

import java.util.Arrays;

/**
 * <p>L923:三数之和的多种可能</p>
 * @author zhenwu
 * @date 2025/2/27 23:00
 */
public class L923_ThreeSumMulti {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int target = 8;
        System.out.println(threeSumMulti(arr, target));
    }

    /**
     * 双指针
     * 时间复杂度：O(n * n)
     * 空间复杂度：O(1)
     */
    private static int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        long cnt = 0;
        int n = arr.length;
        for (int k = 0; k < n - 2; k++) {
            if (arr[k] + arr[k + 1] + arr[k + 2] > target) break;
            if (arr[k] + arr[n - 1] + arr[n - 2] < target) continue;
            int sum = target - arr[k], l = k + 1, r = n - 1;
            while (l < r) {
                int a = arr[l], b = arr[r];
                if (a + b > sum) {
                    r--;
                } else if (a + b < sum) {
                    l++;
                } else {
                    int i = l, j = r;
                    while (i <= r && arr[i] == a) {
                        i++;
                    }
                    while (j >= l && arr[j] == b) {
                        j--;
                    }
                    if (i > r && j < l) {
                        int x = i - j - 1;
                        cnt += (long) x * (x - 1) / 2;
                    } else {
                        cnt += (long) (i - l) * (r - j);
                    }
                    l = i;
                    r = j;
                }
            }
        }
        return (int) (cnt % 1000000007);
    }
}
