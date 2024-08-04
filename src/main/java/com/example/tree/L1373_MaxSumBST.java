package com.example.tree;

public class L1373_MaxSumBST {
    public static void main(String[] args) {

    }

    private static int maxSumBST(TreeNode root) {
        dfs(root);
        return res;
    }

    static final int MAX = Integer.MAX_VALUE;
    static int res = 0;

    private static SubTree dfs(TreeNode root) {
        if (root == null) {
            return new SubTree(true, MAX, -MAX, 0);
        }
        SubTree leftSubTree = dfs(root.left);
        SubTree rightSubTree = dfs(root.right);

        if (root.val > leftSubTree.maxValue && root.val < rightSubTree.minValue &&
                leftSubTree.isBst && rightSubTree.isBst) {
            int sum = root.val + leftSubTree.sumValue + rightSubTree.sumValue;
            res = Math.max(res, sum);
            return new SubTree(true, Math.min(leftSubTree.minValue, root.val), Math.max((rightSubTree.maxValue), root.val), sum);
        } else {
            return new SubTree(false, 0, 0, 0);
        }
    }


    static final class SubTree {

        private final boolean isBst;
        private final int minValue;
        private final int maxValue;
        private final int sumValue;

        public SubTree(boolean isBst, int minValue, int maxValue, int sumValue) {
            this.isBst = isBst;
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.sumValue = sumValue;
        }
    }
}
