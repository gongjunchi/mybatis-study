package org.zuel.common;

import java.util.Scanner;

public class ByteDance1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder(sc.nextLine());
            if (sb.length() < 3) {
                System.out.println(sb);
                return;
            }
            for (int j = 2; j < sb.length(); j++) {
                if (sb.charAt(j) == sb.charAt(j - 1) && sb.charAt(j - 1) == sb.charAt(j - 2)) {
                    sb.deleteCharAt(j);
                    // j--一下后面再加回来表示继续从上次删除的位置做判断
                    j--;
                }
                if (j >= 3 && sb.charAt(j) == sb.charAt(j - 1) && sb.charAt(j - 2) == sb.charAt(j - 3)) {
                    sb.deleteCharAt(j);
                    j--;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
