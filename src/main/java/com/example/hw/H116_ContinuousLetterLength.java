package com.example.hw;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <p>连续字母长度</p>
 * <p>
 *     给定一个字符串，只包含大写字母，求在包含同一字母的子串中，长度第 k 长的子串的长度，相同字母只取最长的那个子串。
 * </p>
 * <p>
 *     输入描述：
 *          第一行有一个字符串(1<长度≤1000001<长度≤100000)，只包含大写字母 第二行为 k 的值
 * </p>
 * <p>
 *     输出描述：输出连续出现次数第 k 多的字母的次数，当第k多的字母的次数不存在时，请输出-1
 * </p>
 * @author zhenwu
 * @date 2024/7/28 9:35
 */
public class H116_ContinuousLetterLength {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.next().toCharArray();
        int k = in.nextInt();
        int[] counter = new int[26];

        int l = 0, r = 0, len = chars.length;
        while (r < len) {
            while (r < len && chars[r] == chars[l]) {
                r++;
            }
            int index = chars[l] - 'A';
            counter[index] = Math.max(counter[index], r - l);
            l = r;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int count : counter) {
            if (count != 0) {
                maxHeap.offer(count);
            }
        }
        if (k > maxHeap.size()) {
            System.out.println(-1);
        } else {
            while (!maxHeap.isEmpty() && k != 1) {
                maxHeap.poll();
                k--;
            }
            System.out.println(maxHeap.poll());
        }
    }
}
