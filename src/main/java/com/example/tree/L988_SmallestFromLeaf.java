package com.example.tree;

/**
 * <p>L988:从叶结点开始的最小字符串</p>
 * @author zhenwu
 * @date 2025/10/18 16:00
 */
public class L988_SmallestFromLeaf {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode treeNode = new TreeNode(0);
        root.left = treeNode;
        root.right = new TreeNode(1);
        treeNode.left = new TreeNode(1);
        System.out.println(smallestFromLeaf(root));
    }

    /**
     * 先序遍历
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(n)
     */
    private static String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return res;
    }

    static String res = "";

    private static void dfs(TreeNode root, String path) {
        if (root == null) {
            return;
        }
        path = (char) (root.val + 'a') + path;
        // 到达叶子节点
        if (root.left == null && root.right == null) {
            if (res.isEmpty() || path.compareTo(res) < 0) {
                res = path;
            }
            return;
        }
        dfs(root.left, path);
        dfs(root.right, path);
    }

}
