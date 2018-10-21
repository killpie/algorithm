package niuke;

public class NK49 {
    public static void main(String[] args) {
        NK49 nk49= new NK49();
        System.out.println(nk49.StrToInt("123"));
    }
    public int StrToInt(String str) {
        if (str==null||str.length()==0)
            return 0;
        char[] chars = str.toCharArray();
        int res = 0;
        int pre = 1;
        if (chars[0]=='-')
            pre=-1;
        for (int i = (chars[0]=='+'||chars[0]=='-'?1:0); i < chars.length; i++) {
            if (chars[i]<'0'||chars[i]>'9')
                return 0;
            int temp = chars[i]-'0';
            res=(res<<1)+(res<<3)+temp;
        }
        return pre*res;
    }
}
