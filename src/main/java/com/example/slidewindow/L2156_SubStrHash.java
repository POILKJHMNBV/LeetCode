package com.example.slidewindow;

/**
 * <p>L2156:查找给定哈希值的子串</p>
 * @author zhenwu
 * @date 2025/2/8 20:39
 */
public class L2156_SubStrHash {

    public static void main(String[] args) {
        String s = "xmmhdakfursinye";
        int power = 96, modulo = 45, k = 15, hashValue = 21;
        System.out.println(9223372036854775807L);
        System.out.println(Long.MAX_VALUE);
        System.out.println((24 * 31 * 31) % 32);
        System.out.println(subStrHash(s, power, modulo, k, hashValue));
    }

    /**
     * 滑动窗口
     * 溢出
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long sum = 0;
        int n = s.length(), ex = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < k; i++) {
            sum += (chars[i] - 'a' + 1) * Math.pow(power, ex++);
        }
        if (sum % modulo == hashValue) {
            return s.substring(0, k);
        }
        for (int i = k; i < n; i++) {
            sum -= (chars[i - k] - 'a' + 1);
            sum /= power;
            sum += (chars[i] - 'a' + 1) * Math.pow(power, k - 1);
            if (sum % modulo == hashValue) {
                return s.substring(i + 1 - k, i + 1);
            }
        }
        return null;
    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static String subStrHashPro(String s, int power, int modulo, int k, int hashValue) {
        char[] chars = s.toCharArray();
        int n = s.length();
        // 用秦九韶算法计算 s[n-k:] 的哈希值，同时计算 pk=power^k
        long hash = 0;
        long pk = 1;
        for (int i = n - 1; i >= n - k; i--) {
            hash = (hash * power + (chars[i] & 31)) % modulo;
            pk = pk * power % modulo;
        }
        int ans = hash == hashValue ? n - k : 0;
        // 向左滑窗
        for (int i = n - k - 1; i >= 0; i--) {
            // 计算新的哈希值，注意 +mod 防止计算出负数
            hash = (hash * power + (chars[i] & 31) - pk * (chars[i + k] & 31) % modulo + modulo) % modulo;
            if (hash == hashValue) {
                ans = i;
            }
        }
        return s.substring(ans, ans + k);
    }
}
