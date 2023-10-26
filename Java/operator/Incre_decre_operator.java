package Java.operator;

public class Incre_decre_operator {
    public static void main(String[] args) {


        /*
         *
         * 증감 연산자
         * 		++	--
         * 증감 연산자는 변수의 값을 1증가 시키거나 1감소 시킨다
         * 증감 연산자는 단항 연산자다
         * 증감연산자의 사용 예
         *
         * int a = 10;
         * a++;	// 후위형
         *
         * int b = 10;
         * ++b;	// 전위형
         *
         */

        // 증감 연산자를 단독으로 사용하는경우
        int num1 = 10;
        int num2 = 10;

        num1++;
        ++num1;
        System.out.println("num1 의 값 : "+num1);	// 12

        num2--;
        --num2;
        System.out.println("num2 의 값 : "+num2);	// 8


        // 덧셈 연산자와 증감 연산자를 같이 사용 (다른연산자와 증감연산자 함께 사용)

        // 전위형으로 사용하는 경우 - 변수의 값을 증감시키고 , 연산에 사용
        // 후위형으로 사용하는 경우 - 연산에 값을 사용 하고 , 변수의 값을 증감 시킨다
        int num3 = 10;
        int num4 = 10;

        System.out.println("num3 의 값 : "+ ++num3);	// 11  더하고 나서 출력
        // num3의 값을 1증가시킨다
        // num3의 값을 덧셈 연산에 사용한다
        // 결과적으로 num3는 11이 되었다

        System.out.println("num4 의 값 : "+ num4++);	// 10  출력하고 나서 더하기
        // num4의 값을 덧셈 연산에 사용한다
        // num4의 값을 1증가 시킨다
        // 결과적으로 num4는 11이 되었다
    }
}
