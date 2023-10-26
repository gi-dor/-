package Java.operator;

public class Logical_operator {
    public static void main(String[] args) {
	/*
		 * 논리 연산자
		 * 	&&	||	!
		 *
		 * 논리 연산자의 연산 대상은 boolearn 값이다
		 * 변수의 값이 boolean 형이거나 연산식의 연산 결과가 boolean 형이다
		 * 논리 연산자의 좌항과 우항에는 비교 연산식이 위치한다
		 * 논리 연산자를 이용하면 복잡한 개발 요구사항을 체크 할 수 있다
		 * 논리 연산자 중에서 ! 는 논리 부정 연산자
		 *
		 *
		 * // 장학금 지급 여부 판단
			boolean isPassed = average >= 60;
			boolean result = isPassed && average >= 95;

			// 이벤트 상품 지급여부 판단하기
		 *	// 구매 금액이 10만원 이상 이거나 당일 100 * n 번째 방문자면 사은품 지급대상
		 *
		 *	int orderPrice = 70000;	// 구매 금액
		 *	int visitCount = 2500;	// 오늘 2500번째 방문자
		 *  boolean result = orderPrice >= 100_000 || visitCount % 100 == 0;
		 *
		 *  구매금액은 부족하지만 100 * n번째 방문자에 충족한다.
		 *
		 * 논리 연산자의 && 와 || 동작 특성
		 * && : 좌항의 값이 false 면 우항의 값을 확인하지 않고 연산결과를 false  확정
		 * || : 좌항의 값이 true면 우항의 값을 확인하지 않고 연산결과를 true로 확정
		 *
		 *
		 */

        // 이벤트 상품 지급여부 판단하기
        // 구매 금액이 10만원 이상 이거나 당일 100 * n 번째 방문자면 사은품 지급대상

        int orderPrice = 70000;	// 구매 금액
        int visitCount = 270;	// 오늘 270번째 방문자
        boolean result = orderPrice >= 100_000 || visitCount % 100 == 0;

        System.out.println("사은품 지급여부 : " + result);

        int orderPrice2 = 150_000;	// 구매 금액
        int visitCount2 = 290;	// 오늘 270번째 방문자
        boolean result2 = orderPrice2 >= 100_000 || visitCount2 % 100 == 0;

        System.out.println("사은품 지급여부 : " + result2);


        boolean b1 = true;
        System.out.println(b1);
        System.out.println(!b1);
        System.out.println(!!b1);

        int distance = 35000;
        int useYear = 3;

        boolean result3 = distance > 50000 | useYear >= 3;
        System.out.println("유상 수리 여부 : " + result3);


    }
}
