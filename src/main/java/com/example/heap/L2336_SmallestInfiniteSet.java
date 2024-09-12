package com.example.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>L2336:无限集中的最小数字</p>
 * @author zhenwu
 * @date 2024/9/12 23:10
 */
public class L2336_SmallestInfiniteSet {
    public static void main(String[] args) {

    }

    static class SmallestInfiniteSet {

        public SmallestInfiniteSet() {

        }

        boolean[] vis = new boolean[1010];
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        int idx = 1;
        public int popSmallest() {
            int ans = -1;
            if (!q.isEmpty()) {
                ans = q.poll();
                vis[ans] = false;
            } else {
                ans = idx++;
            }
            return ans;
        }
        public void addBack(int x) {
            if (x >= idx || vis[x]) return ;
            if (x == idx - 1) {
                idx--;
            } else {
                q.add(x);
                vis[x] = true;
            }
        }
    }
}
