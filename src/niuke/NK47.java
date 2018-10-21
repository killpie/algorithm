package niuke;

public class NK47 {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean f = (sum>0)&&(sum+=Sum_Solution(--n))>0;
        return sum;
    }
}
