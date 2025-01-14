package com.example.hash;

import java.util.*;

/**
 * <p>L895:最大频率栈</p>
 * @author zhenwu
 * @date 2025/1/14 21:13
 */
public class L895_FreqStack {
    public static void main(String[] args) {

    }

    /**
     * <p>设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。</p>
     * <p>实现 FreqStack 类:</p>
     * 时间复杂度：O(1)
     * 空间复杂度：O(n)，其中 n 是堆栈中的元素数量。
     */
    static class FreqStack {

        private final LinkedList<Deque<Integer>> stacks;

        private final Map<Integer, Integer> freqMap;

        public FreqStack() {
            stacks = new LinkedList<>();
            freqMap = new HashMap<>();
        }

        public void push(int val) {
            int freq = freqMap.getOrDefault(val, 0);
            if (freq == stacks.size()) {
                // 如果当前频率等于堆栈的大小，则创建一个新的堆栈
                stacks.addLast(new ArrayDeque<>());
            }
            // 将元素推入对应频率的堆栈中，并更新其出现次数
            stacks.get(freq).push(val);
            freqMap.put(val, freq + 1);
        }

        public int pop() {
            // 弹出出现频率最高的元素，即堆栈最后一个非空堆栈的顶部元素
            int maxFreq = stacks.size() - 1;
            int val = stacks.get(maxFreq).pop();
            if (stacks.get(maxFreq).isEmpty()) {
                stacks.removeLast();
            }
            // 更新该元素的出现次数
            freqMap.merge(val, -1, Integer::sum);
            return val;
        }
    }
}
