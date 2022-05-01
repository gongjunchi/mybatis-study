package org.zuel.common;

public class Leetcode925 {

    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (i < name.length()) {
            // name还没比完，typed已经没有元素了，则返回false
            if (j > typed.length() - 1) {
                return false;
            }
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (i > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        // name已经遍历完了，如果typed还没遍历完，必须跟name最后一个字符相同，否则就不对
        while (j < typed.length()) {
            if (typed.charAt(j) != typed.charAt(j - 1)) {
                return false;
            }
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode925 leetcode925 = new Leetcode925();
        System.out.println(leetcode925.isLongPressedName("vtkgn", "vttkgnn"));
    }
}
