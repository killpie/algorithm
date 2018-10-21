package haoweilai;

import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.nextLine().toCharArray();


        if (chars.length==1){
            int v = chars[0]-'0';
            if (v%3==0)
                System.out.println(1);
            else
                System.out.println(0);
            return;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < chars.length; i++) {
            int sum = 0;
            for (int j = 0; j <= chars.length-i; j++) {
                int temp = 0;
                int t = i;
                int index = j;
                while (t--!=0){
                    temp+=chars[index++]-'0';
                }

                if (temp%3==0)
                    sum++;

            }

        }

        System.out.println(max);
    }
}
