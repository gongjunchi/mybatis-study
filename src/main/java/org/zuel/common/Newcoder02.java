package org.zuel.common;
import java.util.*;

/**
 * 2022-03-20拼多多笔试第二题
 */
public class Newcoder02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 一共T组数据
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int v = sc.nextInt();
            // 用一个2*3数组把瓜田的条件都读进来
            int[][] arr = new int[n][3];
            // 维护两个时间变量，记录所有田地总的摘瓜开始时间和结束时间
            int start = 1, end = 0;
            for (int j = 0; j < n; j++) {
                arr[j][0] = sc.nextInt(); // 产量
                arr[j][1] = sc.nextInt(); // 开始时间
                arr[j][2] = sc.nextInt(); // 结束时间
                start = Math.min(start, arr[j][1]);
                end = Math.max(end, arr[j][2]);
            }
            // 对瓜田数组按开始时间升序排列，如果开始时间一样就按结束时间
            Arrays.sort(arr, (o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return o1[2] - o2[2];
                } else {
                    return o1[1] - o2[1];
                }
            });
            int res = 0;
            // 遍历所有天数
            for (int k = start; k <= end; k++) {
                // 记录当天已经摘了多少瓜
                int temp = 0;
                for (int j = 0; j < n; j++) {
                    if (arr[j][0] > 0) {
                        int hope = Math.min(arr[j][0], v);
                        if (temp + hope > v) {
                            hope = v - temp;
                        }
                        temp += hope;
                        arr[j][0] -= hope;
                    }
                    if (temp == v) {
                        // 当天瓜已摘够
                        break;
                    }
                }
                res += temp;
            }
            System.out.println(res);
        }
    }


    //            Arrays.sort(arr, new Comparator<int[]>() {
//                @Override
//                public int compare(int[] o1, int[] o2) {
//                    if (o1[1] == o2[1]) {
//                        return o1[2] - o2[2];
//                    } else {
//                        return o1[1] - o2[1];
//                    }
//                }
//            });
}
