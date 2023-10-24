package Java.Variable;

public class Sample07 {
    public static void main(String[] args) {
        		/*
		 * 자바의 연산원칙
		 * 	자바의 연산은 같은 타입끼리만 가능하다
		 * 	자바의 연산은 연산에 참여한 값의 타입과 연산결과가 항상 동일한 타입이다
		 * 자바의 연산에 참여하는 값의 타입이 서로 다른경우 , 같은 타입으로 변환 후 연산이 일어난다.
		 *
		 * 12 / 5 => 2   정수 / 정수 = > 정수
		 * 12.0 / 5.0 => 2.4  실수 / 실수 => 실수
		 *
		 * 12 / 5.0 => ??   12.0 / 5.0 => 2.4
		 * 12 정수와 5.0 실수 , 정수와 실수 어떤거로 바뀔까 ?
		 * 사실 정수로 변환 되지는 않는다 정수는 4byte (기본 int) 실수는 8byte (기본 double) 8->4로 변하면 byte 즉 데이터의 손실이 생기기에
		 * 데이터의 손실이없는 4 -> 8 로 변한다.
		 * 그래서 4 byte 에서 8byte인 int 에서 double로 바뀐 12.0 / 5.0
		 *
		 * 기본자료형의 형변환
		 *
		 * ① 자동 형변환
     		데이터의 손실이 발생하지 않는 방향으로의 형변환은 컴파일러가 자동으로 처리한다

		   ② 강제형변환
		    데이터의 손실이 발생하는 방향으로의 형변환은 자동으로 일어나지 않기 때문에
		    개발자가 강제로 형변환 방향을 지정하는 것이다.
		 */

        // 연산에 참여한 값의 타입과 연산결과는 동일하다.
        System.out.println(10 / 3);
        System.out.println(10.0 / 3.0);

        // 연산에 참여한 값의 타입이 서로 다른경우 같은 타입으로 변환후 연산이 일어난다
        // 형변환 방향은 더 큰 데이터 타입 혹은 정밀도가 더 높은 타입으로 변환한다.
        // 정수 / 실수 -> 실수 / 실수 ----> 실수

        System.out.println(12 / 5.0); // 12 / 5.0 ->>>  12.0 / 5.0  ---- 2.4
        System.out.println(12.0 / 5); // 12.0 / 5 ->>> 12.0 / 5.0  ---- 2.4


        // 연산에 참여하는 변수의 타입과 값의 타입이 서로 다른 경우
        // 값의 타입을 변수의 타입과 같은 타입으로 변환 한 뒤에 연산이 실행된다.

        double d1 = 3; // 실수 타입인데 값이 정수 ?
        // double d1 = 3.0 으로 데이터 손실 없이 바뀐다.
        System.out.println("d1 : "+d1);

        // int num2 = 3.4;  Type mismatch: cannot convert from double to int
        // 변수 타입이 int 인데 값의 타입이 double 이다
        // 변수의 타입과 같은 타입으로 값을 변환하면 데이터의 손실이 발생함
        // 자동형변환이 일어날수 없기 때문에 오류가 발생

        // 강제 형변환

        int num3 = (int) 3.14;
        System.out.println("강제 형변환 : "+num3);


        int kor = 80;
        int eng = 70;
        int math = 70;
        int subCount = 3;

        int total = kor + eng + math;
        double avg = (double)total / subCount ;

        System.out.println("평균: "+avg);


    }
}
