package com.example.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>L2454:下一个更大元素 IV</p>
 * @author zhenwu
 * @date 2025/5/25 21:26
 */
public class L2454_SecondGreaterElement {
    public static void main(String[] args) {

    }

    /**
     * 单调栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        List<Integer> s = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            while (!t.isEmpty() && nums[t.get(t.size() - 1)] < x) {
                ans[t.get(t.size() - 1)] = x; // t 栈顶的下下个更大元素是 x
                t.remove(t.size() - 1);
            }
            int j = s.size();
            while (j > 0 && nums[s.get(j - 1)] < x) {
                j--; // s 栈顶的下一个更大元素是 x
            }
            List<Integer> popped = s.subList(j, s.size());
            t.addAll(popped); // 把从 s 弹出的这一整段元素加到 t
            popped.clear(); // 弹出一整段元素
            s.add(i); // 当前元素（的下标）加到 s 栈顶
        }
        return ans;
    }
}
