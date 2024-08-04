package com.example.hw;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * <p>计算三叉搜索树的高度</p>
 * <p>
 *     定义构造三叉搜索树规则如下: 每个节点都存有一个数，当插入一个新的数时，从根节点向下寻找，直到找到一个合适的空节点插入查找的规则是:
 *          1.如果数小于节点的数减去500，则将数插入节点的左子树
 *          2.如果数大于节点的数加上500，则将数插入节点的右子树
 *          3.否则，将数插入节点的中子树
 *     给你一系列数，请按以上规则，按顺序将数插入树中，构建出一棵三叉搜索树，最后输出树的高度。
 * </p>
 * <p>
 *     输入描述: 第一行为一个数N，表示有N个数，1<=N<=10000, 第二行为N个空格分隔的整数，每个数的范围为[1,10000]
 *     输出描述: 输出树的高度
 * </p>
 * @author zhenwu
 * @date 2024/7/3 21:09
 */
public class H14_CalculateThreeTreeHeight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        TreeTree treeTree = new TreeTree(nums[0]);
        for (int i = 1; i < n; i++) {
            treeTree.insert(nums[i]);
        }
        System.out.println(treeTree.height());
    }

    static class TreeNode {
        final int item;
        TreeNode left, mid, right;

        public TreeNode(int item) {
            this.item = item;
        }
    }

    static class TreeTree {

        final TreeNode root;

        public TreeTree(TreeNode root) {
            this.root = root;
        }

        public TreeTree(int item) {
            this.root = new TreeNode(item);
        }

        public void insert(int item) {
            TreeNode cur = root;
            while (true) {
                if (item < cur.item - 500) {
                    if (cur.left == null) {
                        cur.left = new TreeNode(item);
                        break;
                    }
                    cur = cur.left;
                } else if (item > cur.item + 500) {
                    if (cur.right == null) {
                        cur.right = new TreeNode(item);
                        break;
                    }
                    cur = cur.right;
                } else {
                    if (cur.mid == null) {
                        cur.mid = new TreeNode(item);
                        break;
                    }
                    cur = cur.mid;
                }
            }
        }

        public int height() {
            int height = 0;
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                for (int i = 0; i < queue.size(); i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.mid != null) {
                        queue.offer(node.mid);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                height++;
            }
            return height;
        }
    }
}
