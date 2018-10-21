package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionBoundedBuffer<T> {
    protected final Lock lock= new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private final Object[] items = new Object[100];
    private int tail, head, count;

    //阻塞并直到：notFull
    public void put(T x)throws InterruptedException{
        lock.lock();
        try{
            while (count == items.length)
                notFull.await();//阻塞
            items[tail] = x;
            if (++tail==items.length){
                tail = 0;
            }
            ++count;
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException{
        lock.lock();
        try{
            while (count == 0){
                notEmpty.await();
            }
            T x = (T)items[head];
            if (++head==items.length){
                head = 0;
            }
            count--;
            notFull.signal();
            return x;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ConditionBoundedBuffer boundedBuffer = new ConditionBoundedBuffer();

        Thread take1 = new Thread(()->{
            try {
                System.out.println("take1 = "+boundedBuffer.take());
            }catch (InterruptedException e){

            }

        });
        take1.start();
        Thread take2 = new Thread(()->{
            try {
                System.out.println("take2 = "+boundedBuffer.take());
            }catch (InterruptedException e){

            }

        }) ;
        take2.start();
        Thread put1 = new Thread(()->{
            try {
                System.out.println(1);
                boundedBuffer.put("put1");
            }catch (InterruptedException e){

            }

        }) ;
        put1.start();
        Thread take3 = new Thread(()->{
            try {
                System.out.println("take3 = "+boundedBuffer.take());
            }catch (InterruptedException e){

            }

        }) ;
        take3.start();
        Thread put2 = new Thread(()->{
            try {
                boundedBuffer.put("put2");
            }catch (InterruptedException e){

            }

        }) ;
        put2.start();
        Thread put3 = new Thread(()->{
            try {
                boundedBuffer.put("put3");
            }catch (InterruptedException e){

            }

        }) ;
        put3.start();
        Thread put4 = new Thread(()->{
            try {
                boundedBuffer.put("put4");
            }catch (InterruptedException e){

            }

        }) ;
        put4.start();
    }
}
