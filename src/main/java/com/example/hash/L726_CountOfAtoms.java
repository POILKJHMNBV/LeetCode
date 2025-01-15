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
       System.out.println(countOfAtoms(formula));
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
