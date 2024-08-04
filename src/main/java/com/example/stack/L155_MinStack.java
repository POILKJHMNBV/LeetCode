package com.example.stack;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * <p>L155:最小栈</p>
 * <p>
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 *      MinStack() 初始化堆栈对象。
 *      void push(int val) 将元素val推入堆栈。
 *      void pop() 删除堆栈顶部的元素。
 *      int top() 获取堆栈顶部的元素。
 *      int getMin() 获取堆栈中的最小元素。
 * </p>
 */
public class L155_MinStack {
    public static void main(String[] args) {

    }

    static class MinStack {
        Stack<Integer> xStack;
        Stack<Integer> minStack;
        public MinStack() {
            xStack = new Stack<>();
            minStack = new Stack<>();
            minStack.push(Integer.MAX_VALUE);
        }
        public void push(int val) {
            xStack.push(val);
            minStack.push(Math.min(val, minStack.peek()));
        }
        public void pop() {
            xStack.pop();
            minStack.pop();
        }
        public int top() {
            return xStack.peek();
        }
        public int getMin() {
            return minStack.peek();
        }
    }
}
class MinStack {

    private final ArrayDeque<Integer> stack;
    private final PriorityQueue<Integer> minHeap;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minHeap = new PriorityQueue<>();
    }

    public void push(int val) {
        stack.push(val);
        minHeap.offer(val);
    }

    public void pop() {
        minHeap.remove(stack.pop());
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minHeap.peek();
    }
}