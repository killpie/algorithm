package iqiyi;

import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ints[i] = chars[i]-'0';
        }

        int t1 = ints[0]+ints[1]+ints[2];
        int t2 = ints[3]+ints[4]+ints[5];
        if (t1==t2){
            System.out.println(0);
            return;
        }

        int sub = Math.abs(t1-t2);
        if (sub<10){
            if (t1>t2){
                if (ints[0]<sub&&ints[2]<sub&&ints[1]<sub){
                    System.out.println(2);
                }else {
                    System.out.println(1);
                }
            }else {
                if (ints[3]<sub&&ints[4]<sub&&ints[5]<sub){
                    System.out.println(2);
                }else {
                    System.out.println(1);
                }
            }
           return;
        }
        if (sub<19){
            System.out.println(2);
            return;
        }

        System.out.println(3);

    }
}
