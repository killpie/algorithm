package niuke;


import java.util.ArrayList;

public class NK63 {

    public static void main(String[] args) {
        NK63 nk63 = new NK63();
        //5,2,3,4,1,6,7,0,8
        nk63.Insert(5);
        System.out.println(nk63.GetMedian());
        nk63.Insert(2);
        System.out.println(nk63.GetMedian());
        nk63.Insert(3);
        System.out.println(nk63.GetMedian());
        nk63.Insert(4);
        System.out.println(nk63.GetMedian());
        nk63.Insert(1);
        System.out.println(nk63.GetMedian());
        nk63.Insert(6);
        System.out.println(nk63.GetMedian());
        nk63.Insert(7);
        System.out.println(nk63.GetMedian());
        nk63.Insert(0);
        System.out.println(nk63.GetMedian());
        nk63.Insert(8);


        System.out.println(nk63.GetMedian());
    }

    ArrayList<Integer> arrayList;
    ArrayList<Integer> copyList = new ArrayList<>();
    public void Insert(Integer num) {
        copyList.add(num);
    }

    public Double GetMedian() {
        arrayList = (ArrayList<Integer>) copyList.clone();
        int n = arrayList.size();
        int k = n/2+1;
        HeapSort(k);
        Double res ;
        if (n%2==0){
            res = (Double.valueOf(arrayList.get(n-k))+Double.valueOf(arrayList.get(n-k+1)))/2.0;
            return res;
        }else{
            res = Double.valueOf(arrayList.get(n-k));
            return res;
        }
    }

    void HeapSort(int k){//排前k个数
        int n = arrayList.size();
       Create();
        for (int i = n-1; i >=n-k; i--) {
            int x = arrayList.get(0);
            arrayList.set(0,arrayList.get(i));
            arrayList.set(i,x);
            HeapAdjust(0,i-1);
        }
    }

    void Create(){
        int n = arrayList.size();
        for (int i = n/2-1; i >=0 ; i--) {//索引从0开始
            HeapAdjust(i,n-1);
        }
    }

    void HeapAdjust(int s, int m){//大根堆 调整以为根的对
        int key = arrayList.get(s);
        for (int i = 2*s+1; i <= m; i=2*i+1) {
            if (i+1<=m&&arrayList.get(i)<arrayList.get(i+1))
                i++;
            if (key>arrayList.get(i))
                break;
            arrayList.set(s,arrayList.get(i));
            s=i;
        }
        arrayList.set(s,key);
    }

}
