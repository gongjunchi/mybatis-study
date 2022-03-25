package org.zuel.common;

import java.util.Arrays;

public class BM95 {

    // 错误方法：排序
    public int candy (int[] arr) {
        // write code here
        if (arr.length == 1) {
            return 1;
        }
        // 不能排序，因为不需要分数越高糖果越多，只需要任意相邻的两个小朋友满足分高糖果多即可
        int res = 0;
        // 维护一个数组记录每个小孩有几颗糖
        int[] temp = new int[arr.length];
        Arrays.fill(temp, 1);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                temp[i] = temp[i-1] + 1;
            }
        }
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i-1] > arr[i]) {
                // 如果本身就比他大，不能再变小了
                temp[i-1] = Math.max(temp[i] + 1, temp[i-1]);
            }
        }
        for (int num : temp) {
            res += num;
        }
        return res;
    }

    public static void main(String[] args) {
        BM95 bm95 = new BM95();
        System.out.println(bm95.candy(new int[]{5, 4, 3, 2, 1}));
    }
}
