package Java.exception.exception1;

public class App6 {

    public static void main(String[] args) {

//        String str = "1234가";
        String str = "1";

        int num = Integer.parseInt(str);

        // Integer.parseInt(str); 로인해 문자열을 정수형으로 바꿔야하는데 "가" 로 인해 형변환이 안됨

        System.out.println("변환된 숫자 : " + num);

        int start = (num - 1) * 10 + 1;
        int end = num * 10;

        System.out.println("조회 시작 : " + start);
        System.out.println("조회 종료 : " + end);

        /*
            NumberFormatException
            숫자가 아닌 문자를 포함하고 있는 텍스트를 숫자로 변환 할 때 발생하는 예외
            NumberFormatException은  UncheckedException이다
         */
    }
}
