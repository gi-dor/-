package Java.control;

public class IfApp01 {
    public static void main(String[] args) {

        /*
         * if 문
         *  	if (조건식){
         *  			수행문;
         *  			수행문;
         *  			수행문;
         *  		}
         *
         * 조건식은 수행결과가 boolean 값이거나 연산결과가 boolean
         *
         */


        // 모두의 마블
        // 1. 게임 규칙 : 주사위 숫자가 2개 모두 같은 숫자가 나오면 감옥에서 탈출한다.

        // 1 ~ 6 범위내의 임의의 정수가 나오게 하기
        // 0 <= Math.random() < 1
        System.out.println("Math.random() 범위 : 0 <= x < 1");
        System.out.println(Math.random());
        System.out.println(Math.random());
        System.out.println();


        // 0*6 <= Math.random()*6 < 1 * 6
        // 0 <= Math.random() *6 < 6
        System.out.println("Math.random() 범위 :  0 ~ 5");
        System.out.println((int)( Math.random() * 6 ));
        System.out.println((int)( Math.random() * 6 ));
        System.out.println();


        // 0 +1 <= Math.random() * 6 +1 < 1 * 6 +1
        // 1 <= Math.random() *6 +1 < 7
        System.out.println("Math.random() 범위 :  1 ~ 6");
        System.out.println((int)( Math.random() * 6 ) + 1);
        System.out.println((int)( Math.random() * 6 ) + 1);
        System.out.println();


        int dice1 = (int)(Math.random()*6 )+1;
        int dice2 = (int)(Math.random()*6 )+1;

        System.out.println("첫번째 주사위 숫자 : " + dice1);
        System.out.println("두번째 주사위 숫자 : " + dice2);


        if (dice1 == dice2 ) {
            System.out.println("감옥을 탈출 했습니다.");
        }
    }
}
