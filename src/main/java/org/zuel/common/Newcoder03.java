package org.zuel.common;

import java.util.Scanner;

public class Newcoder03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String b = sc.nextLine();
        char[] a = new char[b.length()];
        for (int i = 0; i < b.length(); i++) {
            a[i] = '0';
        }
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '1') {
                if (i+k < b.length()) {
                    a[i+k] = '1';
                } else if (i >= k) {
                    a[i-k] = '1';
                }
            }
        }
    }
}
