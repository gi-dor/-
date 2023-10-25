package Java.control;

public class If_else01 {
    public static void main(String[] args) {
        /*
         *  if ~ else 문
         *
         *  if(조건문){
         *  	수행문 // 조건식이 true 일시 실행
         *  	수행문
         *  } else {
         *  	 수행문	//조건식이 false 일경우 실행
         *  }
         *
         */


        // 주차비 정산 시스템
        // 주차비는 시간당 3000원이다.
        // 차량 배기량을 기준으로 900cc 미만은 50% 할인이 적용된다.

        // 1. 900 이상이면 시간당 3000원
        // 2. 900 미만은 시간당 1500원

        int engine = 1000;  	// 1000cc
        int hours = 3;			// 3시간 주차
        int payPerHour = 3000;	// 시간당 3000원

        int payAmount = 0;


        if(engine < 900) {
            payAmount = payPerHour * hours  / 2;
        }else {
            payAmount = payPerHour * hours;
        }

        System.out.println("계산 할 요금 : "+payAmount +"원");
    }
}
