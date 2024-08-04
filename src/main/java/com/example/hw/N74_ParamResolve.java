package com.example.hw;

import java.util.*;

/**
 * @author zhenwu
 * l "b:\" /kzv /yar
 * u "a e i o u" r
 */
public class N74_ParamResolve {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strArr = in.nextLine().split(" ");
        List<String> res = new ArrayList<>();
        boolean flag = false;
        StringBuilder sb = null;
        for (String str : strArr) {
            if (str.charAt(0) == '"') {
                flag = true;
                sb = new StringBuilder();
                sb.append(str).append(" ");
                if (str.charAt(str.length() - 1) == '"') {
                    sb.deleteCharAt(sb.length() - 1);
                    sb.deleteCharAt(sb.length() - 1);
                    sb.deleteCharAt(0);
                    res.add(sb.toString());
                    sb = null;
                    flag = false;
                }
                continue;
            }
            if (flag) {
                sb.append(str).append(" ");
                if (str.charAt(str.length() - 1) == '"') {
                    sb.deleteCharAt(sb.length() - 1);
                    sb.deleteCharAt(sb.length() - 1);
                    sb.deleteCharAt(0);
                    res.add(sb.toString());
                    sb = null;
                    flag = false;
                }
                continue;
            }
            res.add(str);
        }

        System.out.println(res.size());
        for (String str : res) {
            System.out.println(str);
        }
    }
}