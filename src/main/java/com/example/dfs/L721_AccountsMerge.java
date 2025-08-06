package com.example.dfs;

import java.util.*;

/**
 * <p>L721:账户合并</p>
 * @author zhenwu
 * @date 2025/8/6 21:55
 */
public class L721_AccountsMerge {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(L * log M), 其中 L 是 accounts 中所有字符串的长度之和，M 是 accounts 中的字符串个数
     * 空间复杂度：O(L)
     */
    private static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> emailToIdx = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> list = accounts.get(i);
            for (int j = 1; j < list.size(); j++) {
                emailToIdx.computeIfAbsent(list.get(j), key -> new ArrayList<>()).add(i);
            }
        }
        List<List<String>> res = new ArrayList<>();
        Set<String> emailSet = new HashSet<>();
        boolean[] visited = new boolean[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            if (visited[i]) {
                continue;
            }
            emailSet.clear();
            dfs(i, accounts, emailToIdx, visited, emailSet);
            List<String> list = new ArrayList<>(emailSet);
            Collections.sort(list);
            list.add(0, accounts.get(i).get(0));
            res.add(list);
        }
        return res;
    }

    private static void dfs(int idx,
                            List<List<String>> accounts,
                            Map<String, List<Integer>> emailToIdx,
                            boolean[] visited,
                            Set<String> emailSet) {
        visited[idx] = true;
        List<String> list = accounts.get(idx);
        for (int i = 1; i < list.size(); i++) {
            String email = list.get(i);
            if (!emailSet.add(email)) {
                continue;
            }
            for (Integer j : emailToIdx.getOrDefault(email, new ArrayList<>())) {
                if (!visited[j]) {
                    dfs(j, accounts, emailToIdx, visited, emailSet);
                }
            }
        }
    }
}
