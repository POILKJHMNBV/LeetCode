package com.example.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>L3310:移除可疑的方法</p>
 * @author zhenwu
 * @date 2025/7/31 22:11
 */
public class L3310_RemainingMethods {
    public static void main(String[] args) {

    }

    private static List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] invocation : invocations) {
            graph.computeIfAbsent(invocation[0], key -> new ArrayList<>()).add(invocation[1]);
        }
        boolean[] isSuspicious = new boolean[n];
        dfs(k, graph, isSuspicious);
        List<Integer> ans = new ArrayList<>();
        for (int[] invocation : invocations) {
            if (!isSuspicious[invocation[0]] && isSuspicious[invocation[1]]) {
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!isSuspicious[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    private static void dfs(int cur, Map<Integer, List<Integer>> graph, boolean[] isSuspicious) {
        isSuspicious[cur] = true;
        for (int next : graph.getOrDefault(cur, new ArrayList<>())) {
            if (!isSuspicious[next]) {
                dfs(next, graph, isSuspicious);
            }
        }
    }
}
