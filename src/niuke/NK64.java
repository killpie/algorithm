package niuke;

import java.util.ArrayList;

public class NK64 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        if (num==null||num.length==0||size==0)
            return arrayList;
        for (int i = 0; i < num.length-size;i++) {
            int end = i+size>num.length?num.length:i+size;
            int max = Integer.MIN_VALUE;
            for (int j = i;j<end;j++){
                if (max<num[j])
                    max = num[j];
            }
            arrayList.add(max);

        }
        return arrayList;
    }
}
