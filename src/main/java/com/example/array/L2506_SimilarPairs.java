package com.example.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>L2506:统计相似字符串对的数目</p>
 * @author zhenwu
 * @date 2025/5/2 9:39
 */
public class L2506_SimilarPairs {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int similarPairs(String[] words) {
        Map<MyString, Integer> cntMap = new HashMap<>();
        int cnt = 0;
        for (String word : words) {
            MyString key = new MyString(word);
            cnt += cntMap.getOrDefault(key, 0);
            cntMap.merge(key, 1, Integer::sum);
        }
        return cnt;
    }

    static class MyString {
        final int[] cnt;

        public MyString(String s) {
            this.cnt = new int[26];
            for (char ch : s.toCharArray()) {
                int idx = ch - 'a';
                if (cnt[idx] == 0) {
                    cnt[idx]++;
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MyString myString = (MyString) o;

            return Arrays.equals(cnt, myString.cnt);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(cnt);
        }
    }
}
