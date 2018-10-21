package concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PutTakeTest {
    private static final ExecutorService pool = Executors.newCachedThreadPool();
    private final AtomicInteger putSum = new AtomicInteger(0);
    private final AtomicInteger takeSum = new AtomicInteger(0);
    private final CyclicBarrier barrier;
    private final BoundedBuffer<Integer> bb;
    private final int nTials, nPairs;

    public static void main(String[] args){
        new PutTakeTest(10,10,100000).test();
        pool.shutdown();
    }

    PutTakeTest(int capacity, int npairs, int ntrials){
        this.bb = new BoundedBuffer<>(capacity);
        this.nTials = ntrials;
        this.nPairs = npairs;
        this.barrier = new CyclicBarrier(npairs*2+1);
    }

    void test(){
        try{
            for (int i = 0; i < nPairs; i++) {
                pool.execute(new Producer());
                pool.execute(new Consumer());
            }
            barrier.await();//等待所有线程就绪
            barrier.await();//等待所有线程执行完成
            System.out.println(putSum.get()==takeSum.get());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    class Producer implements Runnable{
        @Override
        public void run() {
            try{
                int seed = (this.hashCode()^(int)System.nanoTime());
                int sum = 0;
                barrier.await();
                for (int i = nTials; i > 0 ; --i) {
                    bb.put(seed);
                    sum+=seed;
                    seed = xorShift(seed);
                }
                putSum.getAndAdd(sum);
                barrier.await();
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    class Consumer implements Runnable{
        @Override
        public void run() {
            try{
                barrier.await();
                int sum = 0;
                for (int i = nTials; i > 0; i--) {
                    sum += bb.take();
                }
                takeSum.getAndAdd(sum);
                barrier.await();
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    static int xorShift(int y){
        y^=(y<<6);
        y^=(y>>>21);
        y^=(y<<7);
        return y;
    }
}
