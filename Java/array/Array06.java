package Java.array;

public class Array06 {
    public static void main(String[] args) {
        // 지정된 배열에 입력한 숫자가 저장된 위치를 알아내기
        // 배열에서 그 값이 저장된 위치를 조사해서 출력
        // 단 , 그값과 일치하는 값이 존재하지 않으면 -1 을 출력


        // 배열
        int []  numbers = {10 , 20 ,300 ,40 , 50 , 60 ,70 };

        // 40 이 저장된 위치를 알아내고싶다.
        int position = -1;
        // -1은 유효한 인덱스가 아니며 "값을 찾지 못했다"고 알리기 위해
        // 배열의 인덱스는 [0] 부터 시작하니깐
        // 값이 없다면 마지막 출력글에 -1 이 출력이됨.

        for(int index = 0; index < numbers.length; index++) {
            if(numbers[index] == 40) {
                // if문 조건으로 40 이라는 숫자가 배열내에 존재한다면 실행된다
                position = index;
                // 40 이라는 값이 해당 인덱스에 존재한다면 position 변수에 담는다
                break;  // 이후에 배열에서 주어진 40 이라는 같은 값이 있을수 있으니 break문 걸음
            }
        }

        System.out.println("위치 : "+position);
    }
}
