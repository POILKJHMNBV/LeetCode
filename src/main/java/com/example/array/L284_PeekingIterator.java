package com.example.array;

import java.util.Iterator;

/**
 * <p>L284:窥视迭代器</p>
 * @author zhenwu
 * @date 2024/11/15 20:28
 */
public class L284_PeekingIterator {
    public static void main(String[] args) {

    }

    static class PeekingIterator implements Iterator<Integer> {

        private final Iterator<Integer> iterator;

        // 记录下一个元素，peek()方法会用到它
        private Integer next;

        public PeekingIterator(Iterator<Integer> iterator) {
            this.iterator = iterator;
            if (iterator.hasNext()) {
                next = iterator.next();
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer temp = next;
            if (iterator.hasNext()) {
                next = iterator.next();
            } else {
                next = null;
            }
            return temp;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }
    }
}
