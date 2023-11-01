package Java.array;

import java.util.Arrays;
import java.util.Scanner;

public class Array07 {
    public static void main(String[] args) {

        /*
         * 임의의 숫자 10 개가 저장되어 있는 배열을 생성하고
         * 복사시작위치 , 복사 종료 위치를 입력받아
         * 원본 배열에서 해담범위의 값을 가져와서 새로운 배열을 생성하기
         */

        // 정수 10개를 저장하는 배열 객체 생성 , 그 객체의 주소값을 numbers 변수에 대입한다
        int [] numbers = new int[10];

        // numbers 배열에 임의의 숫자 집어넣기
        // 임의의 숫자 -> math.random() 사용

        for(int index = 0; index < numbers.length; index++){
            // 1 ~ 100 임의의 정수를 배열에 순서대로 집어넣기
            numbers[index] = (int)(Math.random() * 100 ) +1 ;
        }
        System.out.println(Arrays.toString(numbers));



        // Scanner 객체를 사용해서 시작위치 종료위치 찾기
        Scanner scanner = new Scanner(System.in);

        // 시작위치
        System.out.println("시작위치 인덱스 : ");
        int start = scanner.nextInt();

        // 종료위치
        System.out.println("종료 위치 : ");
        int end = scanner.nextInt();

        // 새로운 배열을 만들어서 시작 위치 ~ 종료 위치까지 복사해서 새로운 배열에 저장하기
        int[] subArr = new int [end - start +1];

        // 원본 배열에서 새배열로 값 복사
        int position = 0;
        for(int index = start; index < end; index++){
            subArr[position] = numbers[index];
            position++;
        }

        // 배열 출력하기 for - each
        for ( int value : subArr){
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
