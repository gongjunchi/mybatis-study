package org.zuel.common;

import java.util.concurrent.locks.LockSupport;

public class AlternateOutput {

    static Thread t1;
    static Thread t2;

    public static void main(String[] args) throws InterruptedException {

        ParkUnpark pu = new ParkUnpark(5);
        t1 = new Thread("t1") {
            @Override
            public void run() {
                pu.print("a", t2);
            }
        };
        t2 = new Thread("t2") {
            @Override
            public void run() {
                pu.print("b", t1);
            }
        };
        // 线程一启动就进入park状态
        t1.start();
        t2.start();
        // 主线程先睡眠1s
        Thread.sleep(1000);
        // 唤醒t1线程
        LockSupport.unpark(t1);
    }

}

class ParkUnpark {
    // 循环次数
    private int loopNum;

    public ParkUnpark(int loopNum) {
        this.loopNum = loopNum;
    }

    public void print(String str, Thread next) {
        for (int i = 0; i < loopNum; i++) {
            LockSupport.park();
            System.out.print(str);
            // 唤醒下一线程
            LockSupport.unpark(next);
        }
    }
}
