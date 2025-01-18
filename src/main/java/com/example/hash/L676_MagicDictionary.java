package com.example.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>L676:实现一个魔法字典</p>
 * @author zhenwu
 * @date 2025/1/18 9:06
 */
public class L676_MagicDictionary {
    public static void main(String[] args) {

    }

    static class MagicDictionary {

        private final Map<Integer, List<String>> lenMap;

        public MagicDictionary() {
            lenMap = new HashMap<>();
        }

        public void buildDict(String[] dictionary) {
            for (String s : dictionary) {
                lenMap.computeIfAbsent(s.length(), k -> new ArrayList<>()).add(s);
            }
        }

        public boolean search(String searchWord) {
            int len = searchWord.length();
            if (!lenMap.containsKey(len)) {
                return false;
            }
            for (String s : lenMap.get(len)) {
                int diff = 0;
                for (int i = 0; i < len; ++i) {
                    if (s.charAt(i) != searchWord.charAt(i)) {
                        ++diff;
                        if (diff > 1) {
                            break;
                        }
                    }
                }
                if (diff == 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
