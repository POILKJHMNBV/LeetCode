package com.example.hash;

import java.util.*;

/**
 * <p>L710:黑名单中的随机数</p>
 * @author zhenwu
 * @date 2024/12/29 20:52
 */
public class L710_RandomNumInBlackList {
    public static void main(String[] args) {
        int n = 10;
        int[] blacklist = {3, 2, 5};
        Solution solution = new Solution(n, blacklist);
        System.out.println(solution);
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " + solution.pick());
        }
    }

    static class Solution {
        private final Map<Integer, Integer> blackToWhite;
        private final int bound;
        private final Random random;

        /**
         * 时间复杂度：初始化 O(B)，其中 B 是黑名单的长度。每次调用 pick 方法的时间复杂度为 O(1)。
         * 空间复杂度：O(B)，其中 B 是黑名单的长度。
         */
        public Solution(int n, int[] blacklist) {
            this.bound = n - blacklist.length;
            this.random = new Random();
            Set<Integer> blacks = new HashSet<>();
            for (int b : blacklist) {
                if (b >= bound) {
                    blacks.add(b);
                }
            }
            this.blackToWhite = new HashMap<>();
            int w = bound;
            for (int b : blacklist) {
                if (b < bound) {
                    while (blacks.contains(w)) {
                        ++w;
                    }
                    blackToWhite.put(b, w++);
                }
            }
        }

        public int pick() {
            int num = random.nextInt(bound);
            return blackToWhite.getOrDefault(num, num);
        }

        @Override
        public String toString() {
            return "Solution{" +
                    "blackToWhite=" + blackToWhite +
                    ", bound=" + bound +
                    '}';
        }
    }
}
