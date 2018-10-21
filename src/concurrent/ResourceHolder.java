package concurrent;

public class ResourceHolder {
    private static class R{
        static {
            System.out.println(1);
        }
        public static TestHarness testHarness = new TestHarness();
    }

    public static TestHarness getT(){
        return R.testHarness;
    }

    public static void main(String[] args) {
        TestHarness o = R.testHarness;
        TestHarness w = R.testHarness;
        TestHarness e = R.testHarness;
        TestHarness t = R.testHarness;
    }
}
