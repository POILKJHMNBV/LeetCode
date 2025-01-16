package com.example.hash;

import java.util.*;

/**
 * <p>L726:原子的数量</p>
 * @author zhenwu
 * @date 2025/1/15 22:10
 */
public class L726_CountOfAtoms {
    public static void main(String[] args) {
       String formula = "K4(ON(SO3)2)2";
       System.out.println(countOfAtomsPro(formula));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static String countOfAtomsPro(String formula) {
        LinkedList<Map<String, Integer>> cntList = new LinkedList<>();
        cntList.add(new HashMap<>());
        LinkedList<String> atomList = new LinkedList<>();
        int n = formula.length();
        char[] charArray = formula.toCharArray();
        for (int i = 0; i < n; i++) {
            char ch = charArray[i];
            if (ch == '(') {
                atomList.add(ch + "");
                cntList.add(new HashMap<>());
            } else if (Character.isUpperCase(ch)) {
                String key = buildKey(charArray, i);
                i += key.length();
                String value = "1";
                if (i < n && isDigit(charArray[i])) {
                    value = buildValue(charArray, i);
                    i += value.length() - 1;
                }
                if ("1".equals(value)) {
                    i--;
                }

                atomList.add(key);

                Map<String, Integer> cnt = cntList.getLast();
                cnt.put(key, cnt.getOrDefault(key, 0) + Integer.parseInt(value));
            } else {
                // ch == ')'
                String value = "1";
                if (i + 1 < n && isDigit(charArray[i + 1])) {
                    value = buildValue(charArray, i + 1);
                }
                int j = atomList.size() - 1;
                Map<String, Integer> cnt = cntList.removeLast();
                Set<String> set = new HashSet<>();
                int num = Integer.parseInt(value);
                while (j >= 0 && !"(".equals(atomList.get(j))) {
                    String key = atomList.get(j);
                    if (set.add(key)) {
                        cnt.put(key, cnt.getOrDefault(key, 1) * num);
                    }
                    j--;
                }
                atomList.remove(j);

                if (!cntList.isEmpty()) {
                    Map<String, Integer> lastCnt = cntList.getLast();
                    cnt.forEach((k, v) -> lastCnt.put(k, lastCnt.getOrDefault(k, 0) + v));
                }

                if (!"1".equals(value)) {
                    i += value.length();
                }
            }
        }

        Map<String, Integer> totalCntMap = new TreeMap<>();
        for (Map<String, Integer> cnt : cntList) {
            cnt.forEach((k, v) -> totalCntMap.put(k, totalCntMap.getOrDefault(k, 0) + v));
        }
        StringBuilder ans = new StringBuilder();
        totalCntMap.forEach((k, v) -> {
            ans.append(k);
            if (v != 1) {
                ans.append(v);
            }
        });
        return ans.toString();
    }

    private static String buildValue(char[] charArray, int idx) {
        int n = charArray.length;
        StringBuilder valueBuilder = new StringBuilder();
        while (idx < n && isDigit(charArray[idx])) {
            valueBuilder.append(charArray[idx++]);
        }
        return valueBuilder.toString();
    }

    private static String buildKey(char[] charArray, int idx) {
        int n = charArray.length;
        StringBuilder keyBuilder = new StringBuilder(charArray[idx] + "");
        while (++idx < n && isLower(charArray[idx])) {
            keyBuilder.append(charArray[idx]);
        }
        return keyBuilder.toString();
    }

    private static boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    private static boolean isLower(char c) {
        return 'a' <= c && c <= 'z';
    }

    private static int parseNum(String s, int i) {
        if (i == s.length() || !isDigit(s.charAt(i))) {
            return 1;
        }
        int v = 0;
        while (i < s.length() && isDigit(s.charAt(i))) {
            v = v * 10 + (s.charAt(i) - '0');
            i++;
        }
        return v;
    }

    private static String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int i = 0, n = formula.length();

        while (i < n) {
            char c = formula.charAt(i);
            if (c == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (c == ')') {
                Map<String, Integer> top = stack.pop();
                i++;
                int multiplicity = parseNum(formula, i);
                i += String.valueOf(multiplicity).length();
                for (Map.Entry<String, Integer> entry : top.entrySet()) {
                    String name = entry.getKey();
                    int count = entry.getValue();
                    stack.peek().put(name, stack.peek().getOrDefault(name, 0) + count * multiplicity);
                }
            } else if (Character.isUpperCase(c)) {
                int start = i++;
                while (i < n && isLower(formula.charAt(i))) {
                    i++;
                }
                String name = formula.substring(start, i);
                int count = parseNum(formula, i);
                i += String.valueOf(count).length();
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + count);
            } else {
                throw new IllegalArgumentException("Invalid character in formula: " + c);
            }
        }

        Map<String, Integer> mp = stack.pop();
        List<String> keys = new ArrayList<>(mp.keySet());
        Collections.sort(keys);

        StringBuilder ans = new StringBuilder();
        for (String key : keys) {
            ans.append(key);
            int count = mp.get(key);
            if (count > 1) {
                ans.append(count);
            }
        }

        return ans.toString();
    }
}
