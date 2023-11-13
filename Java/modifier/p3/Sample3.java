package Java.modifier.p3;

public class Sample3 {


    // private 접근제한 멤버변수
    // 같은 클래스 내부에서만 접근가능
    private int value1;

    // default 접근제한 멤버변수
    // 같은 패키지 내의 , 다른 클래스에도 접근이 가능하다
    int value2;

    // protected 접근제한 멤버변수
    // 같은 패키지 , 다른 클래스에서 접근이 가능하다
    // 이 클래스를 상속받은 자손 클래스는 다른 패키지여도 접근이가능하다
    protected int value3;

    // public 접근제한 멤버변수
    // 전체공개
    public int value4;
}
