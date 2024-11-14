package com.example.queue;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import static com.example.num.L263_IsUgly.isUgly;

/**
 * <p>L264:丑数 II</p>
 * <p>
 *  给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * </p>
 * @author zhenwu
 * @date 2024/11/13 21:31
 */
public class L264_NthUglyNumber {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumberPro(n));
    }

    /**
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(1)
     * 超时
     */
    private static int nthUglyNumber(int n) {
        for (int i = 1; ; i++) {
           if (isUgly(i)) {
               n--;
               if (n == 0) {
                   return i;
               }
           }
        }
    }

    /**
     * 动态规划
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int nthUglyNumberDp(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int n2 = res[a] * 2, n3 = res[b] * 3, n5 = res[c] * 5;
            res[i] = Math.min(Math.min(n2, n3), n5);
            if (res[i] == n2) {
                a++;
            }
            if (res[i] == n3) {
                b++;
            }
            if (res[i] == n5) {
                c++;
            }
        }
        return res[n - 1];
    }

    /**
     * 优先级队列
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(n)
     */
    private static int nthUglyNumberPro(int n) {
        int[] nums = {2, 3, 5};
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.offer(1L);
        set.add(1L);

        for (int i = 0; i < n - 1; i++) {
            long poll = queue.poll();
            for (int j : nums) {
                long temp = poll * j;
                if (!set.contains(temp)) {
                    queue.offer(temp);
                    set.add(temp);
                }
            }
        }
        return Math.toIntExact(queue.peek());
    }
}
