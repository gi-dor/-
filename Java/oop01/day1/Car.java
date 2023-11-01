package Java.oop01.day1;

public class Car {
    /*
     * 멤버 변수(필드 , 프로퍼티 , 인스턴스 변수) 정의
     *
     * 자료형 변수명;
     * 자료형 변수명 = 값;
     *
     * 생성된 객체의 고유한 정보를 표현한다.
     */

    int maxSpeed = 200;
    int currentSpeed;

    /**
     * 자동차의 현재 속도를 10 만큼 증가 시킨다.
     */

    // 자동차의 현재 속도를 증가시키는 메서드
    // 반환타입 : 없음
    // 매개변수 : 없음
    // 반환값 : 없음
    void speedUp(){
        currentSpeed += 10;
        if(currentSpeed > maxSpeed){
            currentSpeed = maxSpeed;
        }
    }

    /**
     * 자동차의 현재 속도를 10만큼 감소 시킨다.
     */

    // 자동차의 현재 속도를 감소시키는 메서드
    // 반환타입 : 없음
    // 매개변수 : 없음
    // 반환값 : 없음
    void speedDown(){
        System.out.println("속도를 감소 시킵니다");

        currentSpeed -=10;
        if(currentSpeed < 0){
            currentSpeed = 0;
        }
    }

    /**
     * 자동차의 현재 속도를 콘솔창에 출력한다
     */

    // 자동차의 현재 속도를 화면에 출력하는 메서드
    // 반환값 : 없음
    // 매개변수 : 없음

    void printCurrentSpeed(){
        System.out.println("현재 속도는 "+currentSpeed +" km/h 입니다");
    }

    /**
     * 자동차의 현재 속도를 반환한다.
     * @return 자동차의 현재 속도
     */

    // 자동차의 현재 속도를 반환하는 메서드
    // 반환타입: int
    // 매개변수 : 없음
    int getCurrentSpeed() {
        System.out.println("현재 속도를 반환합니다");

        return currentSpeed;
    }

    /**
     *  지정된 속도로 자동차의 현재속도를 변경한다
     * @param speed 변경할 속도 값
     */

    // 값을 전달받아서 자동차의 현재 속도를 전달받은 값만큼 증가 시키는 메서드
    void changeCurrentSpeed(int speed) {
        System.out.println("현재 속도를 변경 합니다");
        currentSpeed = speed;
    }




    /*
     * 멤버 메서드 (인스턴스 메서드)
     *
     * 반환타입 메서드명(매개변수타입 변수명 , 매개변수타입 변수명,....) {
     *  수행문1;
     *  수행문2;
     *
     *  return 값; // 반환타입이  void인 경우 필요없다,
     *  }
     *  	반환타입 : 매서드를 호출한 측에서 제공받는 반환값의 타입
     *  	반환값이 없는경우 void로 지정
     *  	반환값이 있는 경우 반환값의 타입을 지정
     *  	반환타입은 메서드를 호출하는 측에게 이 메서드 실형결과로 획득되는 값의 타입을 알려줌으로써
     *  	반환 값을 저장할 변수의 타입을 결정할수 있게 결정한다
     *
     *  	메서드명 : 매서드가 수행하는 기능을 표현하는 적절한 이름으로 지정
     *  		식별자 작성 규칙을 따른다
     *
     *  	매개변수 : 메서드를 호출 하는 측이 인자로 전달하는 값을 저장하는 변수
     *  				매개변수의 타입과 이름을 통해 인자로 전달할 값과 값의 타입을 유추 할 수 있게 한다
     *
     *  	수행문 : 메서드의 고유 기능을 수행
     *
     *  	return문 : 메서드의 최종 반환 값을 메서드를 호출한 측에게 반환 한다
     *  	반환타입이 void가 아닌경우 반드시 return 문이 있어야한다
     *  	 *
     */

}
