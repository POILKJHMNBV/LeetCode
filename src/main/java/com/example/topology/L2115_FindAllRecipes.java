package com.example.topology;

import java.util.*;

/**
 * <p>L2115:从给定原材料中找到所有可以做出的菜</p>
 * @author zhenwu
 * @date 2025/8/17 14:10
 */
public class L2115_FindAllRecipes {
    public static void main(String[] args) {
        String[] recipes = {"bread", "sandwich", "burger"};
        List<List<String>> ingredients = List.of(List.of("yeast", "flour"),
                                                List.of("bread", "meat"),
                                                List.of("sandwich","meat","bread"));
        String[] supplies = {"yeast", "flour", "meat"};
        System.out.println(findAllRecipes(recipes, ingredients, supplies));
    }

    /**
     * 拓扑排序
     * 时间复杂度：O(n), n为字符串的个数
     * 空间复杂度：O(n)
     */
    private static List<String> findAllRecipes(String[] recipes,
                                               List<List<String>> ingredients,
                                               String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Set<String> recipeSet = new HashSet<>();
        for (int i = 0, n = recipes.length; i < n; i++) {
            String recipe = recipes[i];
            recipeSet.add(recipe);
            for (String ingredient : ingredients.get(i)) {
                graph.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipe);
                inDegree.put(recipe, inDegree.getOrDefault(recipe, 0) + 1);
            }
        }

        Queue<String> queue = new LinkedList<>();
        for (String supply : supplies) {
            // 添加所有入度为0的节点
            if (!recipeSet.contains(supply)) {
                queue.offer(supply);
            }
        }

        List<String> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (String next : graph.getOrDefault(cur, new ArrayList<>())) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) {
                    ans.add(next);
                    queue.offer(next);
                    inDegree.remove(next);
                }
            }
        }
        return ans;
    }
}
