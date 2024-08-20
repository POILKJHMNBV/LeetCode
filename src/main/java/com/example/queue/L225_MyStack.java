package com.example.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>L225:用队列实现栈</p>
 * @author zhenwu
 * @date 2024/8/20 20:20
 */
public class L225_MyStack {
    public static void main(String[] args) {

    }
}
class MyStack {

    private final Deque<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.offer(x);
        for (int i = 1; i < queue.size(); i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
       return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
