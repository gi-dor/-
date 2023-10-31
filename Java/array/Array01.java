package Java.array;

import java.security.spec.RSAOtherPrimeInfo;

public class Array01 {
    public static void main(String[] args) {

        //		같은 타입의 값을 여러개 연속적으로 저장하는 객체다
        //		배열 객체의 각 칸에는 0 부터 시작하는 index 가 자동으로 부여 된다.
        //		배열객체의 각 칸은 해당 타입의 기본값으로 자동으로 초기화된다.
        //		Java의 배열은 한번 정해진 크기를 변경할 수 없다.
        //							(배열을 생성할 때 크기를 반드시 지정하거나 , 배열에 저장할 값을 구체적으로 나열해야 한다)

		/*
		// 배열생성

		// 배열의 리터럴을 사용해 배열객체 생성하기
		int [] arr = { 10 , 20 , 30 };
		double [] arr1 = { 0.2 , 7.8 , 2.2 , 8.5 };
		String [] arr2 = {"가네샤","하누만","나타"};

		// new 키워드를 사용해 빈 배열객체 생성
		// 배열 크기 생략 불가
		int [] arr1 = new int[5];
		double [] arr2 = new double[4];
		String [] arr3 = new String[2];

		*/


        int [] arr1 = { 10 , 20 , 30 , 40 , 70 };
        System.out.println("첫번째 배열객체 : "+arr1);
        // 첫번째 배열객체 : [I@3d012ddd    <--- 해시 코드 값

        /*
        [: 배열
        I: int 타입
        @: 구분자
        682a0b20: 배열 객체의 해시코드를 16진수로
         */

        for(int val : arr1) {
            System.out.print(val + " ");
        }
        System.out.println();




        String [] arr2 = { "서울" , "대구" , "부산" };
        System.out.println("첫번째 배열객체 : "+arr2);
        // 첫번째 배열객체 : [Ljava.lang.String;@214c265e

        // new 키워드로 배열 생성
        int [] arr3 = new int[3];	// 정수 3개 담을수 있는 빈 배열객체를 생성하고 그 주소값을 arr3에 대입
        double [] arr4 = new double[4];	// 실수 4개 담을수 있는 빈 배열객체를 생성하고 그 주소값을 arr4에 대입
        String [] arr5 = new String[5];	// 문자열 5개 담을수 있는 배열객체를 생성하고 그 주소값을 arr5에 대입

        // new 키워드를 사용해서 값을 가지는 배열객체 생성
        int [] arr6 = new int[] {10 , 20 , 30};
        double [] arr7 = new double[] {3.14 , 2.76 , 12.25};
        String [] arr8 = new String[] {"하남","구리","다산"};


    }
}
