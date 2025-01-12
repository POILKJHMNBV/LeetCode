package com.example.recursion;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <p>L838:推多米诺</p>
 * @author zhenwu
 * @date 2025/1/12 9:26
 */
public class L838_PushDominoes {
    public static void main(String[] args) {
        String s = ".L.R...LR..L..";
        System.out.println(pushDominoes(s));
    }

    /**
     * bfs
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static String pushDominoes(String dominoes) {
        char[] cs = dominoes.toCharArray();
        int n = cs.length;
        int[] g = new int[n];
        Deque<int[]> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (cs[i] == '.') continue;
            int dire = cs[i] == 'L' ? -1 : 1;
            d.add(new int[]{i, 1, dire});
            g[i] = 1;
        }
        while (!d.isEmpty()) {
            int[] info = d.pollFirst();
            int loc = info[0], time = info[1], dire = info[2];
            int ne = loc + dire;
            if (cs[loc] == '.' || (ne < 0 || ne >= n)) continue;
            if (g[ne] == 0) { // 首次受力
                d.addLast(new int[]{ne, time + 1, dire});
                g[ne] = time + 1;
                cs[ne] = dire == -1 ? 'L' : 'R';
            } else if (g[ne] == time + 1) { // 多次受力
                cs[ne] = '.';
            }
        }
        System.out.println(Arrays.toString(g));
        return String.valueOf(cs);
    }
}
