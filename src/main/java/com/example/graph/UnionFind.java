package com.example.graph;

/**
 * @author zhenwu
 * @date 2024/9/9 21:07
 */
public class UnionFind {
    private final int[] teams;

    private int count;

    public UnionFind(int n) {
        this.teams = new int[n + 1];
        this.count = n;

        // 初始时每个人各自为一个团队
        for (int i = 0; i <= n; i++) {
            this.teams[i] = i;
        }
    }

    public void union(int x, int y) {
        int parentX = teams[x];
        int parentY = teams[y];

        if (parentX == parentY) {
            return;
        }

        // 合并
        for (int i = 0; i < teams.length; i++) {
            if (teams[i] == parentY) {
                teams[i] = parentX;
            }
        }
        this.count--;
    }

    public int getCount() {
        return this.count;
    }

    public boolean inSameTeam(int x, int y) {
        return teams[x] == teams[y];
    }
}
