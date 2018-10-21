package jd;

import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] a = new int[n][3];

        for (int i = 0; i < n; i++) {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
            a[i][2] = in.nextInt();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][1]<a[j][1]&&a[i][2]<a[j][2]&&a[i][0]<a[j][0]){
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
