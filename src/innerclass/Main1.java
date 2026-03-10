package innerclass;

public class Main1 {

    public static void main(String[] args) {

        // Outer class --> Inner class --> display() 호출하려면 어떻게 문법을 작성하는가?
        // 주의: 현재 Inner class(인스턴스 내부 클래스이다)
        OuterClass outer = new OuterClass();
        //OuterClass outer;
        //OuterClass.InnerClass inner = outer.new InnerClass();
        //inner.display();

    } // end of main

}
