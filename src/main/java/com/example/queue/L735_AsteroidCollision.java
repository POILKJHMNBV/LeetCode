package com.example.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <p>L735:小行星碰撞</p>
 * @author zhenwu
 * @date 2024/9/4 20:47
 */
public class L735_AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {8, -8};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    private static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            if (deque.isEmpty() || asteroid > 0 || asteroid * deque.peekLast() > 0) {
                deque.offerLast(asteroid);
                continue;
            }
            while (!deque.isEmpty() && (asteroid < 0 && deque.peekLast() > 0)) {
                if (Math.abs(deque.peekLast()) >= Math.abs(asteroid)) {
                    break;
                }
                deque.pollLast();
            }
            if (!deque.isEmpty() && deque.peekLast() + asteroid == 0) {
                deque.pollLast();
                continue;
            }
            if (deque.isEmpty() || asteroid * deque.peekLast() > 0) {
                deque.offerLast(asteroid);
            }
        }
        return deque.stream().mapToInt(o -> o).toArray();
    }
}
