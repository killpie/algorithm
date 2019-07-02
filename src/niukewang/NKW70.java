package niukewang;


import java.util.ArrayList;
import java.util.List;

/**
 * 查找字符串中出现最多的字符,如果有两个字符串出现的次数相同，
 * 则取第一次出现的
 */
public class NKW70 {

    public static void main(String[] args) {
        NKW70 nkw70 = new NKW70();
        String a = "aassccsccsssc";
        //预期输出 s 6
        System.out.println("char:"+(char)nkw70.search(a)[0]+" , count:"+nkw70.search(a)[1]);
        String a1 = "aacssccsccsssceeeeee";
        //预期输出 c 6
        System.out.println("char:"+(char)nkw70.search(a1)[0]+" , count:"+nkw70.search(a1)[1]);

    }

    public int[] search(String str){

        char[] chars = str.toCharArray();
        //记录字符出现次数
        List<Integer> countList = new ArrayList<>();
        //记录字符出现的索引位置
        List<Character> indexList = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            if (indexList.contains(chars[i])){
                int index = indexList.indexOf(chars[i]);
                countList.set(index,countList.get(index)+1);
            }else {
                indexList.add(chars[i]);
                countList.add(1);
            }
        }

        int max = countList.get(0);
        char val = indexList.get(0);
        for (int i = 1; i < countList.size(); i++) {
            if (countList.get(i) > max){
                max = countList.get(i);
                val = indexList.get(i);
            }
        }
        //返回数组便于测试
        int[] returnVal = new int[2];
        returnVal[0] = val;
        returnVal[1] = max;
        return returnVal;
    }

}
