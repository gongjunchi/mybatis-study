package org.zuel.common;

import java.util.Arrays;
import java.util.Scanner;

public class Newcoder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 字符串长度
        int N = sc.nextInt();
        sc.nextLine();
        char[] X = sc.nextLine().toCharArray();
        char[] Y = sc.nextLine().toCharArray();
        Arrays.sort(X);
        Arrays.sort(Y);
        int res = 0;
        for (int i = 0; i < X.length; i++) {
            res += Math.abs(X[i] - Y[i]);
        }
        System.out.println(res);
    }
}
