package com.example.binaryserach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>L911:在线选举</p>
 * @author zhenwu
 * @date 2025/4/11 21:20
 */
public class L911_TopVotedCandidate {
    public static void main(String[] args) {

    }

    static class TopVotedCandidate {
        /**
         * 记录每一次的得票最多的person
         */
        final List<Integer> tops;

        final Map<Integer, Integer> voteCnt;

        final int[] times;

        public TopVotedCandidate(int[] persons, int[] times) {
            // 初始化
            tops = new ArrayList<>();
            voteCnt = new HashMap<>();
            int top = - 1;
            voteCnt.put(top, -1);

            // 预处理
            for (int person : persons) {
                voteCnt.merge(person, 1, Integer::sum);
                if (voteCnt.get(person) >= voteCnt.get(top)) {
                    top = person;
                }
                tops.add(top);
            }
            this.times = times;
        }

        public int q(int t) {
            int n = times.length, l = 0, r = n - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (times[m] > t) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            return r <= 0 ? tops.get(0) : tops.get(r);
        }
    }
}
