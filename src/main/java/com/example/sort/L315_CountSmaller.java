package com.example.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L315:计算右侧小于当前元素的个数</p>
 * @author zhenwu
 * @date 2024/12/6 21:48
 * @see L170_ReversePairs
 */
public class L315_CountSmaller {
    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        System.out.println(countSmaller(nums));
    }

    private static List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] indexArray = new int[n];
        for (int i = 0; i < n; ++i) {
            indexArray[i] = i;
            res.add(0);
        }
        if (n < 2) {
            return res;
        }
        process(indexArray, nums, 0, n - 1, res);
        return res;
    }

    private static void process(int[] indexArray, int[] nums, int l, int r, List<Integer> res) {
        if (l >= r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(indexArray, nums, l, mid, res);
        process(indexArray, nums,mid + 1, r, res);
        merge(indexArray, nums, l, mid, r, res);
    }

    private static void merge(int[] indexArray, int[] nums, int l, int mid, int r, List<Integer> res) {
        int[] temp = new int[r - l + 1];
        int k1 = l, k2 = mid + 1, k = 0;

        // 对索引数组进行归并
        while (k1 <= mid && k2 <= r) {
            int index1 = indexArray[k1], index2 = indexArray[k2];
            if (nums[index1] > nums[index2]) {
                int count = res.get(index1);
                res.set(index1, count + (r - k2 + 1));
                temp[k++] = index1;
                k1++;
            } else {
                temp[k++] = index2;
                k2++;
            }
        }

        while (k1 <= mid) {
            temp[k++] = indexArray[k1];
            k1++;
        }
        while (k2 <= r) {
            temp[k++] = indexArray[k2];
            k2++;
        }
        System.arraycopy(temp, 0, indexArray, l, r + 1 - l);
    }
}
