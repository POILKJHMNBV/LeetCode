package com.example.hash;

import java.util.*;

/**
 * L49:字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */
public class L49_GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
        System.out.println(groupAnagramspro(strs));
    }

    private static List<List<String>> groupAnagramspro(String[] strs) {
        Map<MyString, List<String>> map = new HashMap<>();
        for (String str : strs) {
            MyString key = new MyString(str);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    static class MyString {

        private final Map<Character, Integer> counter;

        public MyString(String s) {
            this.counter = new HashMap<>();
            this.count(s.toCharArray());
        }

        private void count(char[] charArray) {
            for (char ch : charArray) {
                int num = this.counter.getOrDefault(ch, 0);
                num++;
                this.counter.put(ch, num);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MyString myString = (MyString) o;

            return counter != null ? counter.equals(myString.counter) : myString.counter == null;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }
}
