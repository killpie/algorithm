package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class TestHarness  {
    AtomicInteger a2 = new AtomicInteger();
    public static void main(String[] args) throws InterruptedException{
        AtomicInteger a1 = new AtomicInteger();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("R="+a1.getAndIncrement());
            }
        };

        r.run();
        Thread t = new Thread(){
            public void run(){
                System.out.println("q");
            }
        };
        t.start();

        System.out.println(new TestHarness().timeTasks(10,r));
    }

    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException{
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            int d = a2.getAndIncrement();
            System.out.println("d="+d);
            Thread t = new Thread(){
                public void run(){
                    try {
                        task.run();
                    }finally {
                            endGate.countDown();
                    }
                }
            };
            t.run();
        }

        if (a2.get()==10){
            startGate.countDown();
        }
        startGate.await();
        long start = System.nanoTime();
        endGate.await();
        long end = System.nanoTime();
        return end-start;
    }
}
