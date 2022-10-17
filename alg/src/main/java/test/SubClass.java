package test;

public class SubClass extends ParentClass {
    int i = 30;

    public static void main(String[] args) {
        ParentClass parentClass = new ParentClass();
        SubClass subClass = new SubClass();
        System.out.println("subClass.i:"+subClass.i);
        System.out.println("parentClass.i:"+parentClass.i);
        System.out.println(" parentClass.i+subClass.i = "+parentClass.i+subClass.i);
    }

}

class ParentClass {
    public int i = 10;
}