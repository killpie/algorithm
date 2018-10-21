package niuke;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class QPL {
    public static void main(String[] args) {
        QPL a = new QPL();
        int[] a1 = {1,2,3,2,4,2,5,2,3};
        System.out.println(a.MoreThanHalfNum_Solution(a1));
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array==null||array.length==0){
            return 0;
        }
        if (array.length==1){
            return array[0];
        }
        int flag = 1;
        int cur = array[0];
        for (int i = 1; i < array.length; i++) {
            if (cur!=array[i]){
                if (--flag<0){
                    cur=array[i];
                    flag++;
                }
            }else {
                flag++;
            }
        }

        if (flag>=1){
            return cur;
        }

        return 0;
    }
}
