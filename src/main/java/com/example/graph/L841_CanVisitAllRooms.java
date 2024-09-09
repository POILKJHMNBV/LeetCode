package com.example.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>L841:钥匙和房间</p>
 * @author zhenwu
 * @date 2024/9/9 20:44
 */
public class L841_CanVisitAllRooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(List.of(1, 3));
        rooms.add(List.of(1, 4));
        rooms.add(List.of(2, 3, 4, 1));
        rooms.add(List.of());
        rooms.add(List.of(4, 3, 2));
        System.out.println(canVisitAllRooms(rooms));
    }

    private static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visitedSet = new HashSet<>();
        visitedSet.add(0);
        while (visitedSet.size() != rooms.size()) {
            int initialSize = visitedSet.size();
            List<Integer> list = new ArrayList<>(visitedSet);
            for (int index : list) {
                visitedSet.addAll(rooms.get(index));
            }
            if (initialSize == visitedSet.size()) {
                break;
            }
        }
        return visitedSet.size() == rooms.size();
    }
}
