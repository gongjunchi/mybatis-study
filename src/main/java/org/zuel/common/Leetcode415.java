package org.zuel.common;

public class Leetcode415 {

    public String addStrings(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int i = len1 - 1, j = len2 - 1;
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        while (i >= 0 || j >= 0) {
            // 取i、j位对应的数字，如果没数字置为0
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int temp = n1 + n2 + carry;
            carry = temp / 10;
            sb.append(temp % 10);
            i--;
            j--;
        }
        if (carry == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Leetcode415 leetcode415 = new Leetcode415();
        System.out.println(leetcode415.addStrings("51189", "967895"));
    }
}
