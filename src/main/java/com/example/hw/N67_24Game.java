package com.example.hw;

import java.util.*;

/**
 * @author zhenwu
 */
public class N67_24Game {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        priorityMap.put('-', 1);
        priorityMap.put('+', 1);
        priorityMap.put('*', 2);
        priorityMap.put('/', 2);
        dfs(nums, 0, new ArrayList<>());
        System.out.println(res);
    }

    static char[] operateArray = {'+', '-', '*', '/'};

    static boolean res = false;
    
    static Map<Character, Integer> priorityMap = new HashMap<>();

    private static void dfs(int[] nums, int statIndex, List<String> express) {
        express.add(nums[statIndex] + "");
        if (statIndex == 3) {
            System.out.println(express);
            if (calculateExpress(express)) {
                res = true;
            }
            express.remove(express.size() - 1);
            return;
        }
        for (int i = 0; i < 4; i++) {
            express.add(operateArray[i] + "");
            dfs(nums, statIndex + 1, express);
            express.remove(express.size() - 1);
        }
        express.remove(express.size() - 1);
    }

    private static boolean calculateExpress(List<String> express) {
        ArrayDeque<Integer> numStack = new ArrayDeque<>();
        ArrayDeque<Character> opStack = new ArrayDeque<>();
        for (String s : express) {
            if (!priorityMap.containsKey(s.charAt(0))) {
                numStack.push(Integer.parseInt(s));
            } else {
                while (!opStack.isEmpty()) {
                    char peekOp = opStack.peek();
                    if (priorityMap.get(peekOp) >= priorityMap.get(s.charAt(0))) {
                        calculate(numStack, opStack);
                    } else {
                        break;
                    }
                }
                opStack.push(s.charAt(0));
            }
        }
        while (!opStack.isEmpty()) {
            calculate(numStack, opStack);
        }
        System.out.println(numStack.peek());
        return !numStack.isEmpty() && numStack.peek() == 24;
    }

    private static void calculate(Deque<Integer> numStack, Deque<Character> operateStack) {
        if (numStack.size() < 2 || operateStack.isEmpty()) {
            return;
        }
        int b = numStack.poll();
        int a = numStack.poll();
        char operate = operateStack.poll();
        if (operate == '+') {
            numStack.push(a + b);
        } else if (operate == '-') {
            numStack.push(a - b);
        } else if (operate == '*') {
            numStack.push(a * b);
        } else {
            numStack.push(a / b);
        }
    }
}
