package com.example.hw;

import java.util.*;

/**
 * <p>启动多任务排序</p>
 * <p>
 *     一个应用启动时，会有多个初始化任务需要执行，并且任务之间有依赖关系，例如A任务依赖B任务，那么必须在B任务执行完成之后，才能开始执行A任务。
 *     现在给出多条任务依赖关系的规则，请输入任务的顺序执行序列，规则采用贪婪策略，即一个任务如果没有依赖的任务，则立刻开始执行，如果同时有多个任务要执行，则根据任务名称字母顺序排序。
 *     例如: B任务依赖A任务，C任务依赖A任务，D任务依赖B任务和C任务，同时，D任务还依赖E任务。那么执行任务的顺序由先到后是:A任务，E任务，B任务，C任务，D任务。这里A和E任务都是没有依赖的，立即执行。
 * </p>
 * <p>
 *     输入描述：
 *          输入参数每个元素都表示任意两个任务之间的依赖关系，输入参数中符号”->”表示依赖方向。
 *          例如A->B表示A依赖B，多个依赖之间用单个空格分割
 * </p>
 * <p>
 *     输出描述：
 *          输出为排序后的启动任务列表，多个任务之间用单个空格分割
 * </p>
 * @author zhenwu
 * @date 2024/7/21 10:13
 */
public class H77_MultiTaskSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] relations = in.nextLine().split(" ");

        // 入度map
        Map<String, Integer> inDegreeMap = new HashMap<>();

        // 邻接结点map
        Map<String, List<String>> adjacentMap = new HashMap<>();

        for (String relation : relations) {
            String[] strings = relation.split("->");
            String begin = strings[1], end = strings[0];
            inDegreeMap.put(begin, 0);
            inDegreeMap.put(end, inDegreeMap.getOrDefault(end, 0) + 1);
            adjacentMap.computeIfAbsent(begin, key -> new ArrayList<>()).add(end);
        }

        // 入度为0的结点队列
        Queue<String> zeroInDegreeQueue = new ArrayDeque<>();
        inDegreeMap.forEach((k, v) -> {
            if (v == 0) {
                zeroInDegreeQueue.offer(k);
            }
        });

        List<String> res = new ArrayList<>();
        // 开始进行拓扑排序
        while (!zeroInDegreeQueue.isEmpty()) {
            String curNode = zeroInDegreeQueue.poll();
            res.add(curNode);
            for (String nextNode : adjacentMap.getOrDefault(curNode, new ArrayList<>())) {
                int inDegree = inDegreeMap.get(nextNode) - 1;
                if (inDegree == 0) {
                    zeroInDegreeQueue.offer(nextNode);
                    inDegreeMap.remove(nextNode);
                } else {
                    inDegreeMap.put(nextNode, inDegree);
                }
            }
        }

        res.forEach(s -> System.out.print(s + " "));
    }
}
