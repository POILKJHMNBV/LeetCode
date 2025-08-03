package com.example.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * <p>L3387:两天自由外汇交易后的最大货币数</p>
 * @author zhenwu
 * @date 2025/8/3 10:48
 */
public class L3387_MaxAmount {
    public static void main(String[] args) {
        String initialCurrency = "EUR";
        List<List<String>> pairs1 = List.of(List.of("EUR", "USD"), List.of("USD", "JPY"));
        double[] rates1 = {2.0, 3.0};
        List<List<String>> pairs2 = List.of(List.of("JPY", "USD"), List.of("USD", "CHF"), List.of("CHF", "EUR"));
        double[] rates2 = {4.0, 5.0, 6.0};
        System.out.println(maxAmount(initialCurrency, pairs1, rates1, pairs2, rates2));
    }

    /**
     * 时间复杂度：O((n + m) * L)，其中 n 是 pairs1 的长度，m 是 pairs2 的长度，L 是单个字符串的长度(不超过3)
     * 空间复杂度：O((n + m) * L)
     * @param initialCurrency 初始货币
     * @param pairs1 表示在 第 1 天，可以按照汇率 rates1[i] 将 startCurrencyi 转换为 targetCurrencyi。
     * @param rates1 汇率
     * @param pairs2 表示在 第 2 天，可以按照汇率 rates2[i] 将 startCurrencyi 转换为 targetCurrencyi
     * @param rates2 汇率
     * @return 最大金额
     */
    private static double maxAmount(String initialCurrency,
                                    List<List<String>> pairs1,
                                    double[] rates1,
                                    List<List<String>> pairs2,
                                    double[] rates2) {
        Map<String, Double> amountMap1 = calAmounts(initialCurrency, pairs1, rates1);
        Map<String, Double> amountMap2 = calAmounts(initialCurrency, pairs2, rates2);
        double maxAmount = 0.0;
        for (Map.Entry<String, Double> entry : amountMap2.entrySet()) {
            maxAmount = Math.max(maxAmount, amountMap1.getOrDefault(entry.getKey(), 0.0) / entry.getValue());
        }
        return maxAmount;
    }

    /**
     * 计算初始货币转换为其它货币时所能得到的金额
     * @param initialCurrency 初始货币
     * @param pairs 表示在 第 1 天，可以按照汇率 rates1[i] 将 startCurrencyi 转换为 targetCurrencyi。
     * @param rates 汇率
     * @return 初始货币转换为其它货币时所能得到的金额
     */
    private static Map<String, Double> calAmounts(String initialCurrency, List<List<String>> pairs, double[] rates) {
        Map<String, List<Pair>> graph = new HashMap<>();
        for (int i = 0, size = pairs.size(); i < size; i++) {
            List<String> list = pairs.get(i);
            graph.computeIfAbsent(list.get(0), key -> new ArrayList<>()).add(new Pair(list.get(1), rates[i]));
            graph.computeIfAbsent(list.get(1), key -> new ArrayList<>()).add(new Pair(list.get(0), 1 / rates[i]));
        }
        Map<String, Double> amountMap = new HashMap<>();
        dfs(amountMap, graph, initialCurrency, 1);
        return amountMap;
    }

    /**
     * 获取所有货币的转换金额
     * @param amountMap 初始货币转换为其它货币时所能得到的金额
     * @param graph 货币转换图
     * @param curCurrency 当前货币
     * @param curAmount 当前货币的转换金额
     */
    private static void dfs(Map<String, Double> amountMap,
                            Map<String, List<Pair>> graph,
                            String curCurrency,
                            double curAmount) {
        amountMap.put(curCurrency, curAmount);
        for (Pair pair : graph.getOrDefault(curCurrency, new ArrayList<>())) {
            String to = pair.to;
            if (!amountMap.containsKey(to)) {
                dfs(amountMap, graph, to, curAmount * pair.rate);
            }
        }
    }

    private record Pair(String to, double rate) {
    }
}
