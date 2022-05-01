package org.zuel.common;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 天数
        int n = sc.nextInt();
        // 初始资金
        int m = sc.nextInt();
        sc.nextLine();
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }
        int cash = m, stock = 0;
        for (int i = 0; i < n - 1; i++) {
            if (cash >= price[i] && price[i] < price[i+1]) {
                cash += price[i + 1] - price[i];
            }
        }
        System.out.println(cash);
    }
}