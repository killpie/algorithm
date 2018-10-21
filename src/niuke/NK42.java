package niuke;

import java.util.ArrayList;

public class NK42 {

    public static void main(String[] args) {
        NK42 nk42 = new NK42();
        int[] s = {1,2,4,7,11,16};
        ArrayList arrayList = nk42.FindNumbersWithSum(s,10);
        arrayList.forEach(v->{
            System.out.println(v);
        });
    }
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (array==null||array.length<2){
            return arrayList;
        }

        int end = 0;

        for (int i = array.length-1; i >=0; i--) {
            if (sum>array[i]){
                end=i;
                break;
            }
        }

        int a=0,b=0,c=Integer.MAX_VALUE;
        boolean flag = false;
        for (int i = 0; i <= end; ) {
            if (array[i]+array[end]>sum){
                end--;
            }
            if (array[i]+array[end]<sum){
                i++;
            }
            if (array[i]+array[end]==sum){
                flag = true;
                if (c>array[i]*array[end]){
                    c=array[i]*array[end];
                    a=array[i];
                    b=array[end];
                    i++;
                    end--;
                }else {
                    i++;
                    end--;
                }
            }
        }


        if (flag){
            arrayList.add(a);
            arrayList.add(b);
        }


        return arrayList;
    }
}
