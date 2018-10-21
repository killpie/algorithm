package niuke;



public class Stack {

    protected int[] elementData;
    protected int elementCount;
    protected int tail;
    protected int min;

    public Stack(){
        elementData = new int[64];
        elementCount=0;
        tail=64;
        min = Integer.MAX_VALUE;
    }
    public void push(int node) {
        if (tail==0)
            return;

        tail--;
        elementCount++;
        elementData[tail]=node;
        f();
    }

    public void pop() {
        if (tail==64)
            return;

        tail++;
        f();
        elementCount--;
    }

    public int top() {
        if (tail==64){
            throw new RuntimeException("栈为空");
        }
        return elementData[tail];
    }

    public int min() {
        if (tail==64){
            throw new RuntimeException("栈为空");
        }
        return min;
    }

    private void f(){
        min = Integer.MAX_VALUE;
        for (int i = 63; i >=tail; i--) {
            if (min>elementData[i]){
                min=elementData[i];
            }
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(7);
        stack.push(3);
        stack.push(1);
        stack.pop();
        stack.pop();

        System.out.println(stack.min());
        stack.push(9);
        stack.push(3);
        stack.push(14);
        System.out.println(stack.min());
    }
}
