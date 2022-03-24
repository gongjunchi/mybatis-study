package org.zuel.common;

public class Leetcode134 {

    // 时间复杂度不达标
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = -1;
        int n = gas.length;
        // 分别从不同的加油站出发
        for (int i = 0; i < n; i++) {
            int cur = gas[i];
            int step = 0;
            int nextStep = i;
            int costNextStep = i;
            while (step < n) {
                if (cur < cost[costNextStep]) {
                    // 当前油量不够到达下一加油站
                    break;
                } else {
                    nextStep = nextStep + 1 < n ? nextStep + 1 : (nextStep + 1) % n;
                    cur = cur - cost[costNextStep] + gas[nextStep];
                    costNextStep = costNextStep + 1 < n ? costNextStep + 1 : (costNextStep + 1) % n;
                    step++;
                }
            }
            if (step == n) {
                start = i;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Leetcode134 leetcode134 = new Leetcode134();
        System.out.println(leetcode134.canCompleteCircuit(new int[]{4,5,2,6,5,3}, new int[]{3,2,7,3,2,9}));
    }
}
