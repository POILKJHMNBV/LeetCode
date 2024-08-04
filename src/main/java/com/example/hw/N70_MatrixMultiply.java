package com.example.hw;

import java.util.*;

/**
 * @author zhenwu
 */
public class N70_MatrixMultiply {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        char[] expressArray = in.nextLine().toCharArray();
        Deque<Character> stack1 = new ArrayDeque<>();
        Deque<int[]> stack2 = new ArrayDeque<>();
        int sum = 0;
        for(char ch : expressArray) {
            if (ch != ')') {
                stack1.push(ch);
                if (ch >= 'A' && ch <= 'Z') {
                    stack2.push(list.get(ch - 'A'));
                }
            } else {
                while (!stack1.isEmpty() && stack1.peek() != '(') {
                    sum += calculate(stack1, stack2);
                }
                stack1.pop();
                stack1.push('%');
            }
        }
        System.out.println(sum);
    }

    private static int calculate(Deque<Character> stack1, Deque<int[]> stack2) {
        if (stack2.size() < 2) {
            return 0;
        }
        stack1.pop();
        stack1.pop();
        int[] matrix1 = stack2.pop();
        int[] matrix2 = stack2.pop();
        stack2.push(new int[]{matrix2[0], matrix1[1]});
        return matrix2[0] * matrix2[1] * matrix1[1];
    }
}
