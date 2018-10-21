package jd;

public class Test {
    public static void main(String[] args) {
        System.out.println(Test2.string);
    }
}

class  Test2{
    static {
        System.out.println("A");
    }

    {
        System.out.println("U");
    }
    public static final String string="C";
}
