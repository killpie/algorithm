package niuke;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int sum = Integer.MAX_VALUE;
        int xmin = Integer.MAX_VALUE;
        int xmax = Integer.MIN_VALUE;
        int ymin = Integer.MAX_VALUE;
        int ymax = Integer.MIN_VALUE;
        scanner.nextLine();

        while (scanner.hasNext()){
            String[] strings = scanner.nextLine().split(",");
            int xtemp = Integer.parseInt(strings[0]);
            int ytemp = Integer.parseInt(strings[1]);
            if (xtemp<xmin){
                xmin = xtemp;
            }
            if (xtemp>xmax){
                xmax = xtemp;
            }
            if (ymin>ytemp){
                ymin=ytemp;
            }
            if (ymax<ytemp){
                ymax=ytemp;
            }
            if (xtemp+ytemp<sum){
                sum=xtemp+ytemp;
            }
        }

        int c = (xmax-xmin)*(ymax-ymin)*2+sum;
        System.out.println(c);
    }
}
