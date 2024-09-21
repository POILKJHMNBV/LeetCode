package com.example.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>L1268:搜索推荐系统</p>
 * @author zhenwu
 * @date 2024/9/21 20:56
 */
public class L1268_SuggestedProducts {
    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        System.out.println(suggestedProductsPro(products, searchWord));
    }

    private static List<List<String>> suggestedProductsPro(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }
        int len = searchWord.length();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 1; i <= len; i++) {
            List<String> list = trie.startsWithStrings(searchWord.substring(0, i));
            if (list.size() > 3) {
                ans.add(list.subList(0, 3));
            } else {
                ans.add(list);
            }
        }
        return ans;
    }

    /**
     * 时间: O(m * n)     空间：O(1)
     */
    private static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        int len = searchWord.length();
        List<List<String>> ans = new ArrayList<>(len);
        for (int i = 1; i <= len; i++) {
            String prefix = searchWord.substring(0, i);
            List<String> list = new ArrayList<>();
            for (String product : products) {
                if (product.startsWith(prefix)) {
                    list.add(product);
                    if (list.size() == 3) {
                        break;
                    }
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
