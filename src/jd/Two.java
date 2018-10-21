package jd;

import java.util.ArrayList;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                int a = in.nextInt();
                int b = in.nextInt();
                if (!arrayList.isEmpty()){
                    if (arrayList.contains(a))
                        arrayList.remove(new Integer(a));
                    else
                        arrayList.add(a);

                    if (arrayList.contains(b))
                        arrayList.remove(new Integer(b));
                    else
                        arrayList.add(b);
                }else {
                    arrayList.add(a);
                    arrayList.add(b);
                }
            }
            if (arrayList.size()==0)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
