package Java.inner;

public class Sample1 {
    private int value1;
    static int value2;

    public void method() {

    }

    public static void method2() {

    }

    public Inner1 getInner1() {
        Inner1 inner1 = new Inner1();
        return inner1;
    }

    /*
     * 멤버 내부클래스
     * 	- 객체 생성 후 사용 가능한 내부클래스
     * 	- 외부 클래스의 모든 변수 - 멤버변수 , 정적변수
     * 	- 				모든 메서드 - 멤버 , 정적메서드를 사용할 수 있다
     */

    class Inner1{
        /*
         * 멤버 내부클래스에서는 외부 클래스의 모든 변수 , 모든 메서드를 자유롭게 사용할 수 있다.
         */

        public void method() {
            System.out.println(value1);
            System.out.println(value2);
            method();
            method2();
        }
    }

}
