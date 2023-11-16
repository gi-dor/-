package Java.generic;

public class GenericBox<T> {
    // <T> 타입 파라미터라고 한다.
    // 클래스는 제네릭 타입 매개변수 <T>를 가지고 있다

    private T data; // T타입의 데이터 저장할수 있는 멤버변수 data , 어떤 데이터의 값을 저장할수 있음


    // 타입에 전부 T
    public void add(T data) {
        this.data = data;
    }

    public T get() {
        return data;
    }
}
