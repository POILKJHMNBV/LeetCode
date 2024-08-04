package com.example.hw;

import java.util.*;

/**
 * <p>不开心的小朋友</p>
 * <p>
 *     游乐场里增加了一批摇摇车，非常受小朋友欢迎，
 *     但是每辆摇摇车同时只能有一个小朋友使用如果没有空余的摇摇车，需要排队等候，或者直接离开，
 *     最后没有玩上的小朋友会非常不开心。请根据今天小朋友的来去情况，统计不开心的小朋友数量。
 *      1.摇摇车数量为N，范围是: 1<=N<=10:
 *      2.每个小朋友都对应一个编码，编码是不重复的数字，今天小朋友的来去情况可以使用编码表示为: 1 1 2 3 2 3。 (若小朋友离去之前有空闲的摇摇车则代表玩要后离开:不考虑小朋友多次玩的情况)。小朋友数量<=100
 *      3.题目保证所有输入数据无异常目范围满足上述说明
 * </p>
 * <p>
 *     输入描述：
 *          1.第一行: 摇摇车数量
 *          2.第二行:小朋友来去情况
 * </p>
 * <p>
 *     输出描述：
 *          返回不开心的小朋友数量
 * </p>
 * @author zhenwu
 * @date 2024/7/9 20:50
 */
public class H28_UnhappyChildren {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cars = Integer.parseInt(in.nextLine());
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> waitSet = new HashSet<>();
        Set<Integer> happySet = new HashSet<>();
        int unHappyChildren = 0;
        for (int num : nums) {
            if (happySet.contains(num)) {
                // 小朋友离开
                happySet.remove(num);
            } else {
                if (happySet.size() != cars) {
                    // 摇摇车有剩余
                    if (waitSet.contains(num)) {
                        // 玩完后离开
                        waitSet.remove(num);
                    } else {
                        happySet.add(num);
                    }
                } else {
                    // 摇摇车没有剩余
                    if (waitSet.contains(num)) {
                        // 没有等到摇摇车，离开
                        waitSet.remove(num);
                        unHappyChildren++;
                    } else {
                        waitSet.add(num);
                    }
                }
            }
        }
        System.out.println(unHappyChildren);
    }
}
