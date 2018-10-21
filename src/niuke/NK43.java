package niuke;

public class NK43 {

    public static void main(String[] args) {
        Integer d = 1111;
        Integer c = new Integer(1111);
        System.out.println(d==c);
        NK43 nk43 = new NK43();
        System.out.println(nk43.LeftRotateString("abcXYZdef",3));
    }
    public String LeftRotateString(String str,int n) {
        if (str==null||str.length()==0)
            return str;
        int rol = n%str.length();
        String q = str.substring(0,rol);
        String p = str.substring(rol);

        return p+q;
    }
}
