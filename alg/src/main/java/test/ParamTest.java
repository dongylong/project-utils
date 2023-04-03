package test;

public class ParamTest {
    protected int num = 0;

    public void change(int i) {
        i = 5;
    }

    public void change(ParamTest t) {
        ParamTest tmp = new ParamTest();
        tmp.num = 9;
        t = tmp;
    }

    void add(int i) {
        i += 10;
    }


    public void add(ParamTest pt) {
        pt.num = 20;
    }

    public static void main(String[] args) {
        ParamTest t = new ParamTest();
        t.change(t.num);
        System.out.println("赋值之后：" + t.num);
        t.change(t);
        System.out.println("n运算之后：" + t.num);
        t.add(t.num);
        System.out.println("赋引用后：" + t.num);
        t.add(t);
        System.out.println("改属性后：" + t.num);
    }
}
