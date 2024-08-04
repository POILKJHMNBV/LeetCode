package com.example.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * L297:二叉树的序列化与反序列化
 */
public class L297_Codec {
    public static void main(String[] args) {

    }

    // Encodes a tree to a single string.
    private static String serialize(TreeNode root) {
        if (root == null) {
            return "X";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode == null) {
                sb.append("X,");
            } else {
                sb.append(treeNode.val).append(",");
                queue.offer(treeNode.left);
                queue.offer(treeNode.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    private static TreeNode deserialize(String data) {
        if ("X".equals(data)) {
            return null;
        }
        List<String> list = Arrays.asList(data.split(","));
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        int cursor = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();

            String left = list.get(cursor);
            String right = list.get(cursor + 1);

            if (!"X".equals(left)) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(left));
                treeNode.left = leftNode;
                queue.offer(leftNode);
            }

            if (!"X".equals(right)) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(right));
                treeNode.right = rightNode;
                queue.offer(rightNode);
            }

            cursor += 2;
        }
        return root;
    }
}
