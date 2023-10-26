package Java.operator;

public class Bit_operator {
    public static void main(String[] args) {

        /*
         * 비트 연산자
         * 	&	^	|
         *
         * 비트 연산자는 연산자의 좌항과 우항의 값이 숫자 값이다.
         * 비트 연산자는 좌항과 우항의 값을 비트 단위로 논리 연산한다
         *
         *
         * 		& ( AND 연산 ): 피연산자 양 쪽의 값이 모두 1일 때 1이다. 그외는 0 이다.
         * 			3 & 5
         * 				3 -> 00000011
         * 				5 -> 00000101
         * 				--------------
         * 					 00000001
         * 		| ( OR 연산 ): 피연산자 중 한 쪽의 값이 1이면 1이다. 그외는 0 이다.
         * 			3 | 5
         * 				3 -> 00000011
         * 				5 -> 00000101
         * 				--------------
         * 					 00000111
         *		^ ( XOR 연산 ): 피연산자의 값이 서로 다를 때 1이다. 같으면 0 이다.
         *			3 ^ 5
         *				3 -> 00000011
         * 				5 -> 00000101
         * 				--------------
         *					 00000110
         *
         *		~(보수 연산) : 피연산자의 값이 0 이면 1 ,  1 이면 0 이다.
         *			~3
         *			3 -> 00000011
         *			------------------
         *				 11111100
         *
         *
         *		쉬프트 연산자
         *		<<  >>  >>>
         *
         *		<<
         *				x << y
         *					정수 x의 각 비트를 y만큼 왼쪽으로 이동 ( 빈 자리는 0 으로 채움 )
         *
         *		>>
         *				x >> y
         *					정수 x의 각 비트를 y만큼 오른쪽으로 이동 ( 빈 자리는 부호비트와 같은 값으로 채움)
         *
         *		>>>
         *				x >>> y
         *					정수 x의 각 비트를 y만큼 오른쪽으로 이동 시킨다 ( 빈 자리는 0 으로 채운다 )
         *
         */

        int num1 = 17;
        int num2 = 28;
        System.out.println("num1의 값 : "+num1);
        System.out.println("num2의 값 : "+num2);

        System.out.println("num1에 대한 이진 수 값 : "+Integer.toBinaryString(num1));
        System.out.println("num2에 대한 이진 수 값 : "+Integer.toBinaryString(num2));
        System.out.println();
        int num3 = num1 & num2;
        int num4 = num1 | num2;
        int num5 = num1^num2;
        int num6 = ~num1;


        System.out.println("num3 의 값 : "+ num3);
        System.out.println("num3에 대한 이진 수 값 : "+ Integer.toBinaryString(num3));
        System.out.println();

        System.out.println("num4 의 값 : "+ num4);
        System.out.println("num4에 대한 이진 수 값 : "+ Integer.toBinaryString(num4));
        System.out.println();

        System.out.println("num5 의 값 : "+ num5);
        System.out.println("num5에 대한 이진 수 값 : "+ Integer.toBinaryString(num5));

        System.out.println("num6 의 값 : "+ num6);
        System.out.println("num5에 대한 이진 수 값 : "+ Integer.toBinaryString(num6));
    }
}
