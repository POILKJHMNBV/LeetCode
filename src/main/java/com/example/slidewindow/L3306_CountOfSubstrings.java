package com.example.slidewindow;

/**
 * <p>L3306:元音辅音字符串计数 II</p>
 * @author zhenwu
 * @date 2025/2/22 10:22
 */
public class L3306_CountOfSubstrings {
    public static void main(String[] args) {
        String word = "ieaouqqieaouqq";
        int k = 1;
        System.out.println(countOfSubstrings(word, k));
    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static long countOfSubstrings(String word, int k) {
        char[] chars = word.toCharArray();
        int[] cnt1 = new int[26], cnt2 = new int[26];
        long ans = 0;
        int n = word.length(), consonantCnt1 = 0, consonantCnt2 = 0;
        for (int l1 = 0, l2 = 0, r = 0; r < n; r++) {
            char ch = chars[r];
            if (isVowel(ch)) {
                cnt1[ch - 'a']++;
                cnt2[ch - 'a']++;
            } else {
                consonantCnt1++;
                consonantCnt2++;
            }
            while (l1 <= r && check(cnt1) && consonantCnt1 > k) {
                ch = chars[l1++];
                if (isVowel(ch)) {
                    cnt1[ch - 'a']--;
                } else {
                    consonantCnt1--;
                }
            }

            while (l2 <= r && check(cnt2) && consonantCnt2 >= k) {
                ch = chars[l2++];
                if (isVowel(ch)) {
                    cnt2[ch - 'a']--;
                } else {
                    consonantCnt2--;
                }
            }

            ans += l2 - l1;
        }
        return ans;
    }

    private static boolean check(int[] cnt) {
        int a = 0, e = 'e' - 'a', i = 'i' - 'a', o = 'o' - 'a', u = 'u' - 'a';
        return cnt[a] > 0 && cnt[e] > 0 && cnt[i] > 0 && cnt[o] > 0 && cnt[u] > 0;
    }

    private static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
