package com.example.hw;

import java.util.*;

/**
 * <p>数字排列</p>
 * <p>
 *     小明负责公司年会，想出一个趣味游戏:
 *     屏幕给出 1−9 中任意 4 个不重复的数字,大家以最快时间给出这几个数字可拼成的数字从小到大排列位于第 n 位置的数字,其中 n 为给出数字中最大的(如果不到这么多数字则给出最后一个即可).
 *     注意：
 *          2 可以当作 5 来使用，5 也可以当作 2 来使用进行数字拼接，且屏幕不能同时给出 2 和 5；
 *          6 可以当作 9 来使用，9 也可以当作 6 来使用进行数字拼接，且屏幕不能同时给出 6 和 9。
 *     给出的数字：1, 4, 8, 7 则可以拼接的数字为： 1, 4, 7, 8, 14, 17, 18, 41, 47, 48, 71, 74, 78, 81, 84, 87, 147, 148, 178...（省略后面的数字） 因此，第 n（即8）个数字为 41
 * </p>
 * <p>
 *     输入描述：输入以逗号分隔的 4 个 int 类型整数的字符串。
 * </p>
 * <p>
 *     输出描述：输出为这几个数字可拼成的数字从小大大排列位于第 n (n为输入数字中最大的数字) 位置的数字,如果输入的数字不在范围内或者有重复，则输出 −1。
 * </p>
 * @author zhenwu
 * @date 2024/7/15 21:47
 */
public class H54_NumArrange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int max = Arrays.stream(nums).max().getAsInt();
        if (Arrays.stream(nums).min().getAsInt() < 1 || max > 9) {
            System.out.println(-1);
            return;
        }
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            set.add(num);
            minHeap.offer(num);
            if (num == 2) {
                minHeap.offer(5);
            }
            if (num == 5) {
                minHeap.offer(2);
            }
            if (num == 6) {
                minHeap.offer(9);
            }
            if (num == 9) {
                minHeap.offer(6);
            }
        }
        if (set.size() != 4) {
            System.out.println(-1);
            return;
        }

        if ((set.contains(2) && set.contains(5)) || (set.contains(6) && set.contains(9))) {
            System.out.println(-1);
            return;
        }

        // max的最大情况为9，只需求取两个数字的情况和一个数字的情况
        backtracking(minHeap, new LinkedList<>(), nums, 0);
        int count = max;
        while (!minHeap.isEmpty() && count != 1) {
            minHeap.poll();
            count--;
        }
        System.out.println(minHeap.poll());
    }

    private static void backtracking(PriorityQueue<Integer> minHeap, List<Integer> path, int[] nums, int startIndex) {
        if (path.size() == 2) {
            int a = path.get(0), b = path.get(1);
            minHeap.add(10 * a + b);
            minHeap.add(10 * b + a);
            add(minHeap, b, a);
            add(minHeap, a, b);
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(minHeap, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    private static void add(PriorityQueue<Integer> minHeap, int a, int b) {
        if (b == 2) {
            minHeap.add(10 * 5 + a);
            minHeap.add(10 * a + 5);
        }
        if (b == 5) {
            minHeap.add(10 * 2 + a);
            minHeap.add(10 * a + 2);
        }
        if (b == 6) {
            minHeap.add(10 * 9 + a);
            minHeap.add(10 * a + 9);
        }
        if (b == 9) {
            minHeap.add(10 * 6 + a);
            minHeap.add(10 * a + 6);
        }
    }
}
