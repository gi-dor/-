package Java.operator;

public class Conditional_operator {
    public static void main(String[] args) {

        /*
         * 조건 연산자
         * 	조건식 ? 값1 : 값2
         * 	조건식 ?  연산식 1 : 연산식 2
         *
         * 	조건식의 값이
         * 				true로 판정되면 조건 연산자의 최종 결과는 값1 혹은 연산식1
         * 				false로 판정되면 조건 연산자의 최종 결과는 값2 혹은 연산식2
         *
         * 값 1 과 값2의 타입은 같은 타입이다
         * 연산식 1 과 연산식 2 의 결과 값도 같은 타입이다
         */

        // 평균 점수가 60점 이상이면 '합격' 그 외는 '불합격'
        int kor = 80;
        int eng = 60;
        int math = 60;

        int average = ( kor + eng + math ) / 3;

        String result = average >= 60 ? "합격" : "불합격";
        System.out.println("결과 : " + result);


        // 구매 금액이 30 만원 이상인 경우 구매금액의 3%를 적립포인트 지급 , 그외는 1%
        int orderPrice1 = 50_000;
        int orderPrice2 = 300_000;

        // 강제 형변환 했음 bonus 에 ( int )  , bonus2에 결과 값 타입을 double 실수로 받음
        int bonus = orderPrice1 >= 300_000 ? (int)(orderPrice1 * 0.03) : (int)(orderPrice1 * 0.01) ;
        double bonus2 = orderPrice1 >= 300_000 ? orderPrice2 * 0.03 : orderPrice2 * 0.01 ;

        System.out.println("5만원 포인트 : "+bonus);
        System.out.println("30만원 포인트 : "+bonus2);
    }
}
