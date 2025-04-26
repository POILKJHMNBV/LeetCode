package com.example.array;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L1128:等价多米诺骨牌对的数量</p>
 * @author zhenwu
 * @date 2025/4/26 20:34
 */
public class L1128_NumEquivDominoPairs {

    public static void main(String[] args) {
        int[][] dominoes = {{1,2},{2,1},{3,4},{5,6}};
        System.out.println(numEquivDominoPairs(dominoes));
    }

    /**
     * 时间：O(n)
     * 空间：O(n)
     */
    private static int numEquivDominoPairs(int[][] dominoes) {
        Map<Pair, Integer> map = new HashMap<>();
        int ans = 0;
        for (int[] domino : dominoes) {
            Pair key = new Pair(Math.min(domino[0], domino[1]), Math.max(domino[0], domino[1]));
            if (map.containsKey(key)) {
                ans += map.get(key);
            }
            map.merge(key, 1, Integer::sum);
        }
        return ans;
    }

    static class Pair {
        private final int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (a != pair.a) return false;
            return b == pair.b;
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            return result;
        }
    }
}
