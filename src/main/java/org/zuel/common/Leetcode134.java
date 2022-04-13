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

    // 从暴力解法推导到优化解法
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int remain = gas[i];
            // 用j标记从i出发能到达的最远点
            int j = i;
            while (remain - cost[j] >= 0) {
                remain = remain - cost[j] + gas[(j + 1) % n] ;
                j = (j + 1) % n;
                if (j == i) {
                    return i;
                }
            }
            if (j < i) {
                return -1;
            }
            // 如果i最远到j，下一步直接从i+1开始找
            i = j;
        }
        return -1;
    }

    // o(N)时间复杂度
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int len = gas.length;
        // minIndex是油箱油量最少的时候，假定初始值为0
        int curGas = 0, minGas = 0, minIndex = 0;
        for (int i = 0; i < len; i++) {
            curGas += gas[i] - cost[i];
            if (curGas < minGas) {
                minGas = curGas;
                minIndex = i + 1;
            }
        }
        return curGas < 0 ? -1 : minIndex;
    }

    public static void main(String[] args) {
        Leetcode134 leetcode134 = new Leetcode134();
        System.out.println(leetcode134.canCompleteCircuit(new int[]{4,5,2,6,5,3}, new int[]{3,2,7,3,2,9}));
    }
}
