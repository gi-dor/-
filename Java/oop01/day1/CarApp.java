package Java.oop01.day1;

public class CarApp {
    public static void main(String[] args) {

        Car car = new Car();

        // 현재 속도를 출력
        car.printCurrentSpeed();
        System.out.println();

        // 자동차의 현재 속도를 증가
        car.speedUp();
        car.printCurrentSpeed();
        System.out.println();

        // 현재 속도를 30으로 변경
        car.changeCurrentSpeed(30);
        car.printCurrentSpeed();
        System.out.println();

        // 현재 속도를 조회
        int speed = car.getCurrentSpeed();
        System.out.println("현재 자동차의 속도는  "+ speed + " km/h 입니다.");

        /*
         * changeCurrentSpeed(int Speed) : void - Car
         * 반환값이 없다
         * 메서드 이름은 changeCurrentSpeed
         * 메서드 실행시 전달할 인자 값은 정수형의 속도 값이다
         * car.changeCurrentSpeed(50);
         *
         *
         * speedUp() : void - Car
         * 반환 값이 없다
         * 메서드 이름은 speedUp
         * 메서드 실행시 전달할 인자 값은 없다
         * car.speedUp();
         *
         *
         * printCurrentSpeed() : void - Car
         * 반환 값이 없다
         * 메서드 이름은 printCurrentSpeed
         * 메서드 실행시 전달할 인자 값은 없다
         * car.printCurrentSpeed();
         *
         *
         * getCurrentSpeed() : int - Car
         * 반환 값이 있다 정수 타입의 값을 반환한다, 정수 타입의 변수를 선언해서 값을 저장한다
         * 메서드 이름은 getCurrentSpeed
         * 메서드 실행시 전달할 인자 값은 없다
         * int speed = car.getCurrentSpeed(50);
         *
         *
         */
    }
}
