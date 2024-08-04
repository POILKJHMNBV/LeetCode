package com.example.hw;

import java.util.*;

/**
 * <p>跳马</p>
 * <p>
 *     马是象棋(包括中国象棋只和国际象棋）中的棋子，走法是每步直一格再斜一格，即先横着或直着走一格，然后再斜着走一个对角线，可进可退，可越过河界，俗称马走 “日“ 字。
 *     给项m行n列的棋盘(网格图)，棋盘上只有象棋中的棋子“马”，并目每个棋子有等级之分，
 *     等级为K的马可以跳1~k步(走的方式与象棋中“马”的规则一样，不可以超出棋盘位置)，
 *     问是否能将所有马跳到同一位置，如果存在，输出最少需要的总步数(每匹马的步数相加) ，不存在则输出-1。
 *     注意：允许不同的马在跳的过程中跳到同一位置，
 *     坐标为(x,y)的马跳一次可以跳到到坐标为(x+1,y+2),(x+1,y-2),(x+2,y+1),(x+2,y-1). (x-1,y+2),(x-1,y-2),(x-2,y+1),(x-2,y-1),的格点上，但是不可以超出棋盘范围。
 * </p>
 * <p>
 *     输入描述：
 *          第一行输入m,n代表m行n列的网格图棋盘(1 <= m,n <= 25);
 *          接下来输入m行n列的网格图棋盘，如果第i行,第j列的元素为 “.” 代表此格点没有棋子，如果为数字k (1<= k <=9)，代表此格点存在等级为k的“马”。
 * </p>
 * <p>
 *     输出描述：
 *          输出最少需要的总步数 (每匹马的步数相加)，不存在则输出-1。
 * </p>
 * @author zhenwu
 * @date 2024/7/27 8:34
 */
public class H101_JumpHorse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(); int n = in.nextInt();
        char[][] board = new char[m][n];
        int horses = 0;
        for (int i = 0; i < m; i++) {
            board[i] = in.next().toCharArray();
            for (char ch : board[i]) {
                if (ch != '.') {
                    horses++;
                }
            }
        }
        if (horses < 2) {
            System.out.println(0);
            return;
        }

        List<Horse> horseList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    // bfs求解每匹马到达所能到达位置的最少步数
                    horseList.add(bfs(board, i, j));
                }
            }
        }

        int minSteps = Integer.MAX_VALUE;
        Set<String> set = horseList.get(0).distanceMap.keySet();
        for (String key : set) {
            long count = horseList.stream()
                    .filter(horse -> horse.distanceMap.containsKey(key))
                    .count();
            if (count == horseList.size()) {
                // 所有马都能到达该位置，计算最少步数
                int step = horseList.stream()
                        .map(horse -> horse.distanceMap.get(key))
                        .reduce(Integer::sum)
                        .get();
                minSteps = Math.min(minSteps, step);
            }
        }
        if (minSteps == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minSteps);
        }
    }

    private static Horse bfs(char[][] board, int x, int y) {
        int k = board[x][y] - '0';
        int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
        int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};
        int step = 0;
        Horse horse = new Horse(x, y);
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            step++;
            if (step > k) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int j = 0; j < 8; j++) {
                    int newX = point[0] + dx[j];
                    int newY = point[1] + dy[j];
                    if (inArea(board, newX, newY)) {
                        // 更新最少步数
                        horse.add(newX, newY, step);
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
        return horse;
    }

    private static boolean inArea(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    private static class Horse {

        /**
         * 马的起始位置
         */
        final int x;
        final int y;

        /**
         * 马所能到达的点的最短距离
         */
        final Map<String, Integer> distanceMap;

        public Horse(int x, int y) {
            this.x = x;
            this.y = y;
            this.distanceMap = new HashMap<>();

            // 到自己位置的距离为0
            this.distanceMap.put("" + x + y, 0);
        }

        public void add(int x, int y, int step) {
            String key = "" + x + y;
            if (distanceMap.containsKey(key)) {
                int preStep = distanceMap.get(key);
                if (step < preStep) {
                    distanceMap.put(key, step);
                }
            } else {
                distanceMap.put(key, step);
            }
        }
    }
}
