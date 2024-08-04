package com.example.hw;

import java.util.*;

/**
 * @author zhenwu
 * 2024/6/18 21:57
 */
public class N89_24Game {
    static Map<String, Integer> map;
    static Map<Integer, String> pokerMap;
    static Map<Character, Integer> priorityMap;
    static {
        map = new HashMap<>();
        map.put("A", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("10", 10);
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);

        pokerMap = new HashMap<>();
        pokerMap.put(1, "A");
        pokerMap.put(2, "2");
        pokerMap.put(3, "3");
        pokerMap.put(4, "4");
        pokerMap.put(5, "5");
        pokerMap.put(6, "6");
        pokerMap.put(7, "7");
        pokerMap.put(8, "8");
        pokerMap.put(9, "9");
        pokerMap.put(10, "10");
        pokerMap.put(11, "J");
        pokerMap.put(12, "Q");
        pokerMap.put(13, "K");

        priorityMap = new HashMap<>();
        priorityMap.put('-', 1);
        priorityMap.put('+', 1);
        priorityMap.put('*', 2);
        priorityMap.put('/', 2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String[] strs = in.nextLine().split(" ");
            if (isInvalidStr(strs)) {
                System.out.println("ERROR");
            } else {
                calculate24Game(strs);
                if (res != null) {
                    for (int i = 0; i < res.size(); i++) {
                        String s = res.get(i);
                        if (i % 2 == 0) {
                            System.out.print(pokerMap.get(Integer.parseInt(s)));
                        } else {
                            System.out.print(s);
                        }
                    }
                } else {
                    System.out.println("NONE");
                }
            }
        }
    }


    static List<String> res = null;
    private static void calculate24Game(String[] strs) {
        int len = strs.length;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = map.get(strs[i]);
        }
        boolean[] used = new boolean[len];
        dfs(nums, used, new ArrayList<>());
    }

    private static void dfs(int[] nums, boolean[] used, List<Integer> path) {
        if (res != null) {
            return;
        }
        if (path.size() == nums.length) {
            int len = nums.length;
            int[] numArr = new int[len];
            for (int i = 0; i < len; i++) {
                numArr[i] = path.get(i);
            }
            process(numArr, 0, new ArrayList<>());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            dfs(nums, used, path);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    static char[] operateArray = {'+', '-', '*', '/'};
    private static void process(int[] nums, int startIndex, List<String> express) {
        if (res != null) {
            return;
        }
        express.add(nums[startIndex] + "");
        if (startIndex == 3) {
            if (calculateExpress(express)) {
                res = new ArrayList<>(express);
            }
            express.remove(express.size() - 1);
            return;
        }
        for (int i = 0; i < 4; i++) {
            express.add(operateArray[i] + "");
            process(nums, startIndex + 1, express);
            express.remove(express.size() - 1);
        }
        express.remove(express.size() - 1);
    }

    private static boolean calculateExpress(List<String> express) {
        int a = Integer.parseInt(express.get(0));
        for (int i = 1; i < express.size() - 1; i += 2) {
            a = calculate(a, Integer.parseInt(express.get(i + 1)), express.get(i).charAt(0));
        }
        return a == 24;
    }

    private static int calculate(int a, int b, char operate) {
        if (operate == '+') {
            return a + b;
        } else if (operate == '-') {
            return a - b;
        } else if (operate == '*') {
            return a * b;
        } else {
            return a / b;
        }
    }

    private static boolean isInvalidStr(String[] strs) {
        Set<String> set = map.keySet();
        for (String str : strs) {
            if (!set.contains(str)) {
                return true;
            }
        }
        return false;
    }
}
