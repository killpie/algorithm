package beike;

import java.math.BigInteger;
import java.util.Scanner;

public class One360 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (x>maxX)
                maxX = x;
            if (x<minX)
                minX = x;
            if (y>maxY)
                maxY=y;
            if (y<minY)
                minY=y;
        }

        int lengthX = maxX-minX;
        int lengthY = maxY-minY;

        int t = 0;
        if (lengthX>=lengthY){
            t=lengthX;
        } else{
            t=lengthY;
        }

        BigInteger bigInteger = new BigInteger(String.valueOf(t));
        System.out.println(bigInteger.pow(2));
    }
}
