package com.example.hw;

import java.util.*;
import java.util.function.Function;

/**
 * <p>数组去重和排序</p>
 * <p>给定一个乱序的数组，删除所有的重复元素，使得每个元素只出现一次，并且按照出现的次数从高到低进行排序，相同出现次数按照第一次出现顺序进行先后排序。</p>
 * <p>
 *     输入描述：一个数组，数组大小不超过100 数组元素值大小不超过100
 *     输出描述：去重排序后的数组
 * </p>
 * @author zhenwu
 * @date 2024/7/15 22:23
 */
public class H55_ArrayRemoveDuplicatesAndSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, NumInfo> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final int j = i;
            map.computeIfAbsent(nums[i], key -> new NumInfo(j, nums[j])).count++;
        }
        ArrayList<NumInfo> numInfos = new ArrayList<>(map.values());
        numInfos.sort((o1, o2) -> {
            int res = o2.count - o1.count;
            return res == 0 ? o1.firstIndex - o2.firstIndex : res;
        });
        for (int i = 0; i < numInfos.size() - 1; i++) {
            System.out.print(numInfos.get(i).num + ",");
        }
        System.out.print(numInfos.get(numInfos.size() - 1).num);
    }

    private static class NumInfo {
        final int firstIndex;
        final int num;
        int count;

        public NumInfo(int firstIndex, int num) {
            this.firstIndex = firstIndex;
            this.num = num;
        }
    }
}
