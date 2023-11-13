package Java.modifier.p3;

public class Sample4 {
    Sample3 sample3 = new Sample3();

    public void method() {
        // private 접근제한된 value1은 접근 불가
        // 같은 클래스에서만 접근이 가능
//		sample3.value1 = 10;

        // default 제한 value2 접근가능
        sample3.value2 = 20;

        // protected 제한이 걸린 value3 접근가능
        sample3.value3 = 30;

        // public 제한이 걸린 value4 접근가능
        sample3.value4 = 40;


    }
}
