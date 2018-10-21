package concurrent;


import java.util.concurrent.Semaphore;

public class BoundedBuffer<E> {
    private final Semaphore availableItems, getAvailableSpaces;
    private final E[] items;
    private int putPosition = 0, takePosition = 0;

    public BoundedBuffer(int capacity){
        availableItems = new Semaphore(0);
        getAvailableSpaces = new Semaphore(capacity);
        items = (E[])new Object[capacity];
    }

    private boolean isEmpty(){
        return availableItems.availablePermits() == 0;
    }

    private boolean isFull(){
        return getAvailableSpaces.availablePermits() == 0;
    }

    public void put(E x) throws InterruptedException{
        getAvailableSpaces.acquire();
        doInsert(x);
        availableItems.release();
    }

    public E take() throws InterruptedException{
        availableItems.acquire();
        E item = doExtract();
        getAvailableSpaces.release();
        return item;
    }

    private synchronized void doInsert(E e){
        int i = putPosition;
        items[i] = e;
        putPosition = (++i == items.length)? 0:1;
    }

    private synchronized E doExtract(){
        int i = takePosition;
        E x = items[i];
        items[i] = null;
        takePosition = (++i == items.length)?0:i;
        return x;
    }
}
