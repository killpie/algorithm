package niuke;

public class NK50 {

    public static void main(String[] args) {
        int[] d = new int[1];
        int[] a = {1,2,1};
        NK50 nk50 = new NK50();

        System.out.println(nk50.duplicate(a,3,d));
        System.out.println(d[0]);
    }

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers==null||length==0)
            return false;
        for (int i = 0; i < length; i++) {
            int index = numbers[i]%length;
            if (numbers[index]>=length){
                duplication[0] = index;
                return true;
            }
            numbers[index]+=length;
        }
        return false;
    }




}
