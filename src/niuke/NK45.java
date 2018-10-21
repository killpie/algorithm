package niuke;


public class NK45 {
    private byte[] bits;

    private int size;

    private int count = 0;
    public static void main(String[] args) {
        NK45 nk45 = new NK45();
        int[] s = {1,3,5,13,0};
        System.out.println(nk45.isContinuous(s));
    }

    public boolean isContinuous(int [] numbers) {
        if (numbers==null||numbers.length<5)
            return false;
        bits = new byte[2];
        for (int i = 0; i < numbers.length; i++) {
            set(numbers[i]);
        }
        int end = numbers.length;
        int c = 0;
        for (int i = 0; i < end; i++) {
            if (get(i)){
                c++;
                if (c==1){
                    end=i+5;
                }
            }
        }
        if (c+count==5){
            return true;
        }
        return false;
    }

    public void set(int index){
        if (index==0) {
            count++;
            return;
        }
        bits[index>>3]|=1<<(index&7);
    }

    public void clear(int index){
        if (index==0)
            return;
        bits[index>>3]&=~1<<(index&7);
    }

    public final boolean get(int bit) {
        return (bits[bit >> 3] & (1 << (bit & 7))) != 0;
    }
}
