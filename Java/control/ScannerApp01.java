package Java.control;

import java.util.Scanner;

public class ScannerApp01 {
    public static void main(String[] args) {

        /*
         * Scanner
         * 		값을 읽어오는 기능을 제공한다.
         * 		java.base  모듈의 java.util 패키지에 위치하는 클래스
         *
         * 	next() : 입력한 값을 문자열로 제공하는 기능이다
         * 	nextInt() : 입력한 값을 정수로 제공하는 기능이다
         * 	nextDouble() : 입력한 값을 실수로 제공하는 기능이다
         */



        /*
         * 두 수를 입력받아서 더 큰수를 출력하기
         *
         */



        // new Scanner (System.in);
        // 표준 입력장치인 키보드에서 입력한 내용을 읽어온다

        Scanner scanner = new Scanner(System.in);
        // Resource leak: 'scanner' is never closed /// 자원의 누수가 ? 발생


        // 입력값을 읽어서 정수값으로 변환
        System.out.print("첫번째 숫자 입력: " );
        int num1 = scanner.nextInt();

        System.out.print("두번째 숫자 입력: " );
        int num2 = scanner.nextInt();

        System.out.println("첫번째 정수 : " + num1);
        System.out.println("두번째 정수 : " + num2);

        if ( num1 > num2 ) {
            System.out.println("큰 수 : " +num1);
        } else if (num1 < num2) {
            System.out.println("큰 수 : "+num2);
        } else if( num1 == num2) {
            System.out.println("두 숫자가 같습니다");
        }






        scanner.close();
    }
}
