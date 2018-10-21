package niuke;

public class NK54 {
    int[] p = new int[256];
    StringBuffer stringBuffer = new StringBuffer();
    //Insert one char from stringstream
    public void Insert(char ch) {
        stringBuffer.append(ch);
        p[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char[] chars = stringBuffer.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (p[chars[i]]==1)
                return chars[i];
        }
        return '#';
    }
}
