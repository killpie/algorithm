package niukewang;

/**
 * <title>二维数组中的查找<title/>
 *
 *在一个二维数组中<span>（每个一维数组的长度相同），<span/>
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 *
 * 提示数组是有序的
 */
public class NKW1 {
    public static void main(String[] args) {
        int[][] a = {{1,2,8,9},
                     {4,7,10,13}};
        NKW1 nkw1 = new NKW1();
        boolean s = nkw1.Find(7,a);
        System.out.println(s);
    }

    public boolean Find(int target, int [][] array) {
        int con = array[0].length-1;
        int r = 0;

        while (r<=array.length-1&&con>=0){
            if (array[r][con] == target)
                return true;
            if (target > array[r][con]){
                r++;
            }else {
                con--;
            }
        }

        return false;
    }
}
