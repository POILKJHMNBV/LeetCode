package com.example.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <p>小朋友至少有几个</p>
 * <p>
 *     幼儿园组织活动，老师布置了一个任务：
 *     每个小朋友去了解与自己同一个小区的小朋友还有几个。
 *     我们将这些数量汇总到数组 garden 中。
 *     请根据这些小朋友给出的信息，计算小朋友至少有几个?
 * </p>
 * <p>
 *     输入描述：
 *          输入：garden[] = {2, 2, 3}
 *          说明：
 *              garden 数组长度最大为 999
 *              每个小区的小朋友数量最多 1000 人，也就是 garden[i] 的范围为 [0, 999]
 * </p>
 * <p>
 *     输出描述：根据这些小朋友给出的信息，计算小朋友至少有几个
 * </p>
 * @author zhenwu
 * @date 2024/7/21 9:44
 */
public class H75_LeastChildren {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer, Integer> counter = new HashMap<>();
        while (in.hasNext()) {
            int t = in.nextInt();
            counter.put(t, counter.getOrDefault(t, 0) + 1);
        }

        int leastChildren = 0;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            // 小区最少的个数
            int garden = (value + key) / (key + 1);

            // 小区小朋友最少的个数
            leastChildren += garden * (1 + key);
        }

        System.out.println(leastChildren);
    }
}
