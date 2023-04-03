package test;

public class InitialOrderTest {

    public static String staticField = "静态变业";
    public String field = "变量";

    static {
        System.out.println(staticField);
    }

    {
        System.out.println(field);
    }

    //构造器
    public InitialOrderTest() {
        System.out.println("枸造器");
    }

    public static void main(String[] args) {
        new InitialOrderTest();
    }
}
