package haoweilai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class San {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] n = {0,1,2,3,4,5,6,7,8,9};
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < n.length; i++) {
            int c = in.nextInt();
            if (c==0)
                arrayList.add(i);
        }

        int le = (int) Math.pow(2,arrayList.size());

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < le; i++) {
            String s = Integer.toBinaryString(i);
            while (s.length()!=arrayList.size()){
                s="0"+s;
            }
            char[] chars = s.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            int index = 0;
            for (int j = 0; j < n.length; j++) {
                if (arrayList.contains(j)){
                    boolean b = chars[index++] != '0';
                    if (b)
                        stringBuilder.append(j);
                }else {
                    stringBuilder.append(j);
                }
            }
            String d = stringBuilder.toString();
            strings.add(d);
        }

        Collections.sort(strings);

        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }
}
