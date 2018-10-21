package niuke;

public class TX1 {

    public static void main(String[] args) {
        TX1 tx1 = new TX1();
        int[] a = {6,-3,-2,7,-15,1,2,2};
        System.out.println(tx1.FindGreatestSumOfSubArray(a));
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length==0)
            return array[0];
        int sum = array[0];
        int realSum = sum;
        for (int i = 1; i < array.length; i++) {
            if (sum+array[i]>realSum){
                realSum = sum+array[i];
                sum = sum+array[i];
            }else {
                if (sum+array[i]<0)
                    sum=0;
                else
                    sum = sum+array[i];

            }
        }

        return realSum;

    }
}
