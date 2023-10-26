package Java.loop;

public class GuguApp01 {
    public static void main(String[] args) {

        // 구구단 출력하기

        /*
         *  3 * 1 = 3
         *  3 * 2 = 6
         *  3 * 3 = 9
         *  3 * 4 = 12
         *  .....
         *  3 * 9 = 27
         *
         */

        int dan = 3;

        for ( int i = 1; i <= 9; i++) {
            System.out.println( dan +" * "+ i + " = " + i * dan );
        }


    }
}
