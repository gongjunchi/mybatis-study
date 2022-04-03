package org.zuel.common;

import java.util.Scanner;

public class Jingshanyun {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char x = sc.next().charAt(0);
        int v = sc.nextInt();
        int t = sc.nextInt();
        if (x == 'a') {
            int res = t - v - 3;
            // 最多，2最多
            if (res % 2 == 0) {
                int b = res / 2;
                System.out.print(v + b);
            } else {
                int b = (res - 3) / 2;
                System.out.print(v + b + 1);
            }
            // 输出空格
            System.out.print(' ');
            // 最少，3最多
            if (res % 3 == 0) {
                int c = res / 3;
                System.out.print(v + c);
            } else if (res % 3 == 1) {
                int c = res / 3;
                c--;
                int b = (res - c*3) / 2;
                System.out.print(v + c + b);
            } else if (res % 3 == 2) {
                int c = (res-2) / 3;
                System.out.print(v + 1 + c);
            }
        } else if (x == 'b') {
            int res = t - v*2 - 3;
            System.out.print(v + res);
            System.out.print(' ');
            //System.out.print(v + findMin(res, 1, 3));
        } else if (x == 'c') {
            int res = t - v*3 - 3;
            System.out.print(v + res);
            System.out.print(' ');
            //System.out.print(v + findMin(res, 1, 2));
        }
    }
}
