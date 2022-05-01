package org.zuel.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Gcd {

    private String name;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 组数
        int T = sc.nextInt();
        sc.nextLine();
        HashMap<String, Long> map = new HashMap<>();
        for (int i = 0; i < T; i++) {
            long N = sc.nextLong();
            int res = 0;
            long tryMax = N;
            long a = 1;
            if (N == 1) {
                System.out.println(1);
                continue;
            }
            while (a < tryMax) {
                if (N % a == 0) {
                    long b = N / a;
                    tryMax = b;
                    String fix = String.valueOf(a) + "-" +String.valueOf(b);
                    if (map.containsKey(fix)) {
                        long temp = map.get(fix);
                        if (temp == 1){
                            res++;
                        }
                    } else {
                        long temp = getGcd(a, b);
                        if (temp == 1){
                            res++;
                        }
                        map.put(fix, temp);
                    }
                }
                a++;
            }
            System.out.println(res);
        }
    }

    // 求最大公约数
    public static long getGcd(long a, long b) {
        long remain;
        if (b % a == 0) {
            return a;
        }
        remain = b % a;
        b = a;
        a = remain;
        return getGcd(a, b);
    }
}
