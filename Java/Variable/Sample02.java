package Java.Variable;

public class Sample02 {
    public static void main(String[] args) {

        /*
         * 정수형
         *  byte , short , int , long
         *
         * 정수 자료형의 기본 자료형은 int가 default다
         * 대부분의 프로그램에서 정수 값은 int 범위내에 속하기 때문
         * 특별한 경우가 아니라면 정수를 저장하는 변수는 int 타입으로 생성한다.
         * ( byte 타입은 입출력에서 바이너리 데이터를 다룰 때 사용 한다. )
         * (long 타입은 int 범위를 초과하는 정수값을 다룰 때 사용 한다 대표 적으로 은행 예금의 잔액에 쓰인다
         */

        int num1 = 100;			// 양의 정수값 저장
        int num2 = -100;		// 음의 정수값 저장
        int num3 = 100_000_000;	// 자릿수를 표현하는 정수값을 저장
        int num4 = 010;		// 8진법으로 표현된 정수 값을 저장
        int num5 = 0x10;		// 16진법으로 표현ㅈ된 정수 값을 저장

        System.out.println("num1 의 값 : "+num1);
        System.out.println("num2 의 값 : "+num2);
        System.out.println("num3 의 값 : "+num3);
        System.out.println("num4 의 값 : "+num4);
        System.out.println("num5 의 값 : "+num5);

        // int 범위를 초과하는 정수값의 저장 및 출력
        // 정수값이 int의 범위를 초과하는 경우, long 타입의 변수에 저장해야 한다
        // 정수값이 int의 범위를 초과하는 경우, 정수값 끝에 L 혹은 l을 붙인다
        long num6 = 10_000_000_000L;
        System.out.println("num6의 값 : " + num6);

        // 계산의 결과가 int 범위를 초과하는 경우
        int num7 = 123456789;
        int num8 = 123;
        int num9 = num7 * num8;
        System.out.println("num9의 값 : " + num9);

        long num10 = num7 * num8;
        System.out.println("long num10 의 값 : "+ num10);
        // long 타입으로 바꿔줬는데 왜 같은 값인 - 1994684137  num9 의 값과 같은거지 ?

        long num11 = (long)num7 * num8;
        System.out.println("num11의 값 : "+num11);



    }
}
