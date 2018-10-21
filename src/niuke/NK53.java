package niuke;

public class NK53 {
    public static void main(String[] args) {
        NK53 nk53 = new NK53();
        System.out.println(nk53.isNumeric("-.1416".toCharArray()));
    }
    public boolean isNumeric(char[] str) {
        if(str==null||str.length==0)
            return false;
        if (str.length==1){
            if ('9'<str[0]||str[0]<'0')
                return false;
        }

        int e=0;
        int xsd=0;
        for (int i = 0; i < str.length; i++) {
            if (str[i]=='+'||str[i]=='-'){
                if (i!=0&&!(str[i-1]=='E'||str[i-1]=='e'))
                    return false;
            }
            if (str[i]=='E'||str[i]=='e'){
                if (i==str.length-1)
                    return false;
                e++;
                if (e>1)
                    return false;
            }
            if (str[i]=='.'){
                xsd++;
                if (xsd>1)
                    return false;
                if ((i-2>=0&&(str[i-2]=='e'||str[i-2]=='E'))||
                        (i-3>=0&&(str[i-3]=='e'||str[i-3]=='E'))){
                    return false;
                }
                if (i-1<0)
                    return false;
                if (i+1>str.length-1)
                    return false;
                if (i==1&&str[i-1]=='-')
                    continue;
                if (str[i-1]<'0'||str[i-1]>'9'||str[i+1]<'0'||str[i+1]>'9')
                    return false;
            }
            if (!((str[i]>='0'&&str[i]<='9')||str[i]=='E'||str[i]=='e'||
                    str[i]=='.'||str[i]=='+'||str[i]=='-'))
                return false;
        }

        return true;

    }
}
