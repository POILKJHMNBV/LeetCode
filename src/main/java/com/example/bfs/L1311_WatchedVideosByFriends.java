package com.example.bfs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>L1311:获取你好友已观看的视频</p>
 * @author zhenwu
 * @date 2025/8/10 14:10
 */
public class L1311_WatchedVideosByFriends {
    public static void main(String[] args) {
        List<List<String>> watchedVideos = List.of(List.of("A", "B"),
                List.of("C"), List.of("B", "C"), List.of("D"));
        int[][] friends = {{1, 2}, {0, 3}, {0, 3}, {1, 2}};
        int id = 0;
        int level = 2;
        System.out.println(watchedVideosByFriends(watchedVideos, friends, id, level));
    }

    /**
     * 时间复杂度：O(n + m log m)
     * 空间复杂度：O(n + m)
     */
    private static List<String> watchedVideosByFriends(List<List<String>> watchedVideos,
                                                       int[][] friends,
                                                       int id, int level) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(id);
        boolean[] visited = new boolean[friends.length];
        visited[id] = true;
        while (!queue.isEmpty() && level > 0) {
            int size = queue.size();
            level--;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int next : friends[cur]) {
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        Map<String, Pair> map = new HashMap<>();
        while (!queue.isEmpty()) {
            for (String s : watchedVideos.get(queue.poll())) {
                map.computeIfAbsent(s, key -> new Pair(s, 1)).b++;
            }
        }
        List<Pair> list = new ArrayList<>(map.values());
        return list.stream().sorted((o1, o2) -> {
            if (o1.b != o2.b) {
                return o1.b - o2.b;
            }
            return o1.a.compareTo(o2.a);
        }).map(pair -> pair.a).collect(Collectors.toList());
    }

    static class Pair {
        public Pair(String a, int frequent) {
            this.a = a;
            this.b = frequent;
        }

        String a;
        int b;
    }
}
