package niuke;

public class xc {
    public static void main(String[] args) {
        xc xc = new xc();
        System.out.println(xc.bf("qweffd","q",1));
    }

    public boolean bf(String s, String t, int pos){
        int i = pos;
        int j = 0;
        while (i<s.length()&&j<t.length()){
            if (s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }else {
                j=1;
                i=i-j+2;
            }
        }
        if (j==t.length()){
            return true;
        }
        return false;
    }


}
