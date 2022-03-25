package org.zuel.common;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class BM96 {

    public int minmumNumberOfHost (int n, int[][] startEnd) {
        // 转换长整型
        long[][] c = new long[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = startEnd[i][j];
            }
        }
        // write code here
        Arrays.sort(c, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Long.compare(o1[1], o2[1]);
            } else {
                return Long.compare(o1[0], o2[0]);
            }
        });
//        for (long[] arr : c) {
//            for (long num : arr) {
//                System.out.print(num);
//            }
//            System.out.println();
//        }
        // 把整个时间段压入队列不行，使用优先队列，压入结束时间
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(c[0][1]);
        for (int i = 1; i < n; i++) {
            if (c[i][0] >= queue.peek()) {
                queue.poll();
            }
            queue.add(c[i][1]);
        }
        return queue.size();
    }

    public static void main(String[] args) {
        BM96 bm96 = new BM96();
        System.out.println(bm96.minmumNumberOfHost(34, new int[][]{{547,612},{417,551},{132,132},{168,446},{95,747},
                {187,908},{115,712},{15,329},{612,900},{3,509},
                {181,200},{562,787},{136,268},{36,784},{533,573},
                {165,946},{343,442},{127,725},{557,991},{604,613},
                {633,721},{287,847},{414,480},{428,698},{437,616},
                {475,932},{652,886},{19,992},{132,543},{390,869},
                {754,903},{284,925},{511,951},{272,739}
        }));
    }
}
