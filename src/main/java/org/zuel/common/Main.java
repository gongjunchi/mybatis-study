package org.zuel.common;

import java.text.NumberFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        sc.nextLine();
        long[] nums = new long[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = sc.nextLong();
        }
        Arrays.sort(nums);
        double res = 0;
        double pValue = p * 0.01;
        if (p > 50) {
            for (int i = 0; i < n; i++) {
                res += nums[i] * (1 - pValue) + nums[i+n] * pValue;
            }
        } else {
            int i = 0;
            while (i < 2 * n) {
                res += nums[i] * (1 - pValue) + nums[i+1] * pValue;
                i += 2;
            }
        }
        if (res % 1 == 0) {
            System.out.println(res);
        } else {
            NumberFormat nf = NumberFormat.getInstance();
            nf.setGroupingUsed(false);
            System.out.print(nf.format(res * 100));
            System.out.print("%");
        }
    }
}