package com.example.num;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L969:煎饼排序</p>
 * @author zhenwu
 * @date 2024/12/12 22:13
 */
public class L969_PancakeSort {
    public static void main(String[] args) {

    }

    /**
     * 煎饼排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    private static List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;

        // 记录每个数字在数组中的位置，方便反转
        int[] idxArr = new int[n + 10];
        for (int i = 0; i < n; i++) {
            idxArr[arr[i]] = i;
        }
        List<Integer> ans = new ArrayList<>();
        for (int num = n; num > 0; num--) {
            if (idxArr[num] == num - 1) {
                continue;
            }
            if (idxArr[num] != 0) {
                // 当前数字在数组中的位置不是0，需要反转到0位置
                ans.add(idxArr[num] + 1);
                reverse(arr, idxArr, idxArr[num]);
            }

            // 当前数字在数组中的位置是0，需要反转到num-1位置
            ans.add(num);
            reverse(arr, idxArr, num - 1);
        }
        return ans;
    }

    /**
     * 煎饼翻转
     * @param arr 数组
     * @param idxArr 数字位置数组
     * @param j 翻转到第j个
     */
    private static void reverse(int[] arr, int[] idxArr, int j) {
        int i = 0;
        while (i < j) {
            idxArr[arr[i]] = j;
            idxArr[arr[j]] = i;
            int tmp = arr[j];
            arr[j--] = arr[i];
            arr[i++] = tmp;
        }
    }
}
