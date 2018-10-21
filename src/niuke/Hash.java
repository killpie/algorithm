package niuke;

public class Hash {

    static int HASHLEN = 31;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String words[] = {"a", "b", "c","d","e", "f", "g","h","i","j", "k", "l","m","n", "u",
                "o","p","q","r","s","t","v","w"
        ,"x", "y", "z"};
        for (String word : words) {
            int temp = hash(word.toCharArray());
            System.out.println(temp);
        }
    }

    public static int hash(char[] word) {
        int index = 0;
        int i = 0;
        while (i < word.length) {
            index += index * 31 + word[i];
            i++;
        }
        return index % HASHLEN;

    }
}
