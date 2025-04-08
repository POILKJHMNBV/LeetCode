package com.example.binaryserach;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>L981:基于时间的键值存储</p>
 * @author zhenwu
 * @date 2025/4/8 22:26
 * @see L1146_SnapshotArray
 */
public class L981_TimeMap {

    public static void main(String[] args) {

    }


    static class TimeMap {

        final Map<String, TreeMap<Integer, String>> treeMap;

        public TimeMap() {
            treeMap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            treeMap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            Map.Entry<Integer, String> entry = treeMap.computeIfAbsent(key, k -> new TreeMap<>()).floorEntry(timestamp);
            return entry == null ? "" : entry.getValue();
        }
    }
}
