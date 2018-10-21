package beike;

import java.util.HashSet;
import java.util.Scanner;

public class Er360 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n+1];

        for (int i = 1; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();
        int[] q = new int[k];
        for (int i = 0; i < k; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = start; j <= end; j++) {
                hashSet.add(a[j]);
            }
            q[i] = hashSet.size();
        }

        for (int i : q) {
            System.out.println(i);
        }
    }
}
