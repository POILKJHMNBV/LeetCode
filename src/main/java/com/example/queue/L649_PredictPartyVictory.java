package com.example.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>L649:Dota2 参议院</p>
 * @author zhenwu
 * @date 2024/9/5 21:07
 */
public class L649_PredictPartyVictory {
    public static void main(String[] args) {

    }

    private static String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if ('R' == senate.charAt(i)) {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int firstRadiantIndex = radiant.poll();
            int firstDireIndex = dire.poll();
            if (firstRadiantIndex < firstDireIndex) {
                radiant.offer(firstRadiantIndex + n);
            } else {
                dire.offer(firstDireIndex + n);
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
