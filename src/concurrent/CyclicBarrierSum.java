package concurrent;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程求和
 */
public class CyclicBarrierSum {

    LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
    final CyclicBarrier barrier = new CyclicBarrier(10);
    final static ExecutorService pool = Executors.newCachedThreadPool();
    int[][] n = new int[9][9];
    AtomicInteger atomicInteger = new AtomicInteger();
    public static void main(String[] args) {
        CyclicBarrierSum barrierSum = new CyclicBarrierSum();
        barrierSum.init();
        barrierSum.sumSon();
        pool.shutdown();
    }

    void init(){
        AtomicInteger integer = new AtomicInteger();
        int t = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                n[i][j] = integer.getAndIncrement();
                t+=n[i][j];
            }
        }
        System.out.println("t="+t);
    }

    void sumSon(){
        for (int i = 0; i < 9; i++) {
            final int k = i;
            pool.execute( ()->{
                int sum = 0;
                for (int j = 0; j < 9; j++) {
                    sum+=n[k][j];
                }
                linkedHashSet.add(sum);
                try {
                  //  print();
                    barrier.await();
                    System.out.println("atomic="+atomicInteger.getAndIncrement());
                }catch (InterruptedException | BrokenBarrierException e){
                    System.out.println("失败");
                }
            });
        }
        try {


            barrier.await();
            System.out.println("atomic="+atomicInteger.getAndIncrement());
            sum();
        }catch (InterruptedException | BrokenBarrierException e){
            System.out.println("失败");
        }

    }

    void sum(){
        int sum = 0;

        for (Integer e:linkedHashSet
             ) {
            sum +=e;
        }
        System.out.println("sum="+sum);
    }

    synchronized void print(){
        System.out.println("threadName="+Thread.currentThread().getName());
        System.out.println("getNumberWaiting="+barrier.getNumberWaiting());
        System.out.println("Parties="+barrier.getParties());
        System.out.println("Broken="+barrier.isBroken());
        System.out.println();
    }


}
