package niuke;

import java.util.ArrayList;


public class ZXDTree {
    int length = 0;
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        length = input.length-1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (input.length==0||input.length<k)
            return arrayList;


        for (int i = 0; i < k; i++) {
            create(input,0);
            arrayList.add(pop(input));
        }
        return arrayList;
    }

    public int pop(int[] input){
        int t = input[0];
        input[0] = input[length];
        length--;

        return t;
    }

    public void create(int[] input, int root){
        if (root>length)
            return;
        int left = root*2+1;
        int rigth = root*2+2;
        create(input,left);
        if (left<=length&&input[left]<input[root]){
            swap(input,left,root);
        }
        if (rigth<=length&&input[rigth]<input[root]){
            swap(input,rigth,root);
        }
        create(input,rigth);
    }

    public void swap(int[] input, int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        ZXDTree tree = new ZXDTree();
        int[] n = {4,5,1,6,2,7,3,8};

        ArrayList<Integer> arrayList = tree.GetLeastNumbers_Solution(n,10);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
