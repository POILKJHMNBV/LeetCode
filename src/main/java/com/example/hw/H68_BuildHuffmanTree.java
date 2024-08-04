package com.example.hw;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <p>生成哈夫曼树</p>
 * <p>
 *     给定长度为 n 的无序的数字数组，每个数字代表二叉树的叶子节点的权值，数字数组的值均大于等于 1 。
 *     请完成一个函数，根据输入的数字数组，生成哈夫曼树，并将哈夫曼树按照中序遍历输出。
 *     为了保证输出的二叉树中序遍历结果统一，增加以下限制:
 *      1.在树节点中，左节点权值小于等于右节点权值，根节点权值为左右节点权值之和。
 *      2.当左右节点权值相同时，左子树高度高度小于等于右子树。
 *     注意: 所有用例保证有效，并能生成哈夫曼树提醒:哈夫曼树又称最优二叉树，是一种带权路径长度最短的一叉树。
 *     所谓树的带权路径长度，就是树中所有的叶结点的权值乘上其到根结点的路径长度(若根结点为 0 层，叶结点到根结点的路径长度为叶结点的层数)
 * </p>
 * @author zhenwu
 * @date 2024/7/18 21:26
 */
public class H68_BuildHuffmanTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            minHeap.add(in.nextInt());
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (minHeap.size() > 1) {
            int left = minHeap.poll();
            int right = minHeap.poll();
            int sum = left + right;
            if (stack.isEmpty()) {
                stack.push(right);
            }
            stack.push(sum);
            stack.push(left);
            minHeap.offer(sum);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
