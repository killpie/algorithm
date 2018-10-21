package niuke;

public class CS {
    public int GetUglyNumber_Solution(int index) {
        if (index<7)
            return index;
        int[] array = new int[index];
        array[0] = 1;
        int t2=0, t3=0, t5=0;
        for (int i = 1; i < index; i++) {
            array[i] = Math.min(array[t2]*2,Math.min(array[t3]*3,array[t5]*5));
            if (array[i]==array[t2]*2)
                t2++;
            if (array[i]==array[t3]*3)
                t3++;
            if (array[i]==array[t5]*5)
                t5++;
        }
        return array[index-1];
    }
}
