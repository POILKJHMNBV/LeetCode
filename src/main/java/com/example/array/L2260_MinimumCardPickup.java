package com.example.array;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L2260:必须拿起的最小连续卡牌数</p>
 * @author zhenwu
 * @date 2025/4/30 21:22
 */
public class L2260_MinimumCardPickup {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int minimumCardPickup(int[] cards) {
        int minCards = -1;
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0, n = cards.length; i < n; i++) {
            if (idxMap.containsKey(cards[i])) {
                int j = idxMap.get(cards[i]);
                minCards = minCards == -1 ? i - j + 1 : Math.min(i - j + 1, minCards);
            }
            idxMap.put(cards[i], i);
        }
        return minCards;
    }
}
