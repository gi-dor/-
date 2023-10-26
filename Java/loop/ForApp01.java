package Java.loop;

public class ForApp01 {
    public static void main(String[] args) {
        /*
         * for 문
         * 		지정된 반복횟수 만큼 블럭내 수행문을 반복수행한다
         *
         * for (초기식; 조건식; 증감식;) {
         *  	수행문;
         * 		수행문;
         *  }
         *
         * 반복 횟수는 초기식 , 조건식 , 증감식 을 이용해 지정
         *
         * 실행순서
         *
         *					   <----- 증감식 <------
         *						| 					|
         * 			초기식 -> 조건식 -> 수행문 ----->
         *
         *
         * for문의 초기식에서 생성한 변수는 조건식 , 증감식 , 블럭 내에 수행문에서만 사용가능하다
         *	for문의 초기식 , 조건식 증감식은 생략 가능하다
         *
         */

        // 지정된 수행문을 5번 실행하는 for문

        for( int i = 1; i <= 5; i++) {
            System.out.println("i의 값 " +i);
        }

        // 생략 ver

        int a = 1;
        for(; a<= 5; a++) {
            System.out.println("a의 값 : "+a);
        }

        int b = 1;
        for(; b <= 5;) {
            System.out.println("b의 값 : "+b);
            b++;
        }

        // for문 무한반복
        for (;;) {
            System.out.println("무한반복 a : " + a);
            System.out.println("무한반복 b : " + b);
        }

    }
}
