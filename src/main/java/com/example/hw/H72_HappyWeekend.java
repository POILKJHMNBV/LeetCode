package com.example.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>欢乐的周末</p>
 * <p>
 *     小华和小为是很要好的朋友，他们约定周末一起吃饭。
 *     通过手机交流，他们在地图上选择了多个聚餐地点(由于自然地形等原因，部分聚餐地点不可达)。
 *     求小华和小为都能到达的聚餐地点有多少个?
 * </p>
 * <p>
 *     输入描述：
 *          第一行输入m和n，m代表地图的长度，n代表地图的宽度
 *          第二行开始具体输入地图信息，地图信息包含:
 *          0 为通畅的道路
 *          1 为障碍物 (且仅1为障碍物)
 *          2 为小华或者小为，地图中必定有且仅有2个(非障碍物)
 *          3 为被选中的聚餐地点 (非障碍物)
 * </p>
 * <p>
 *     输出描述：可以被两方都到达的聚餐地点数量，行末无空格
 * </p>
 * @author zhenwu
 * @date 2024/7/20 10:04
 */
public class H72_HappyWeekend {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();
        int[][] map = new int[m][n];
        int[][] visited = new int[m][n];

        // 小华和小为的位置
        List<int[]> starts = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = in.nextInt();
                if (map[i][j] == 2) {
                    starts.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < starts.size(); i++) {
            int[] start = starts.get(i);
            dfs(map, start[0], start[1], visited, i);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 3 && visited[i][j] == 3) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int[][] map, int i, int j, int[][] visited, int order) {
        if (!inArea(map, i, j) || map[i][j] == 1 || ((visited[i][j] >> order) & 1) == 1) {
            return;
        }
        visited[i][j] |= (1 << order);
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int k = 0; k < 4; k++) {
            dfs(map, i + dx[k], j + dy[k], visited, order);
        }
    }

    private static boolean inArea(int[][] map, int i, int j) {
        return i >= 0 && i < map.length && j >= 0 && j < map[0].length;
    }
}
