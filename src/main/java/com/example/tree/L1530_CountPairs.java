package com.example.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L1530:好叶子节点对的数量</p>
 * @author zhenwu
 * @date 2025/11/4 21:20
 */
public class L1530_CountPairs {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        root.left = leftNode;
        root.right = rightNode;

        leftNode.right = new TreeNode(4);
        int distance = 3;
        System.out.println(countPairs(root, distance));
    }

    private static int countPairs(TreeNode root, int distance) {
        getDistance(root, distance);
        return ans;
    }

    private static int ans = 0;

    /**
     * 获取根节点到叶子节点的距离
     * 时间复杂度：O(n * n)
     * 空间复杂度：O(n)
     * @param root 根节点
     * @param distance 距离
     * @return 根节点到叶子节点的距离列表
     */
    private static List<Integer> getDistance(TreeNode root, int distance) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            // 叶子节点，距离为0
            res.add(0);
            return res;
        }
        List<Integer> left = getDistance(root.left, distance);
        List<Integer> right = getDistance(root.right, distance);
        for (int i = 0, m = left.size(); i < m; i++) {
            int leftDistance = left.get(i) + 1;
            if (leftDistance <= distance) {
                res.add(leftDistance);
            }
            left.set(i, leftDistance);
        }
        for (int i = 0, n = right.size(); i < n; i++) {
            int rightDistance = right.get(i) + 1;
            if (rightDistance <= distance) {
                res.add(rightDistance);
            }
            right.set(i, rightDistance);
        }
        for (int x : left) {
            for (int y : right) {
                if (x + y <= distance) {
                    ans++;
                }
            }
        }
        return res;
    }
}
