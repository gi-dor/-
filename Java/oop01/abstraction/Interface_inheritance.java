package Java.oop01.abstraction;

    // 인터페이스의 상속
public interface Interface_inheritance extends Movale , Attackable{

    // 기존 인터페이스 Interface_inheritance는 아무것도 없지만
    // 상속받은 2개의 인터페이스로 인해 move() 와 attack() 메서드를 가지고 있으며
    // 다중상속이 가능하다
    // 구현시 public 보다 접근제어가 좁아지면 안된다 ( = 오버라이딩 조건 )
}

interface Movale{
    void move(int x, int y);
}

interface Attackable{
    void attack(int u);
}