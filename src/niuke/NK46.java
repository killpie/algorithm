package niuke;

public class NK46 {

    public static void main(String[] args) {
        NK46 nk46 = new NK46();
        System.out.println(nk46.LastRemaining_Solution(3,4));
    }

    public int LastRemaining_Solution(int n, int m) {
        if (m==0)
            return n-1;
        if (n==0)
            return 0;
        int[] d = new int[n];
        int length = n;

        int c = 0;
        for (int i = 0; i < length; i++) {
            if (d[i]==0){
                c++;
            }
            if (c==m){
                d[i] = -1;
                c=0;
                if (--n==1){
                    break;
                }
            }
            if (i==length-1){
                i=-1;
            }
        }

        for (int i = 0; i < length; i++) {
            if (d[i]==0)
                return i;
        }

        return 0;
    }
}
