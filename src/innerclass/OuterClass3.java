package innerclass;

// 지역 내부 클래스(Local inner class)
public class OuterClass3 {

    public void display() {
        // 메서드 안에 클래스를 선언
        class LocalInnerClass{
            void printMessage() {
                System.out.println("지역 내부 클래스의 메서드");
            }
        } // end of local inner class

        // 지역 내부 클래스의 인스턴스 생성
        LocalInnerClass innerClass = new LocalInnerClass();
        innerClass.printMessage();
    }
}
