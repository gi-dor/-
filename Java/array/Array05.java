package Java.array;

import java.util.Arrays;
import java.util.Scanner;

public class Array05 {
    public static void main(String[] args) {

        // 임의의 정수 값을 여러개 입력받아서  그중애서 가장 큰 값을 찾기
        // 키보드를 이용해 정수 10개를 입력받어


        Scanner scanner = new Scanner(System.in);

        //  정수 10 개를 저장할 배열객체 생성저장
        int [] numbers = new int[5];



        // 반복문을 사용햐 숫자를 입력받기
        for(int index = 0; index < 5 ; index++) {
            // 변수 index를 0 으로 초기화해서 배열의 위치나 인덱스를 나타냄 배열의 첫번쨰 요소 0 을 뜻함
            System.out.print( "숫자입력  :  "  );
            numbers[index] = scanner.nextInt() ;
            // 사용자가 입력한 숫자를 number배열에  index에 저장하는데
            // index가 0으로 시작했기에
            // numbers[0] = '사용자가 입력한 숫자' 를 뜻함

            System.out.println(Arrays.toString(numbers));
            // numbers 배열의 모든 요소를 문자열 형태로 출력하는데
            // [ 0,0,0,0,0]

            // 이걸 총 numbers[0]부터 numbers[0],[1],[2],[3],[4] 까지 실행함
        }

        // 배열에 저장된 값 중에서 최대값 찾기
        int max = Integer.MIN_VALUE;
        // Integer.MIN_VALUE는 int 타입에서 표현할 수 있는 가장 작은 값을 의미한다고 한다.


        for(int value : numbers) {
            //향상된 for문" 또는 "for-each문
            // numbers 배열의 모든 요소를 순서대로 value에 담는다
            if (max < value) {
                // 첫번째 요소 numbers[0]보다 max라는 값보다 많으면
                max = value;
                // 그 값을 max에 대입
                // 반대로 value값보다 max가 크다면 if문이 false가 되어 다시 반복문을 실행한다.
                // 초기에 max를 Integer.MIN_VALUE를 사용 했는데 int 타입에서 가장 작은 값을뜻한다
                // numbers[0]이 어떤 숫자이든 max가 작을 수 밖에없다
            }
        }

        System.out.println("최대값 : "+max);




        scanner.close();


    }
}
