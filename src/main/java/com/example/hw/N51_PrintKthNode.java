package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhenwu
 */
public class N51_PrintKthNode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(in.nextLine());
        SingleList singleList = new SingleList(nums[0]);
        for (int i = 1; i < n; i++) {
            singleList.add(nums[i]);
        }
        System.out.println(singleList.delIndex(n - k));
    }
}
