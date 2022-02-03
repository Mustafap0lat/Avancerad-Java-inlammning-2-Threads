package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {

        Thread t1 = new Thread(new Worker(1, 50000, ThreadColor.ANSI_RED));
        Thread t2 = new Thread(new Worker(50001, 100000, ThreadColor.ANSI_BLUE));
        Thread t3 = new Thread(new Worker(100001, 150000, ThreadColor.ANSI_GREEN));
        Thread t4 = new Thread(new Worker(150001, 200000, ThreadColor.ANSI_CYAN));
        Thread t5 = new Thread(new Worker(200001, 250000, ThreadColor.ANSI_PURPLE));
        Thread t6 = new Thread(new Worker(250001, 300000, ThreadColor.ANSI_YELLOW));
        Thread t7 = new Thread(new Worker(300001, 350000, ThreadColor.ANSI_WHITE));
        Thread t8 = new Thread(new Worker(350001, 400000, ThreadColor.ANSI_BLACK));
        Thread t9 = new Thread(new Worker(400001, 450000, ThreadColor.ANSI_RED));
        Thread t10 = new Thread(new Worker(450001, 500000, ThreadColor.ANSI_YELLOW));


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

    }

    private static class Worker implements Runnable {
        int start;
        int stop;
        private int runCount = 0;
        private String threadColor;


        public Worker(int start, int stop, String threadColor) {
            this.threadColor = threadColor;
            this.start = start;
            this.stop = stop;
        }

        @Override
        public void run() {
            for (int i = start; i <= stop; i++) {

                int counter = 0;

                for (int j = i; j >= 1; j--) {
                    if (i % j == 0) {
                        ++counter;
                    }
                }
                if (counter == 2) {
                    runCount++;

                }

            }
            System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount);
            // execute critial section of code
        }
    }
}








