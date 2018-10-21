package iqiyi;

import java.util.Arrays;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        scanner.nextLine();
        int[] food = new int[n];
        for (int i = 0; i < food.length; i++) {
            food[i] = scanner.nextInt();
        }
        scanner.nextLine();
        for (int i = 0; i < m; i++) {
            String[] temp = scanner.nextLine().split(" ");
            String t = temp[0];
            int index = Integer.parseInt(temp[1]);
            if (t.equals("A"))
                food[index-1]++;
            else
                food[index-1]--;
        }

        int key = food[p-1];

        Arrays.sort(food);

        for (int i = food.length-1; i >= 0; i--) {
            if (key==food[i]){
                System.out.println(food.length-i);
                break;
            }
        }


    }
}
