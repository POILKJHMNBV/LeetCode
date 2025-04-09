package com.example.binaryserach;

import java.util.*;

/**
 * <p>L3508:设计路由器</p>
 * @author zhenwu
 * @date 2025/4/9 22:19
 */
public class L3508_Router {
    public static void main(String[] args) {

    }

    static class Router {

        static class Packet {
            final int source;
            final int destination;
            final int  timestamp;

            public Packet(int source, int destination, int timestamp) {
                this.source = source;
                this.destination = destination;
                this.timestamp = timestamp;
            }
        }

        static class Pair {
            final List<Integer> timestamps;
            final int head;

            public Pair(List<Integer> timestamps, int head) {
                this.timestamps = timestamps;
                this.head = head;
            }
        }

        private final int memoryLimit;
        private final Queue<Packet> packetQ = new ArrayDeque<>(); // Packet 队列
        private final Set<Packet> packetSet = new HashSet<>(); // Packet 集合
        private final Map<Integer, Pair> destToTimestamps = new HashMap<>(); // destination -> [[timestamp], head]

        public Router(int memoryLimit) {
            this.memoryLimit = memoryLimit;
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            Packet packet = new Packet(source, destination, timestamp);
            if (!packetSet.add(packet)) {
                return false;
            }
            if (packetQ.size() == memoryLimit) { // 太多了
                forwardPacket();
            }
            packetQ.add(packet); // 入队
            destToTimestamps.computeIfAbsent(destination, k -> new Pair(new ArrayList<>(), 0)).timestamps.add(timestamp);
            return true;
        }

        public int[] forwardPacket() {
            if (packetQ.isEmpty()) {
                return new int[]{};
            }
            Packet packet = packetQ.poll(); // 出队
            packetSet.remove(packet);
            destToTimestamps.compute(packet.destination, (k, p) -> new Pair(p.timestamps, p.head + 1)); // 队首下标加一，模拟出队
            return new int[]{packet.source, packet.destination, packet.timestamp};
        }

        public int getCount(int destination, int startTime, int endTime) {
            Pair p = destToTimestamps.get(destination);
            if (p == null) {
                return 0;
            }
            int left = lowerBound(p.timestamps, startTime, p.head - 1);
            int right = lowerBound(p.timestamps, endTime + 1, p.head - 1);
            return right - left;
        }

        private int lowerBound(List<Integer> nums, int target, int left) {
            int right = nums.size();
            while (left + 1 < right) {
                int mid = (left + right) >>> 1;
                if (nums.get(mid) >= target) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return right;
        }
    }
}
