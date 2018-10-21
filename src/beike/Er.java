package beike;

import java.util.*;

public class Er {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[][] ac = new int[n][3];

        for (int i = 0; i < n; i++) {
            ac[i][0] = in.nextInt();
            ac[i][1] = in.nextInt();
            ac[i][2] = i+1;
        }

        Arrays.sort(ac,(a1,a2)->{
            if (a1[0]==a2[0]){
                if (a1[1]==a2[1])
                    return 0;
                if (a1[1]>a2[1])
                    return 1;
                if (a1[1]<a2[1])
                    return -1;
            }
            if (a1[0]>a2[0])
                return 1;
            if (a1[0]<a2[0])
                return -1;
            return -1;
        });

        int index = -1;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 1; i < n;i++) {
            if (ac[i][0]==ac[i-1][0]){
                index++;
                treeSet.add(ac[i][2]);
            }
        }
        if (index>=1){
            System.out.println(0);
            return;
        }

        for (int i = 1; i < n;i++) {
            if (ac[i][0]==ac[i-1][0]){
                if (i+1==n)
                    continue;
                if (ac[i+1][0]<ac[i-1][1]) {
                    System.out.println(0);
                    return;
                }
                i++;
            }else {
                if (ac[i][0]<ac[i-1][1]) {
                    index++;
                    treeSet.add(ac[i][2]);
                }
            }
        }

        if (index>=1){
            System.out.println(0);
            return;
        }
        if (index==0){
            System.out.println(1);
            System.out.println(treeSet.first());
            return;
        }
        if (index==-1){
            System.out.println(n);
            for (int i = 1; i < n+1; i++) {
                System.out.print(i);
                if (i!=n)
                    System.out.print(" ");
            }
        }

    }
}
