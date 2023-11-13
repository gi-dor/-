package Java.modifier.p2;

/*
 * default 접근제한이 적용된 Sample1은 같은 패키지에만 접근이 가능하기에
 * 다른 패키지의 클래스에서 접근할수 없다.
 */


//import modifier.p1.Sample1; 컴파일 오류
import Java.modifier.p1.Sample2;


/*
 * public 접근제한이 적용된 Sample2는 다른패키지의 클래스에서 접근할 수 있다.
 * 	-import구문으로 포함 시킨후 사용할 수 있다.
 */

public class App2 {
    public static void main(String[] args) {
        /*
         * Sample1 , Sample2  둘다 App2와 다른 패키지에 존재하는 클래스다
         * 	- 다른 패키지에 존재하는 클래스는 반드시 import 구문작성 후 사용가능하다
         */
//		Sample1 sample1 = new Sample1();
        Sample2 sample2 = new Sample2();
    }
}
