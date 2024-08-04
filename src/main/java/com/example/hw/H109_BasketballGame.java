package com.example.hw;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>篮球游戏</p>
 * <p>
 *     幼儿园里有一个放倒的圆桶，它是一个线性结构，允许在桶的右边将篮球放入，可以在桶的左边和右边将篮球取出。
 *     每个篮球有单独的编号，老师可以连续放入 一个或多个篮球，小朋友可以在桶左边或右边将篮球取出，当桶里只有一个篮球的情况下，必须从左边取出。
 *     如老师按顺序放入1、2、3、4、5 共5个编号的篮球，那么小朋友可以依次取出的编号为“1,2,3,4,5”或者“3,1,2,4,5”编号的篮球，无法取出 “5,1,3,2,4” 编号的篮球。
 *     其中“3,1,2,4,5”的取出场景为：连续放入1,2,3号；从右边取出3号；从左边取出1号；从左边取出2号；放入4号；从左边取出4号；放入5号；从左边取出5号
 *     简单起见，我们以L表示左，R表示右，此时的篮球的依次取出序列为“ RLLLL ”
 * </p>
 * <p>
 *     输入描述：
 *          第一行的数字作为老师依次放入的篮球编号；
 *          第二行的数字作为要检查是否能够按照放入顺序取出的篮球编号；
 *          其中篮球编号用逗号进行分隔。
 * </p>
 * <p>
 *     输出描述：对于每个篮球的取出序列，如果确实可以获取，请打印出其按照左右方向的操作的取出顺序，如果无法获取则打印"NO" 。
 *     补充说明：
 *          1<=篮球的编号，篮球个数<=200；篮球上的数字不重复；输出的结果中LR的必须为大写；
 * </p>
 * @author zhenwu
 * @date 2024/7/27 15:18
 */
public class H109_BasketballGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] targetNums = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        resolve1(nums, targetNums);
        resolve2(nums, targetNums);
    }

    private static void resolve1(int[] nums, int[] targetNums) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        int i = 0;
        for (int num : nums) {
            while (!deque.isEmpty()) {
                if (deque.peekFirst() == targetNums[i]) {
                    deque.poll();
                    i++;
                    res.append('L');
                } else if (deque.peekLast() == targetNums[i]) {
                    deque.removeLast();
                    res.append('R');
                    i++;
                } else {
                    break;
                }
            }
            deque.offer(num);
        }

        while (!deque.isEmpty()) {
            if (deque.peekFirst() == targetNums[i]) {
                deque.poll();
                i++;
                res.append('L');
            } else if (deque.peekLast() == targetNums[i]) {
                deque.removeLast();
                res.append('R');
                i++;
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(res);
    }

    private static void resolve2(int[] nums, int[] targetNums) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        int si = 0, ti = 0;
        while (true) {
            if (!dq.isEmpty() && dq.peekFirst() == targetNums[ti]) {
                dq.pollFirst();
                ans.append("L");
                ti++;
            } else if (!dq.isEmpty() && dq.peekLast() == targetNums[ti]) {
                dq.pollLast();
                ans.append("R");
                ti++;
            } else if (si < nums.length) {
                dq.addLast(nums[si++]);
            } else {
                break;
            }
        }

        // 当桶里还有球说明无法取出
        System.out.println(dq.isEmpty() ? ans.toString() : "NO");
    }
}
