package Java.io.io8;

import java.util.Set;

public class Lotto {

    private int no;
    private Set<Integer> numbers;
    private int bonus;

    public Lotto() {
    }

    public Lotto(int no, Set<Integer> numbers, int bonus) {
        this.no = no;
        this.numbers = numbers;
        this.bonus = bonus;
    }


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
