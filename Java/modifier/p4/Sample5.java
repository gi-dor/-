package Java.modifier.p4;

import Java.modifier.p3.Sample3;
public class Sample5 {
    Sample3 sample3 = new Sample3();
    public void method() {

        // The field Sample3.value1 is not visible
//		sample3.value1 = 10;
//		sample3.value2 = 10;
//		sample3.value3 = 10;
        // value 1 , 2 , 3는 다른 패키지에 속하며
        // 다른 패키지에 접근이 가능한 제어는 public만 가능하다

        sample3.value4 = 10;
    }
}
