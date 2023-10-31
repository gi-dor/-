package Java.array;

public class Array02 {
    public static void main(String[] args) {

        /*
         * 배열 액세스 하기
         * 		배열의 각저장소에 액세스는 배열의 인덱스를 이용한다.
         *
         *
         * - 배열에 값 저장하기
         *         참조변수명[인덱스] = 값 ;
         *
         * - 배열에 저장된 값 사용하기
         *         System.out.println(참조변수명[인덱스]);
         *
         * - 배열의 길이 조회하기
         * 			참조변수명.length;
         * 			배열객체에는 length 라는 프로퍼티가 있다
         *
         *         프로퍼티 ?
         *         객체의 구성요소 , 객체의 고유한 값을 저장하고 있다.
         */


        // new 키워드를 사용해서 빈 배열객체 생성
        // 빈 배열객체의 각 저장소에는 저장된 타입의 기본값으로 초기화
        int [] arr1 = new int[3];
        double [] arr2 = new double[3];
        String [] arr3 = new String[3];


        // 배열에 길이 ( length ) 조회하기
        System.out.println("arr1 배열의 길이 : "+ arr1.length);
        System.out.println("arr2 배열의 길이 : "+ arr2.length);
        System.out.println("arr3 배열의 길이 : "+ arr3.length);






        // 배열객체 n번째 저장소(index)에 값 저장하기
        arr1[0] = 10;
        arr2[0]	= 2.8;
        arr3[0] = "나타";

        arr1[1] = 18;
        arr2[1] = 10.19;
        arr3[1] = "다산";

        arr1[2] = 12;
        arr2[2] = 1.15;
        arr3[2] = "대구";

        // 객체의 각 저장소의 값을 확인하기
        System.out.println("arr1[0] "+arr1[0]);
        System.out.println("arr1[1] "+arr1[1]);
        System.out.println("arr1[2] "+arr1[2]);


        System.out.println("arr2[0] " +arr2[0]);
        System.out.println("arr2[1] " +arr2[1]);
        System.out.println("arr2[2] " +arr2[2]);

        System.out.println(arr3[0]);
        System.out.println(arr3[1]);
        System.out.println(arr3[2]);
    }
}
