package com.example.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>L232:用栈实现队列</p>
 * @author zhenwu
 * @date 2024/8/20 20:06
 */
public class L232_MyQueue {
    public static void main(String[] args) {

    }
}

class MyQueue {

    private final Deque<Integer> stack1;
    private final Deque<Integer> stack2;

    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

