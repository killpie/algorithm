package concurrent;

public class TestBoundedBuffere {
    private final Long LOCKUP_DETECT_TIMEOUT = 10000L;

    public static void main(String[] args) {
        TestBoundedBuffere testBoundedBuffere = new TestBoundedBuffere();
        testBoundedBuffere.testTakeBlocksWhenEmpty();
    }
    void testTakeBlocksWhenEmpty(){
        final BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        Thread taker = new Thread(){
            public void run(){
                try{
                    int unused = bb.take();
                    fail();
                }catch (InterruptedException e){

                }
            }
        };
        try {
            taker.start();
            Thread.sleep(LOCKUP_DETECT_TIMEOUT);
            taker.interrupt();
            taker.join(LOCKUP_DETECT_TIMEOUT);
            System.out.println(taker.isAlive() );
        }catch (Exception e){
            fail();
        }
    }

    void fail(){
        System.out.println("失败了");
    }
}
