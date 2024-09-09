package com.example.graph;

/**
 * <p>L547:省份数量</p>
 * @author zhenwu
 * @date 2024/9/9 21:04
 */
public class L547_FindCircleNum {
    public static void main(String[] args) {

    }

    private static int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        UnionFind unionFind = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i + 1, j + 1);
                }
            }
        }
        return unionFind.getCount();
    }
}
