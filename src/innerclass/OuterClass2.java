package innerclass;

public class OuterClass2 {

    private static int num = 10;

    // 클래스파일 안에 내부에 또 클래스 선언(중첩클래스) - 인스턴스 내부 클래스
    static class InnerClass {

        public void display() {
            System.out.println("num: " + num);
        }
    } // end of inner class

} // end of outer class
