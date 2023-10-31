package Java.array;

public class Array04 {
    public static void main(String[] args) {
        /*
         * 배열과 관련된 오류내용 확인하기
         *
         */

        int [] arr1 = { 10 , 20 , 30 };

        System.out.println(arr1[0]);
        System.out.println(arr1[1]);
        System.out.println(arr1[2]);
//		System.out.println(arr1[3]); // 예외 발생


        if (arr1 != null) {
            System.out.println("arr.length의 값 : " + arr1.length);
        }


        // 이름이 main인 쓰레드에 오류
        //
        /*Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException:
         * Index 3 out of bounds for length 3 at array.Array04.main(Array04.java:18)
         *
         * 배열의 길이를 arr1[0] ~ arr[2] 까지만 존재하기 때문에
         */
    }
}
