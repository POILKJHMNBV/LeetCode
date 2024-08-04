package com.example.hw;

/**
 * @author zhenwu
 * 1 + 0.5 + 0.5
 */
public class N38_BallLanding {
    public static void main(String[] args) {
        float count = 0;
        float begin = 1;
        System.out.println(1 + 0.5 + 0.5 + 0.25 + 0.25 + 0.125 + 0.125 + 0.0625 + 0.0625);
        for (int i = 0; i < 4; i++) {
            count += (begin + begin / 2);
            begin /= 2;
        }
        System.out.println(count + begin);
        System.out.println(begin / 2);
    }
}
