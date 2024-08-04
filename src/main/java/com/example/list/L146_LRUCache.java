package com.example.list;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * <p>L146:LRU 缓存</p>
 */
public class L146_LRUCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}
class LRUCache {

    private final LinkedHashMap<Integer, Integer> cache;
    private final int capacity;

    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = this.cache.get(key);
        if (value != null) {
            makeRecently(key);
        }
        return value == null ? -1 : value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            this.cache.put(key, value);
            makeRecently(key);
            return;
        }
        if (this.cache.size() == this.capacity) {
            Iterator<Integer> iterator = this.cache.keySet().iterator();
            iterator.next();
            iterator.remove();
        }
        this.cache.put(key, value);
    }

    private void makeRecently(int key) {
        Integer value = this.cache.remove(key);
        this.cache.put(key, value);
    }
}