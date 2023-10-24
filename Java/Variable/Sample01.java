package Java.Variable;

public class Sample01 {
    public static void main(String[] args) {


        // 변수 생성
        /*
         * 자료형 변수명 ;
         *
         * Ex. )
         * int num1;
         * long num2;
         * boolean isPassed;
         * char ch1;
         * char c2;
         *
         *
         * 변수를 정의하면 메모리에 저징된 자료형 만큼 맞는 공간이 할당되고 ,
         * 할당된 공건 (저장소)는 변수명으로 액세스 할 수 있다.
         *
         */

        // 변수 생성
        int a; 	// 메모리에 정수를 저장할수 있는 공간이 확보가 되고 , 그 저장소를
        // a라는 변수명으로 액세스 할수 있다.


        // 초기화 하지 않은 변수는 출력이나 연산에 사용 할수가 없다
//		System.out.println(a);
//		The local variable a may not have been initialized at variable.Sample01.main(Sample01.java:29

        a = 100;	// 변수 a에 값을 대입 , 대입 / 저장하는 것을 우리는 '변수를 초기화 한다' 라고 한다.
        System.out.println("a = " + a);

    }
}
