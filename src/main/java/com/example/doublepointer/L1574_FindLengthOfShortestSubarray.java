package com.example.doublepointer;

/**
 * <p>L1574:删除最短的子数组使剩余数组有序</p>
 * @author zhenwu
 * @date 2025/3/1 21:07
 */
public class L1574_FindLengthOfShortestSubarray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 10, 4, 2, 3, 5};
        System.out.println(findLengthOfShortestSubarray(arr));
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, r = n - 1;
        while (r > 0 && arr[r - 1] <= arr[r]) {
            r--;
        }
        if (r == 0) {
            // 整个数组是非递减的
            return 0;
        }
        // arr[r - 1] > arr[r], 移除[0, r - 1]
        int ans = r;
        for (int l = 0; l == 0 || arr[l - 1] <= arr[l]; l++) {
            while (r < n && arr[l] > arr[r]) {
                // r 和 l 同时增大
                r++;
            }
            // arr[l] <= arr[r], 移除[l + 1, r - 1]
            ans = Math.min(ans, r - l - 1);
        }
        return ans;
    }
}
