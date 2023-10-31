package Java.array;

import java.util.Scanner;

public class Array06_01 {
    public static void main(String[] args) {
        int[] arr = {3,13,19,20,25,29};

        Scanner scanner = new Scanner(System.in);
        System.out.println("찾고자 하는 숫자 : ");

        // 내가 찾으려 하는 숫자를 target에 담음
        int target = scanner.nextInt();

        // 내가 입력한 숫자가 배열에 없다면 -1 을
        int position = -1;

        for(int index = 0; index < arr.length; index++) {
            // index는 해당위치 - 배열위치
            // target은 내가 입력한 숫자
            if(arr[index] == target) {
                position = index;
                // 뒤에 같은 숫자 있으면 뒤에 숫자를 출력한다고 함 그래서 break;걸음
                break;
            }
        }

        if (position != -1) {
            System.out.println(target + " 의 위치는 배열의 "+ position + " 번 인덱스" );
        }else {
            System.out.println(target + " 이 배열에 존재하지 않습니다.");
        }


        scanner.close();
    }
}
