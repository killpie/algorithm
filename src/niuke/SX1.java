package niuke;

public class SX1 {
    public static void main(String[] args) {
        SX1 sx1 = new SX1();
        System.out.println(sx1.NumberOf1Between1AndN_Solution(11));
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        if (n<=0)
            return 0;
        if (n<9)
            return 1;
        int k = 0;
        int sum = 0;
        int high = 0;
        int low = 0;

        for (int i = 1; (k=n/i)!=0; i*=10) {
            high = k/10;
            low=k%10;
            sum+=high*i;
            if (low>1)
                sum+=i;
            if (low==1)
                sum+=n-k*i+1;
        }

        return sum;
    }
}
