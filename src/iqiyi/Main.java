package iqiyi;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] array = sc.nextLine().toCharArray();

        short[] sixNum = new short[6];



        short sum1 = 0;

        short sum2 = 0;

        for(int i = 0; i < 6; i++){

            short num = Short.valueOf(Character.toString(array[i]));

            sixNum[i] = num;

            if(i < 3)

                sum1 += num;

            else

                sum2 += num;

        }



        if(sum1 == sum2)

            System.out.println(0);

        else if (sum1 > sum2){

            for(int i = 3; i < 6; i++)

                sixNum[i] = (short)(9 - sixNum[i]);



            Arrays.sort(sixNum); //数组排序

            int cha = sum1 - sum2;

            for(int i = 5; i >= 0; i--){

                cha = cha - sixNum[i];

                if(cha <= 0) {

                    System.out.println(6 - i);

                    break;

                }

            }

        }else{

            for(int i = 0; i < 3; i++)

                sixNum[i] = (short)(9 - sixNum[i]);



            Arrays.sort(sixNum); //数组排序

            int cha = sum2 - sum1;

            for(int i = 5; i >= 0; i--){

                cha = cha - sixNum[i];

                if(cha <= 0) {

                    System.out.println(6 - i);

                    break;

                }

            }

        }

    }

}