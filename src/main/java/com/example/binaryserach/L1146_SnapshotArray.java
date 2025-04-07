package com.example.binaryserach;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>L1146:快照数组</p>
 *
 * @author zhenwu
 * @date 2025/4/7 22:27
 */
public class L1146_SnapshotArray {
    public static void main(String[] args) {

    }

    static class SnapshotArray {

        int snapId;
        final Map<Integer, TreeMap<Integer, Integer>> array;

        public SnapshotArray(int length) {
            snapId = 0;
            array = new HashMap<>(length);
        }

        public void set(int index, int val) {
            array.computeIfAbsent(index, k -> new TreeMap<>()).put(snapId, val);
        }

        public int snap() {
            return snapId++;
        }

        public int get(int index, int snap_id) {
            Map.Entry<Integer, Integer> entry = array.computeIfAbsent(index, k -> new TreeMap<>()).floorEntry(snap_id);
            return entry == null ? 0 : entry.getValue();
        }
    }
}
