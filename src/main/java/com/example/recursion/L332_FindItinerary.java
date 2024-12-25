package com.example.recursion;

import java.util.*;

/**
 * <p>L332:重新安排行程</p>
 * @author zhenwu
 * @date 2024/8/27 20:36
 */
public class L332_FindItinerary {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK","SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO","ATL"));
        tickets.add(Arrays.asList("ATL","JFK"));
        tickets.add(Arrays.asList("ATL","SFO"));
        System.out.println(findItinerary(tickets));
    }

    private static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), key -> new PriorityQueue<>()).offer(ticket.get(1));
        }
        LinkedList<String> res = new LinkedList<>();
        dfs(map, res, "JFK");
        return res;
    }

    private static void dfs(Map<String, PriorityQueue<String>> map,
                            LinkedList<String> res,
                            String src) {
        PriorityQueue<String> nbr = map.get(src);
        while (nbr != null && !nbr.isEmpty()){
            dfs(map, res, nbr.poll());
        }
        res.addFirst(src);
    }
}
