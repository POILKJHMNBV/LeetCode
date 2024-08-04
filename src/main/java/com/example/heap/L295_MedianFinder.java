package com.example.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * L295:数据流的中位数
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 *
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 *
 * MedianFinder() 初始化 MedianFinder 对象。
 *
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 *
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 */
public class L295_MedianFinder {

    private final PriorityQueue<Integer> maxHeap;
    private final PriorityQueue<Integer> minHeap;

    public static void main(String[] args) {

    }

    public L295_MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        int leftSize = maxHeap.size();
        if (leftSize == 0) {
            // 大根堆中没有数据，先进入大根堆
            maxHeap.offer(num);
        } else {
            // 大根堆中有数据，比较大根堆堆顶元素与num的值
            if (maxHeap.peek() > num) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        }
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        int leftSize = maxHeap.size();
        int rightSize = minHeap.size();
        if (!maxHeap.isEmpty()) {
            if (leftSize == rightSize) {
                return (maxHeap.peek() + minHeap.peek()) * 1.0 / 2;
            } else if (leftSize > rightSize){
                return 1.0 * maxHeap.peek();
            } else {
                return 1.0 * minHeap.peek();
            }
        }
        return -1;
    }
}

class MedianFinder {
    private final PriorityQueue<Integer> maxHeap;
    private final PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        int leftSize = maxHeap.size();
        int rightSize = minHeap.size();
        if (leftSize == rightSize) {
            if (minHeap.isEmpty() || num < minHeap.peek()) {
                maxHeap.offer(num);
            } else {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }
        } else {
            if (!maxHeap.isEmpty() && num > maxHeap.peek()) {
                minHeap.offer(num);
            } else {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            }
        }
    }

    public double findMedian() {
        int leftSize = maxHeap.size();
        int rightSize = minHeap.size();
        if (!maxHeap.isEmpty()) {
            if (leftSize == rightSize) {
                return (maxHeap.peek() + minHeap.peek()) * 1.0 / 2;
            } else {
                return 1.0 * maxHeap.peek();
            }
        }
        return -1;
    }
}
