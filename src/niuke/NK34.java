package niuke;



public class NK34 {
    public int FirstNotRepeatingChar(String str) {

        int[] count = new int[64];
        int[] index = new int[64];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c<='Z'&&c>='A'){
                if (++count[c-65]==1)
                    index[c-65]=i;
            }
            if (c<='z'&&c>='a')
                if (++count[c-71]==1)
                    index[c-71]=i;
        }
        int g = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++) {
            if (count[i]==1){
                if (g>index[i])
                    g=index[i];
            }
        }
        if (g!=Integer.MAX_VALUE)
            return g;
        return -1;
    }

    public static void main(String[] args) {


        NK34 nk34 = new NK34();
        System.out.println(nk34.FirstNotRepeatingChar(""));

    }
}
