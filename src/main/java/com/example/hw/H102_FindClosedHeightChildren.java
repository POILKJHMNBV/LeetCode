package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>寻找身高最相近的小朋友</p>
 * <p>
 *     小明今年升学到小学一年级，来到新班级后发现其他小朋友们身高参差不齐，然后就想基于各小朋友和自己的身高差对他们进行排序，请帮他实现排序。
 * </p>
 * <p>
 *     输入描述：
 *          第一行为正整数H和N，0<H<200，为小明的身高，0<N<50，为新班级其他小朋友个数。
 *          第二行为N个正整数H1-HN，分别是其他小朋友的身高，取值范围0<Hi<200 (1<= i <=N)，且N个正整数各不相同。
 * </p>
 * <p>
 *     输出描述：
 *          输出排序结果，各正整数以空格分割。
 *          和小明身高差绝对值最小的小朋友排在前面，和小明身高差绝对值最大的小朋友排在最后，如果两个小朋友和小明身高差一样，则个子较小的小朋友排在前面。
 * </p>
 * @author zhenwu
 * @date 2024/7/27 9:26
 */
public class H102_FindClosedHeightChildren {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int targetHeight = in.nextInt();
        int n = in.nextInt();
        Integer[] heights = new Integer[n];
        for (int i = 0; i < n; i++) {
            heights[i] = in.nextInt();
        }

        Arrays.sort(heights, (a, b) -> {
            int res = Math.abs(targetHeight - a) - Math.abs(targetHeight - b);
            return res == 0 ? (a - b) : res;
        });
        for (Integer height : heights) {
            System.out.print(height + " ");
        }
    }
}
