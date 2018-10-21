package niuke;

public class NK44 {

    public static void main(String[] args) {
        NK44 nk44 = new NK44();
        System.out.println(nk44.ReverseSentence("student. a am I"));
    }

    public String ReverseSentence(String str) {

        if (str==null||str.length()==0||str.equals(" "))
            return str;
        String res = "";
        String tem = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==' '){
                res=" "+tem+res;
                tem = "";
            }else {
                tem+=str.charAt(i);
            }
        }

        res = tem+res;


        return res;

    }
}
