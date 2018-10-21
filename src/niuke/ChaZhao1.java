package niuke;

import java.util.ArrayList;

public class ChaZhao1 {
    public static void main(String[] args) {
        //1,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
        int[][] n = {
                {1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}
        };
        int[][] n1 = {
                {1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}
        };
        int[][] n2 = {
                {1},
                {2},
                {3},
                {4},
                {5},
        };

        ChaZhao1 c = new ChaZhao1();
        ArrayList a = c.printMatrix(n2);
        a.forEach(v-> System.out.println(v));
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (matrix==null)
            return null;


        int r = matrix.length;
        int c = matrix[0].length;


        int sum = r*c;

        int i=0,j=0;
        while (sum!=0){

            int q=0,w=0;
            while (w<c){

                arrayList.add(matrix[i][j]);
                j++;
                w++;
                sum--;
            }
            if (sum==0)
                break;
            j--;
            r--;
            while (q<r){
                i++;
                arrayList.add(matrix[i][j]);
                q++;
                sum--;
            }
            if (sum==0)
                break;
            c--;
            q=0;
            w=0;
            while (w<c){
                j--;
                arrayList.add(matrix[i][j]);
                w++;
                sum--;
            }
            if (sum==0)
                break;
            r--;
            while (q<r){
                i--;
                arrayList.add(matrix[i][j]);
                q++;
                sum--;
            }
            if (sum==0)
                break;
            c--;
            j++;
        }

        return arrayList;
    }


}
