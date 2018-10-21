package niuke;

import java.util.Stack;

public class Staon {

    public boolean IsPopOrder(int [] pushA,int [] popA) {

        if (popA.length==0||pushA.length==0){
            return false;
        }

        Stack<Integer> stack = new Stack();
        int popIndex = 0;

        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty()&&stack.peek()==popA[popIndex]){
                stack.pop();
                popIndex++;
            }
            if (stack.isEmpty())
                return true;
        }

        return false;

    }

    public static void main(String[] args) {
        Staon staon = new Staon();
        int[] push={1,2,3,4,5};

        int[] pop ={4,5,2,3,1};

        System.out.println(staon.IsPopOrder(push,pop));
    }

}
