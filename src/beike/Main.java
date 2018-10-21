package beike;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(scanner.nextLine());

            String[] strings = new String[1];
            for (int j = 0; j < n; j++) {
                if (j==0)
                    strings[j] = scanner.nextLine();
                else
                    hashSet.add(scanner.nextLine());
            }

            if (n<2){
                System.out.println("Sad");
                continue;
            }

            if (hashSet.size()<n-1){
                System.out.println("Yeah");
                continue;
            }

            StringBuilder stringBuilder = new StringBuilder(strings[0]);

            boolean flag = false;
            for (int j = 1; j < stringBuilder.length(); j++) {
                String s = stringBuilder.substring(j).concat(stringBuilder.substring(0,j));
                hashSet.add(s);
                if (hashSet.size()==n-1){
                    flag = true;
                    break;
                }
                hashSet.remove(s);
                String str = new StringBuilder(s).reverse().toString();
                hashSet.add(str);
                if (hashSet.size()==n-1){
                    flag = true;
                    break;
                }
                hashSet.remove(str);
            }
            hashSet.clear();
            if (flag){
                System.out.println("Yeah");
            }else
                System.out.println("Sad");
        }
    }
}
