package org.zuel.common;

public class Leetcode12 {

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num / 1000 > 0) {
            sb.append('M');
            num -= 1000;
        }
        if (num / 900 > 0) {
            sb.append("CM");
            num -= 900;
        }
        if (num / 500 > 0) {
            sb.append('D');
            num -= 500;
        }
        if (num / 400 > 0) {
            sb.append("CD");
            num -= 400;
        }
        while (num / 100 > 0) {
            sb.append('C');
            num -= 100;
        }
        if (num / 90 > 0) {
            sb.append("XC");
            num -= 90;
        }
        if (num / 50 > 0) {
            sb.append('L');
            num -= 50;
        }
        if (num / 40 > 0) {
            sb.append("XL");
            num -= 40;
        }
        while (num / 10 > 0) {
            sb.append('X');
            num -= 10;
        }
        if (num / 9 > 0) {
            sb.append("IX");
            num -= 9;
        }
        if (num / 5 > 0) {
            sb.append('V');
            num -= 5;
        }
        if (num / 4 > 0) {
            sb.append("IV");
            num -= 4;
        }
        while (num > 0) {
            sb.append('I');
            num -= 1;
        }
        return sb.toString();
    }


    /**
     * 改的更优雅
     * @param num
     * @return
     */
    public String intToRoman1(int num) {
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romas = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < 13) {
            while (num / nums[index] > 0) {
                sb.append(romas[index]);
                num -= nums[index];
            }
            index++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode12 leetcode12 = new Leetcode12();
        System.out.println(leetcode12.intToRoman1(9));
    }
}
