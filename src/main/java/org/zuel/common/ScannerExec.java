package org.zuel.common;

import java.util.Scanner;

public class ScannerExec {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        int k = 2;
        //sc.nextLine();
        String B = "010";
        char[] b = B.toCharArray();
        int len = b.length;
        char[] res = new char[len * 2];
        for (int i = len; i < res.length; i++) {
            if (res[i - k] == '1') {
                res[i] = '1';
            } else  {
                res[i] = '0';
            }
        }
        StringBuffer tmp = new StringBuffer();
        for (int i = len; i < res.length; i++) {
            tmp.append(res[i]);
        }
        System.out.println(tmp.toString());
    }
}
