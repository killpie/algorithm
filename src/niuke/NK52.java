package niuke;


public class NK52 {
    public static void main(String[] args) {
        NK52 nk52 = new NK52();
        System.out.println(nk52.match("aaa".toCharArray(),"a*a".toCharArray()));
    }
    public boolean match(char[] str, char[] pattern) {
        if ((str==null&&pattern==null)||(str.length==0&&pattern.length==0))
            return true;
        if (str!=null&&str.length>0&&pattern!=null&&pattern.length==0)
            return false;

        boolean flag = f(str,0,pattern,0);
        return flag;
    }

    public boolean f(char[] str, int i, char[] pattern, int j){
        if (i==str.length&&j==pattern.length-2)
            return true;
        if (i==str.length&&j<pattern.length-2)
            return false;
        if (j+1<pattern.length){
            if (pattern[j+1]!='*'){
                if (pattern[j]=='.'||(i<str.length&&str[i]==pattern[j])){
                    return f(str,i+1,pattern,j+1);
                }else {
                    return false;
                }
            }
            if (pattern[j+1]=='*'){
                if (i<str.length&&str[i]!=pattern[j]&&pattern[j]!='.'){
                    return f(str,i,pattern,j+2);
                }else {
                    return f(str,i+1,pattern,j)||f(str,i,pattern,j+2);//1或多个
                }
            }
        }else {
            if (pattern[j]=='.'||(i<str.length&&str[i]==pattern[j])){
                if (i==str.length-1)
                    return true;
                else
                    return false;
            }else {
                return false;
            }
        }
        return false;
    }
}
