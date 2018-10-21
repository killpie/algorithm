package haoweilai;

import java.util.ArrayList;
import java.util.Scanner;

public class Wu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Integer> arrayList = new ArrayList<>();
        while (in.hasNext()){
            arrayList.add(in.nextInt());
        }

        int size = arrayList.size();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = arrayList.get(i);
        }
        int[] num = new int[size];
        for(int i=0;i<size;i++)
        {
            num[i] = a[i];
            for(int j=0;j<i;j++)
            {
                if(a[j]<a[i]&&num[j]+num[i]>num[i])
                    num[i]=num[j]+num[i];
            }
        }
        int maxx=0;
        for(int i=0;i<size;i++)
            if(maxx<num[i])
                maxx=num[i];
        System.out.println(maxx);
    }
}
