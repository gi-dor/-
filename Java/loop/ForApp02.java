package Java.loop;

public class ForApp02 {

    public static void main(String[] args) {

        // 1 ~ 100 까지 정수의 합을 계산하기

        // 정수의 합을 담을 변수 sum 초기화
        int sum = 0;


        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1 ~ 100 까지의 정수의 합 : " +sum);

        // 1 ~ 100 까지 정수중에서 짝수의 합을 계산하기

        int doubleSum = 0;
        for ( int i = 2; i <= 100; i += 2) {
            doubleSum += i;
        }

        System.out.println("1 ~ 100 까지의 정수중 짝수의 합 : " + doubleSum);


        // 1 ~ 100 까지의 정수 중에서 홀수의 합을 계산

        int oddSum = 0;
        for( int i = 1; i <= 100; i++ ) {
            if(i%2 == 1) {
                oddSum += i;
            }
        }
        System.out.println("1 ~ 100 까지의 정수  홀수의 합 : "+ oddSum);

    }
}
