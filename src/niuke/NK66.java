package niuke;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，
 * 下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，
 * 机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class NK66 {


    public static void main(String[] args) {
        NK66 nk66 = new NK66();

        System.out.println(nk66.movingCount(15,20,20));
    }

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] grid = new boolean[rows][cols];



        return count(threshold,0,rows-1,0,cols-1, grid);
    }

    private int count(int threshold, int row, int maxRow, int col, int maxCol, boolean[][] grid){
        if (row<0||row>maxRow||col<0||col>maxCol||grid[row][col]||check(threshold,row,col)){
            return 0;
        }
        grid[row][col] = true;
        return count(threshold,row-1,maxRow,col,maxCol,grid)+
                count(threshold,row+1,maxRow,col,maxCol,grid)+
                count(threshold,row,maxRow,col+1,maxCol,grid)+
                count(threshold,row,maxRow,col-1,maxCol,grid)+
                1;
    }

    private boolean check(int threshold, int rows, int cols){
        int sum = 0;
        while (rows!=0){
            sum = sum+rows%10;
            rows = rows/10;
        }

        while (cols!=0){
            sum = sum+cols%10;
            cols = cols/10;
        }

        if (threshold<sum){
            return true;
        }
        return false;
    }
}
