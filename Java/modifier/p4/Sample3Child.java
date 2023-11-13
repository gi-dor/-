package Java.modifier.p4;
import Java.modifier.p3.Sample3;
public class Sample3Child extends Sample3 {
    Sample3 sample3 = new Sample3();

    // 상속을 통해 직접 부모 클래스의 변수에 접근함
    public void method() {
        // private 접근제한 적용
//		value1 = 10;

        // default 접근제한 적용
//		value2 = 20;

        // protected 접근제한 적용
        value3 = 30;

        // public 접근제한
        value4 = 40;
    }
}
