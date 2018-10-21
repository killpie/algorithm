package niuke;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PX1 {
    public String PrintMinNumber(int [] numbers) {
        if (numbers.length==0)
            return "";
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            arrayList.add(String.valueOf(numbers[i]));
        }

        Collections.sort(arrayList,(s1,s2)->{
            return (s1+s2).compareTo(s2+s1);
        });

        StringBuilder stringBuilder = new StringBuilder();

        arrayList.forEach((c)->{
            stringBuilder.append(c);
        });

        return stringBuilder.toString();
    }
}
