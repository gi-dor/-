package Java.operator;

public class Assignment_operator {
    public static void main(String[] args) {

        /*
         * 대입 연산자 : 변수의 값을 새로운 값으로 변경
         * 		=
         *
         * 복합 대입 연산자 : 변수에 저장된 원래의 값을 활용한다
         * 	+=  	-=		 *=	 	/=		 %=
         *
         * 대입 연산자는 우항의 값을 좌항의 변수에 대입한다
         * 복합 대입 연산자는 대입하기 전에 변수의 값을 대상으로 정해진 산술연산을 수행하고, 그 결과를 대입한다
         * 대입 연산자는 모든 연산자 중에서 우선순위가 가장 낮은 연산자다
         *
         */


        // 변수를 생성하고 값을 변수에 대입한다
        int num1 = 10;
        int num2 = 20;
        System.out.println("생성후 대입 : "+num1);
        System.out.println("생성후 대입 : "+num2);

        // 기존에 있던 변수에 값을 대입한다

        num1 = 30;
        num2 = 50;
        System.out.println("기존 변수에 대입 :"+num1);
        System.out.println("기존 변수에 대입 :"+num2);

        // 복합 대입 연산자의 활용
        // 변수의 값을 10 증가
        // 변수의 값을 20 감소

        num1 += 10;
//		num1 = num1+10; 과 동일
        System.out.println("num1 += 10 : "+ num1);

        num2 -= 20;
//		num2 = num2 - 20; 과 동일
        System.out.println("num2 -= 20 : "+num2);
    }
}
