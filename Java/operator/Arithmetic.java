package Java.operator;

public class Arithmetic {
    public static void main(String[] args) {

        /*
		 * 산술 연산자
		 *  	+  -  *  /  %
		 * 	% 나머지 연산자 , 나누기 연산이후 발생한 나머지를 반환한다
		 * 나머지의 연산결과는 항상 0 ~ ( 나누는수 -1 )  3%2 = ?   2가 나누는수 2-1 = 1   연산결과 :0 ~ 1
		 *
		 * 산술연산자는 정수 혹은 실수에 대한 산술 연산을 수행한다.
			산술연산자는 연산에 참여한 값의 타입과 동일한 타입의 연산결과를 제공한다
			덧셈 연산자는 2가지 용도로 활용한다

			1 ) 숫자 + 숫자 → 덧셈 연산  Ex ) 1 + 3 →  4 // 1.2 + 3.0 →  3.2
			2 - 1) 숫자 + 문자열 →  이어 붙이기 , 결과는 문자열 2 + "abc" → "2abc"
			2 - 2) 문자열 + 숫자 → 이어 붙이기 , 결과는 문자열 "abc" + 2 → "abc2"
			2 - 3) 문자열 + 문자열 →  이어 붙이기 결과는 문자열 "abc" + "def" → "abcdef
		 *
		 */
        // 숫자끼리 산술연산
        int num1 = 30;
        int num2 = 4;

        System.out.println(num1 + num2); // 34 출력
        System.out.println(num1 - num2); // 26 출력
        System.out.println(num1*num2); 	 // 120 출력
        System.out.println(num1/num2);	 // 7 출력 , int 타입이라 7.5가 아닌 7 정수가 출력
        System.out.println(num1%num2);   // 2 출력

        // 숫자와 문자의 산술연산
        int num3 = 3;
        char c1 ='A';

        // 정수 + 문자 -> 정수 + 정수로  변환 후 산술연산이 실행된다,
        System.out.println(num3 + c1);	//'3' + 'A' -> 3 + 65 -> 68 출력
        System.out.println((char)(num3 + c1)); // 68 을 문자로@,,

        // 숫자와 문자열의 덧셈연산
        System.out.println("abc" + 1); // "abc1"
        System.out.println(1 + "abc");	// "1abc"
        System.out.println("abc" + "def");	// "abcdef"
        System.out.println(1 + 2 + 3 + "abc" + 4 + 5);// "6abc45"
        // 1 + 2 + 3 +"abc" + 4 +5
        // 6 + "abc" + 4 + 5
        // "6abc"+ 4 + 5
        // "6abc4" + 5
        // "6abc45"

    }
}
