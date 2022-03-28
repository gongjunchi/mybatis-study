package org.zuel.exam;

import java.util.Arrays;
import java.util.Scanner;

public class Meituan {

    public void meituan1() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chs = str.toCharArray();
        int a = 0, b = 0, c = 0;
        for (char ch : chs) {
            if (ch == 'a') {
                a++;
            } else if (ch == 'b') {
                b++;
            } else if (ch == 'c') {
                c++;
            }
        }
        int res = 0;
        if (a < 2 || c < 3 || b < 1) {
            System.out.println(res);
            return;
        } else {
            res += 1;
            b -= 1;
            a -= 2;
            c -= 3;
        }
        while (b >=1 && a >=1 && c >= 3) {
            b -= 1;
            c -= 3;
            a -= 1;
            res += 1;
        }
        System.out.println(res);
    }

    static long res = Integer.MIN_VALUE;
    public void meituan3() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        //int[] nums = new int[]{-2, -6, 15, 4, 5};
        // Main main = new Main();
        for (int i = 0; i < nums.length; i++) {
            //main.recur(nums, i, 0);
            recur(nums, i, 0);
        }
        System.out.println(res);
    }

    public static void recur(int[] nums, int index, long sum) {
        if (index == nums.length) {
            if (sum % 7 == 0) {
                res = Math.max(res, sum);
            }
            return;
        }
//        if (sum % 7 == 0) {
//            res = Math.max(res, sum);
//            //return;
//        }
        recur(nums, index + 1, sum);
        recur(nums, index + 1, sum + nums[index]);
    }

    public void meituan4() {
        long sum = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = 1;
        while (k <= n) {
            for (int i = 0; i < n; i++) {
                if (i + k > n) {
                    break;
                }
                sum += getMid(Arrays.copyOfRange(nums, i, i+k));
            }
            k += 2;
        }
        System.out.println(sum);
    }

    public static long getMid(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length >> 1;
        return nums[mid];
    }
}
