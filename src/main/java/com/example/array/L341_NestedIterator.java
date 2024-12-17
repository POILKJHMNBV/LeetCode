package com.example.array;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;

/**
 * <p>L341:扁平化嵌套列表迭代器</p>
 * @author zhenwu
 * @date 2024/12/17 22:18
 */
public class L341_NestedIterator {
    public static void main(String[] args) {

    }

     static class NestedIterator implements Iterator<Integer> {

        private final ArrayDeque<Integer> arrayDeque;

        public NestedIterator(List<NestedInteger> nestedList) {
             this.arrayDeque = new ArrayDeque<>();
             init(nestedList);
        }

         /**
          * 初始化
          * 时间：O(n)
          * 空间：O(n)
          */
        private void init(List<NestedInteger> nestedList) {
            nestedList.forEach(nestedInteger -> {
                if (nestedInteger.isInteger()) {
                    this.arrayDeque.addLast(nestedInteger.getInteger());
                } else {
                    init(nestedInteger.getList());
                }
            });
        }

        @Override
        public Integer next() {
            return this.hasNext() ? this.arrayDeque.pollFirst() : -1;
        }

        @Override
        public boolean hasNext() {
            return !this.arrayDeque.isEmpty();
        }
    }

     interface NestedInteger {
         boolean isInteger();
         Integer getInteger();
         List<NestedInteger> getList();
     }
}
