package com.example.matrix;

import java.util.*;

/**
 * <p>L2146:价格范围内最高排名的 K 样物品</p>
 * @author zhenwu
 * @date 2025/6/13 21:51
 */
public class L2146_HighestRankedKItems {
    public static void main(String[] args) {
        int[][] grid = {{0, 2, 0}};
        int[] pricing = {2, 2};
        int[] start = {0, 1};
        int k = 3;
        System.out.println(highestRankedKItems(grid, pricing, start, k));
    }

    /**
     * BFS
     * 时间复杂度: O(n * n)
     * 空间复杂度: O(n * n)
     */
    private static List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int minPrice = pricing[0], maxPrice = pricing[1];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start[0], start[1]});
        int rank = 0;
        List<Point> points = new ArrayList<>();
        if (grid[start[0]][start[1]] >= minPrice && grid[start[0]][start[1]] <= maxPrice) {
            points.add(new Point(start[0], start[1], grid[start[0]][start[1]], 0));
        }
        grid[start[0]][start[1]] = -1;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            rank++;
            for (int i = 0, size = queue.size(); i < size; i++) {
                int[] point = queue.poll();
                for (int[] direction : directions) {
                    int x = point[0] + direction[0], y = point[1] + direction[1];
                    if (notInArea(grid, x, y) || grid[x][y] == -1 || grid[x][y] == 0) {
                        continue;
                    }
                    if (grid[x][y] != 1 && grid[x][y] >= minPrice && grid[x][y] <= maxPrice) {
                        points.add(new Point(x, y, grid[x][y], rank));
                    }
                    grid[x][y] = -1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        points.sort(Comparator.comparingInt((Point a) -> a.rank).thenComparingInt(a -> a.price).thenComparingInt(a -> a.x).thenComparingInt(a -> a.y));
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < Math.min(k, points.size()); i++) {
            Point point = points.get(i);
            ans.add(Arrays.asList(point.x, point.y));
        }
        return ans;
    }

    private static boolean notInArea(int[][] grid, int i, int j) {
        return i < 0 || i >= grid.length || j < 0 || j >= grid[0].length;
    }

    static class Point {
        final int x;
        final int y;
        final int price;
        final int rank;
        public Point(int x, int y, int price, int rank) {
            this.x = x;
            this.y = y;
            this.price = price;
            this.rank = rank;
        }
    }
}
