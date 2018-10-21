package beike;
import static java.lang.invoke.MethodHandles.lookup;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;


class GrandFather{
    static {
        System.out.println("i am grandfather");
    }
    static void thinking(){
        System.out.println("i am grandfather");
    }
}
class Father extends GrandFather{
    static {
        System.out.println("i am father");
    }
    static void thinking(){
        System.out.println("i am father");
    }
}

class Son extends Father{
    static void thinking(){
        System.out.println("son");
    }
/*        try {
            MethodType mt = MethodType.methodType(void.class);
            MethodHandle mh = lookup().findSpecial
                    (Father.class,"nking",mt,getClass());
            mh.invoke(this);
            super.thinking();
        }catch (Throwable e){
            e.fillInStackTrace();
        }
    }*/


}

public class Test {


    public static void main(String[] args) {
        System.out.println(f());
    }

    static int f(){
        int temp = 0;
        try {
            System.out.println(temp);
            int i = 0/0;
            return temp;
        }catch (Exception e){
            System.out.println("e");
            System.out.println(++temp);
            return temp;
        }finally {
            System.out.println("fina");
            System.out.println(++temp);

        }
    }
}
