package niuke;

public class NK48 {
    public int Add(int num1,int num2) {
        if (num1==0)
            return num2;
        while (num2!=0){
            int temp = num1^num2;
            num2 = (num2&num1)<<1;
            num1 = temp;
        }

        return num1;
    }
}
