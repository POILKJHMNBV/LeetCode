package com.example.string;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L89:格雷编码</p>
 * @author zhenwu
 * @date 2024/10/15 21:10
 */
public class L89_GrayCode {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(grayCode(n));
    }

    /**
     * <p>n位格雷编码</p>
     * <p>
     * 设 n 阶格雷码集合为 G(n)，则 G(n+1) 阶格雷码可以通过以下三步得到：
     *  1.给 G(n) 阶格雷码每个元素二进制形式前面添加 0，得到 R(n)；
     *  2.设 G(n) 集合倒序（镜像）为 R(n)，给 R(n) 每个元素二进制形式前面添加 1，得到 S(n)；
     *  3.将 R(n) 和 S(n) 合并，即 R(n) | S(n), 得到 G(n+1) 阶格雷码。
     *  </p>
     *  <p>
     *      时间：O(2^n)   空间：O(1)
     *  </p>
     */
    private static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
            head <<= 1;
        }
        return res;
    }
}
