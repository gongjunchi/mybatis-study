package org.zuel.common;

public class Baidu {

    public static long getReverse(long num) {
        char[] chs = String.valueOf(num).toCharArray();
        StringBuffer res = new StringBuffer();
        for (int i = chs.length - 1; i >= 0 ; i--) {
            res.append(chs[i]);
        }
        return Long.parseLong(res.toString());
    }
}
