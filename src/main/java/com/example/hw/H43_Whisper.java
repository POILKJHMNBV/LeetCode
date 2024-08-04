package com.example.hw;

import com.example.tree.L124_MaxPathSum;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>悄悄话</p>
 * <p>
 *     给定一个二叉树，每个节点上站一个人，节点数字表示父节点到该节点传递悄悄话需要花费的时间。
 *     初始时，根节点所在位置的人有一个悄悄话想要传递给其他人，求二叉树所有节点上的人都接收到悄悄话花费的时间。
 * </p>
 * <p>
 *     输入描述：
 *          给定二叉树：0 9 20 -1 -1 15 7 -1 -1 -1 -1 3 2
 *          注：-1表示空节点
 * </p>
 * <P>
 *     输出描述：返回所有节点都接收到悄悄话花费的时间
 * </P>
 * @see L124_MaxPathSum
 * @author zhenwu
 * @date 2024/7/14 9:24
 */
public class H43_Whisper {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] binaryTree = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(maxCostTime(binaryTree, 0));
    }

    /**
     * 深度优先遍历二叉树，遍历根节点到所有叶子节点的路径，取最大值
     * @param binaryTree 二叉树
     * @param index 当前节点索引
     * @return 所有节点都接收到悄悄话花费的时间
     */
    private static int maxCostTime(int[] binaryTree, int index) {
        // 从当前节点出发，所有节点都接收到悄悄话花费的时间
        int maxCostTime = 0;

        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        if (leftIndex < binaryTree.length && binaryTree[leftIndex] != -1) {
            // 左子树
            maxCostTime = Math.max(maxCostTime, maxCostTime(binaryTree, leftIndex));
        }

        if (rightIndex < binaryTree.length && binaryTree[rightIndex] != -1) {
            // 右子树
            maxCostTime = Math.max(maxCostTime, maxCostTime(binaryTree, rightIndex));
        }

        // 返回当前子树所有节点接收到悄悄话所需时间
        return maxCostTime + binaryTree[index];
    }
}