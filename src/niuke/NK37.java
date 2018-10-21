package niuke;

public class NK37 {
    public static void main(String[] args) {
        int[] d = {1,2,3,3,3,3,4,5};
        NK37 nk37 = new NK37();
        System.out.println(nk37.GetNumberOfK(d,3));
    }
    public int GetNumberOfK(int [] array , int k) {
        if (array==null||array.length==0)
            return 0;
        int low = 0;
        int high = array.length-1;

        int index = -1;
        while (low<=high){
            int mid = (low+high)>>1;
            if (array[mid]>k){
                high = mid-1;
            }else if (array[mid]<k){
                low = mid+1;
            }else {
                index=mid;
                break;
            }
        }
        if (index==-1)
            return 0;
        int count = 0;
        int pre = index-1;
        while (index<array.length&&array[index]==k){//向后
            count++;
            index++;
        }

        while (pre>=0&&array[pre]==k){//向前
            count++;
            pre--;
        }

        return count;
    }
}
