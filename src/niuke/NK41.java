package niuke;

import java.util.ArrayList;

public class NK41 {
    
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

        for (int i = (int) Math.sqrt(2*sum); i >=2 ; i--) {
            if ((i&1)==1&&sum%i==0 || (sum%i)*2==i){
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int j = 0, k = sum/i-(i-1)/2; j <i ; j++,k++) {
                    arrayList.add(k);
                }
                arrayLists.add(arrayList);
            }
        }

        return arrayLists;
    }
}
