package com.example.hw;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author zhenwu
 * 10
 * 2000 1999 1998 1997 1996 1995 1994 1993 1992 1991
 * 10 10 10 10 10 10 10 10 10 10
 */
public class N41_ScaleWeight {
    public static void main(String[] args) {
        System.out.println(1652510 / 1000000);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] weight = new int[n];
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            weight[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Set<Long> weightSet = new HashSet<>();
        weightSet.add(0L);
        for (int i = 0; i < n; i++) {
            int w = weight[i];
            Set<Long> tempSet = new HashSet<>(weightSet);
            for (int j = 0; j <= nums[i]; j++) {
                for (Long num : tempSet) {
                    weightSet.add(num + (long) w * j);
                }
            }
        }
        System.out.println(weightSet.size());
        /*for (int num = 0; num <= nums[0]; num++) {
            process(1, weight, nums, weightSet, num * weight[0]);
        }*/
    }

    private static void process(int index,
                                int[] weight,
                                int[] nums,
                                Set<Long> weightSet,
                                long totalWeigth) {
        if (index == weight.length) {
            weightSet.add(totalWeigth);
            return;
        }
        for (int num = 0; num <= nums[index]; num++) {
            process(index + 1, weight, nums, weightSet, totalWeigth + num * weight[index]);
        }
    }
}
