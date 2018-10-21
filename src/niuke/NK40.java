package niuke;



public class NK40 {
    public static void main(String[] args) {
        int[] a = {2,4,3,6,3,2,5,5};
        int[] b = {0};
        int[] c = {0};
        NK40 nk40 = new NK40();
        nk40.FindNumsAppearOnce(a,b,c);
        System.out.println(b[0]);
        System.out.println(c[0]);
    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length < 2)
            return;

        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            temp ^= array[i];
        }

        int index = find(temp);

        for (int i = 0; i < array.length; i++) {
            if (judge(array[i],index)){
                num1[0]^=array[i];
            }else {
                num2[0]^=array[i];
            }
        }
    }

    public boolean judge(int temp, int index){
        temp>>=index;
        if ((temp&1)==0)
            return false;
        else
            return true;
    }


    public int find(int temp){
        int index = 0;
        while ((temp&1)==0){
            temp>>=1;
            index++;
        }

        return index;
    }

}
