package innerclass;

public class SpaceshipMain {
    public static void main(String[] args) {

        // 정적 내부 클래스라서 바로 생성 가능함
        Spaceship.Engine engine = new Spaceship.Engine();
        Spaceship spaceship = new Spaceship();


        spaceship.addEngin(engine);
        engine.start();
        spaceship.startSpaceship();
    } // end of main

}
