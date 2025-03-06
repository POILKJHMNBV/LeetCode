package com.example.doublepointer;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L2570:合并两个二维数组 - 求和法</p>
 * @author zhenwu
 * @date 2025/3/6 21:23
 */
public class L2570_MergeArrays {
    public static void main(String[] args) {
        int[][] nums1 = {{13,43},{52,654},{81,634},{135,661},{148,164},{171,646},{185,785},{220,205},{234,183},{279,546},
        {285,2},{287,158},{311,71},{364,480},{370,903},{450,968},{471,63},{502,679},{510,256},{546,51},
        {573,932},{579,445},{599,919},{666,836},{699,222},{705,568},{707,141},{719,978},{747,160},
        {753,818},{758,266},{806,33},{818,508},{828,412},{851,44},{906,833},{940,575},{960,105}};
        int[][] nums2 = {{159,982},{171,221},{311,610},{364,620},{471,233},{510,207},{573,909},{599,925},{707,478},{719,788},{747,178},{828,528}};
        int[][] ans = mergeArrays(nums1, nums2);
        for (int[] arr : ans) {
            System.out.println(arr[0] + " " + arr[1]);
        }
    }

    /**
     * 双指针法
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(1)
     */
    private static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> ans = new ArrayList<>();
        int m = nums1.length, n = nums2.length, i = 0, j = 0;
        while (i < m && j < n) {
            int sum = 0;
            int[] arr = new int[2];
            if (nums1[i][0] == nums2[j][0]) {
                arr[0] = nums1[i][0];
                while (i < m && j < n && nums1[i][0] == arr[0]) {
                    sum += nums1[i++][1];
                    sum += nums2[j++][1];
                }
            } else if (nums1[i][0] < nums2[j][0]) {
                arr[0] = nums1[i][0];
                sum = nums1[i++][1];
            } else {
                arr[0] = nums2[j][0];
                sum = nums2[j++][1];
            }
            arr[1] = sum;
            ans.add(arr);
        }
        while (i < m) {
            ans.add(nums1[i++]);
        }
        while (j < n) {
            ans.add(nums2[j++]);
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
