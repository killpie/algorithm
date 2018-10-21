package niuke;

public class NK51 {
    public int[] multiply(int[] A) {
        if (A==null||A.length==0)
            return new int[0];
        int[] b = new int[A.length];
        b[0] = 1;
        for (int i = 1; i < b.length; i++) {
            b[i]=b[i-1]*A[i-1];//上三角相乘
        }
        int temp = 1;
        for (int i = b.length-2; i >=0 ; i--) {//下三角连乘
            temp*=A[i+1];
            b[i]*=temp;
        }
        return b;
    }
}
