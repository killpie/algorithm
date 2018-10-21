package disi;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        String sub = "";
        int len = str.length();
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < len; j++) {
                if (i + j <= len) {
                    String temp = str.substring(j,j+i);
                    if (check(temp)){
                        sub = temp;
                        break;
                    }
                }
            }
        }

        System.out.println(sub);

    }


    static boolean check(String str){
        if (str.length()==1)
            return true;
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i)!=str.charAt(str.length()-1-i))
                return false;
        }

        return true;
    }


}
