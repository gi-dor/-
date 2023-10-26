package Java.control;

public class If_elseif_else {
    public static void main(String[] args) {
        	/*
		 if (조건식1) {
				// 조건식1이 true로 판정되면 블록내의 수행문이 실행된다.
			} else if (조건식2) {
				// 조건식2가 true로 판정되면 블록내의 수행문이 실행된다.
			} else if (조건식3) {
				// 조건식3이 true로 판정되면 블록내의 수행문이 실행된다.
			} else {
				// 위에서 제시한 조건식1, 조건식2, 조건식3이 전부 false로 판정되면 블록내의 수행문이 실행된다.
			}

		*/


        // 구매 금액에 따른 적립포인트 계산하기

        // 구매 금액이 100만원 이상 5 % 적립
        // 구매 금액이 50만원 이상 2 % 적립
        // 구매 금액이 30만원 이상 1 % 적립
        // 구매 금액이 10만원 이상 0.3 % 적립
        // 그외는 0,1 %


        // point - 구매금액
        // 구매 금액을 변수로

        int orderPrice = 1_200_000;	// 구매에 사용한 금액
        int point = 0; // 현재 적립 포인트
        // int point; 하게 되면 62번 라인에서 초기화가됨


        if(orderPrice >= 1_000_000) {
            point = (int)(orderPrice * 0.05); 	// Type mismatch: cannot convert from double to int
        } else  if (orderPrice >= 500_000) {
            point = (int)(orderPrice * 0.02);
        } else if ( orderPrice >= 300_000) {
            point = (int)(orderPrice * 0.01);
        } else if ( orderPrice >= 100_000) {
            point = (int)(orderPrice * 0.003);
        }
        System.out.println("구매 금액 : " + orderPrice);
        System.out.println("적립 포인트 : " + point);


        // 그외 0.1%를 초기화 값으로 줘버림
        // depositRate = 0.0 으로 설정하고 0.01  else 문 추가해도됨
        double depositRate = 0.01;	// 적립 계산
        // double depositRate; 선언만 하게되면 초기화가되지 않아 사용 할 수가 없다.

        if(orderPrice >= 1_000_000) {
            depositRate = 0.05;
        } else  if (orderPrice >= 500_000) {
            depositRate = 0.02;
        } else if ( orderPrice >= 300_000) {
            depositRate = 0.01;
        } else if ( orderPrice >= 100_000) {
            depositRate = 0.003;
        }

        point = (int)(orderPrice * depositRate);
        System.out.println("적립 포인트 2 : " + point);

    }
}
