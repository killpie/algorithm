package beike;

import java.util.Scanner;

public class San {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        long sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int tem = in.nextInt();
            sum+=tem;
            if (min>tem)
                min = tem;
        }
        System.out.println(sum-min);
    }
}
