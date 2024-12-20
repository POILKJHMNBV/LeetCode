package com.example.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>L842:将数组拆分成斐波那契序列</p>
 * @author zhenwu
 * @date 2024/12/20 20:14
 */
public class L842_SplitIntoFibonacci {
    public static void main(String[] args) {
        String num = "0123";
        System.out.println(splitIntoFibonacciPro(num));
    }

    private static List<Integer> splitIntoFibonacciPro(String num) {
        LinkedList<Integer> ans = new LinkedList<>();
        // 如果字符串长度小于3，则不可能形成斐波那契序列
        if (num.length() < 3) return ans;
        backtracking(num.toCharArray(), 0, 0, 0, ans);
        return ans;
    }

    /**
     * 优化dfs
     * @param charArray 数字字符数组
     * @param startIndex 起始索引
     * @param sum 前两个数字的和
     * @param prev 前一个数
     * @param ans 符合条件的斐波那契序列
     * @return true-找到符合条件的斐波那契序列 false-没有找到符合条件的斐波那契序列
     */
    private static boolean backtracking(char[] charArray,
                                        int startIndex,
                                        int sum, int prev,
                                        LinkedList<Integer> ans) {
        int len = charArray.length;
        if (startIndex == len) {
            // 当整个字符串拆分完毕时，如果列表中至少有 3 个数，
            // 则得到一个符合要求的斐波那契式序列，返回列表。如果没有找到符合要求的斐波那契式序列，则返回空列表。
            return ans.size() >= 3;
        }

        long curNum = 0;
        for (int i = startIndex; i < len; i++) {

            if (i > startIndex && charArray[startIndex] == '0') {
                // 当前数字以0开头，退出循环
                break;
            }
            curNum = curNum * 10 + charArray[i] - '0';
            if (curNum > Integer.MAX_VALUE) {
                // 整形溢出，不符合题目条件，退出循环
                break;
            }

            if (ans.size() < 2) {
                // 数字不足2个，直接添加
                ans.add((int) curNum);
                if (backtracking(charArray, i + 1, (int) (prev + curNum), (int) curNum, ans)) {
                    // 找到符合要求的斐波那契式序列，返回结果
                    return true;
                } else {
                    // 回溯，清除列表中的数字
                    ans.removeLast();
                }
            } else {
                if (curNum > sum) {
                    // 无法形成斐波那契式序列，退出循环
                    break;
                } else if (curNum == sum) {
                    ans.add((int) curNum);
                    if (backtracking(charArray, i + 1, (int) (prev + curNum), (int) curNum, ans)) {
                        // 找到符合要求的斐波那契式序列，返回结果
                        return true;
                    } else {
                        // 回溯，清除列表中的数字
                        ans.removeLast();
                    }
                }
            }

        }
        return false;
    }

    private static List<Integer> splitIntoFibonacci(String num) {
        List<Integer> ans = new ArrayList<>();
        // 如果字符串长度小于3，则不可能形成斐波那契序列
        if (num.length() < 3) return ans;

        // 尝试所有可能的第一个和第二个数字的组合
        for (int i = 1; i <= num.length() / 2; i++) {
            for (int j = 1; j <= (num.length() - i) / 2; j++) {
                // 获取第一个数字
                String first = num.substring(0, i);

                // 获取第二个数字
                String second = num.substring(i, i + j);

                // 检查是否有前导零
                if ((first.length() > 1 && first.charAt(0) == '0')) {
                    continue;
                }
                if ((second.length() > 1 && second.charAt(0) == '0')) {
                    continue;
                }

                // 检查数字是否超出范围
                if (isNotInteger(first) || isNotInteger(second)) {
                    continue;
                }

                // 从第三个位置开始检查剩余的字符串能否形成斐波那契序列
                ans.add(Integer.parseInt(first));
                ans.add(Integer.parseInt(second));
                if (isValid(num, i + j, first, second, ans)) {
                    return ans;
                }
                // 重置ans，尝试下一个可能的组合
                ans.clear();
            }
        }
        return ans;
    }

    private static boolean isNotInteger(String num) {
        try {
            Integer.parseInt(num);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private static boolean isValid(String num, int start,
                            String first, String second,
                            List<Integer> ans) {
        if (start == num.length()) {
            return true;
        }
        String sum = L306_IsAdditiveNumber.addStrings(first, second);
        if (!num.startsWith(sum, start)) {
            return false;
        }
        if (isNotInteger(sum)) {
            return false;
        }
        ans.add(Integer.parseInt(sum));
        return isValid(num, start + sum.length(), second, sum, ans);
    }
}
