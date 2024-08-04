package com.example.hw;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * @author zhenwu
 */
public class N19_SimpleErrorRecord {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LRU lru = new LRU(8);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.isEmpty()) {
                break;
            }
            String[] strings = line.split(" ");
            String path = strings[0];
            int lastIndex = path.lastIndexOf('\\');
            String key;
            if (path.length() - (lastIndex + 1) > 16) {
                key = path.substring(path.length() - 16) + " " + strings[1];
            } else {
                key = path.substring(lastIndex + 1) + " " + strings[1];
            }
            lru.put(key);
        }
        lru.print();
    }
}

class LRU {

    private final int capacity;

    private final LinkedHashMap<String, Counter> cache;

    private final HashSet<String> appearSet;

    public LRU(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(this.capacity);
        this.appearSet = new HashSet<>();
    }

    public void put(String key) {
        if (this.appearSet.contains(key)) {
            return;
        }
        if (this.cache.containsKey(key)) {
            this.cache.get(key).addCount();
            return;
        }
        if (this.cache.size() == this.capacity) {
            this.appearSet.add(this.removeFist());
        }
        this.cache.put(key, new Counter());
    }

    public void print() {
        this.cache.forEach((k, v) -> System.out.println(k + " " + v.getCount()));
    }

    private String removeFist() {
        Iterator<String> iterator = this.cache.keySet().iterator();
        String key = iterator.next();
        iterator.remove();
        return key;
    }
}

class Counter {
    private int count;

    public Counter() {
        this.count = 1;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        this.count++;
    }
}
