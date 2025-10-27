package com.example.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>L508:出现次数最多的子树元素和</p>
 * @author zhenwu
 * @date 2025/10/27 21:58
 */
public class L508_FindFrequentTreeSum {
    public static void main(String[] args) {

    }

    /**
     * dfs
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    private static int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, cnt> map = new HashMap<>();
        dfs(root, map);
        List<cnt> list = map.values().stream()
                .sorted((a, b) -> b.cnt - a.cnt)
                .toList();
        int max = list.get(0).cnt;
        return list.stream()
                .filter(cnt -> cnt.cnt == max)
                .mapToInt(cnt -> cnt.sum)
                .toArray();
    }

    private static int dfs(TreeNode root, Map<Integer, cnt> map) {
        if (root == null) {
            return 0;
        }
        int leftSum = dfs(root.left, map);
        int rightSum = dfs(root.right, map);
        int sum = leftSum + rightSum + root.val;
        map.put(sum, new cnt(sum, map.getOrDefault(sum, new cnt(sum, 0)).cnt + 1));
        return sum;
    }

    private record cnt(int sum, int cnt) {
    }
}
