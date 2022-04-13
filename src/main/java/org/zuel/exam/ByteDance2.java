package org.zuel.exam;

import java.util.Scanner;

public class ByteDance2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();

        sc.nextLine();
        int[] points = new int[N];
        for (int i = 0; i < N; i++) {
            points[i] = sc.nextInt();
        }
        if (N < 3) {
            System.out.println(0);
            return;
        }
        int len = points.length;
        long count = 0;
//        int i = 0, j = 2;
//        while (i < len - 2) {
//            while (j < len && points[j] - points[i] <= D) {
//                j++;
//            }
//            long p = j - i - 1;
//            count += p * (p - 1) / 2;
//            i++;
//        }
        // 如果把j放在循环内会超时，因为里面可能包含很多重复计算，第一轮i=0时，j可能已经移动到很远的位置，j不需要每次再从i+2开始移动了
        int j = 2;
        for (int i = 0; i < len - 2; i++) {
            while (j < len && points[j] - points[i] <= D) {
                j++;
            }
            long p = j - i - 1;
            count += p * (p - 1) / 2;
        }
        System.out.println(count % 99997867);
    }
}
