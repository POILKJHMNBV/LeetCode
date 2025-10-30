package com.example.tree;

/**
 * <p>L2265:统计值等于子树平均值的节点数</p>
 * @author zhenwu
 * @date 2025/10/30 22:47
 */
public class L2265_AverageOfSubtree {
    public static void main(String[] args) {

    }

    /**
     * dfs
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    private static int averageOfSubtree(TreeNode root) {
        dfs(root);
        return cnt;
    }

    private static value dfs(TreeNode root) {
        if (root == null) {
            return new value(0, 0);
        }
        value left = dfs(root.left);
        value right = dfs(root.right);
        int sum = left.sum + right.sum + root.val;
        int count = left.count + right.count + 1;
        if (sum / count == root.val) {
            cnt++;
        }
        return new value(sum, count);
    }

    private static int cnt = 0;

    private record value(int sum, int count) {
    }
}
