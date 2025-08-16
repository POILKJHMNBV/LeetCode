package com.example.topology;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * <p>L1557:可以到达所有点的最少点数目</p>
 * @author zhenwu
 * @date 2025/8/16 15:20
 */
public class L1557_FindSmallestSetOfVertices {
    public static void main(String[] args) {

    }

    /**
     * 思路：统计入度为0的点
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> set = new HashSet<>();
        edges.forEach(edge -> set.add(edge.get(1)));
        return IntStream.range(0, n).filter(i -> !set.contains(i)).boxed().toList();
    }
}
