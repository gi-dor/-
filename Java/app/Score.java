package Java.app;

public class Score {

    // 멤버변수 은닉화
    private int no;
    private String name;
    private int kor;
    private int eng;
    private int math;

    private int total;
    private int average;

    // 은닉회된 멤버변수를 초기화 할수 있는 생성자
    public Score(int no, String name, int kor, int eng, int math) {
        this.no = no;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;

        reduce();
    }

    public void reduce() {
        total = kor + eng + math;
        average = total / 3;
    }

    // 은닉화된 멤버변수 값을 조회 할수 있는 Getter 메서드
        /*
        public 반환타입 get 멤버변수명() {
            return 멤버변수명
        }
        */
    public int getNo() {
        return no;
    }

    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }

    public int getMath() {
        return math;
    }

    public String getName() {
        return name;
    }

    public int getTotal() {
        return total;
    }

    public int getAverage() {
        return average;
    }

    // 은닉화된 멤버변수의 값을 수정할 수 있는 Sette 메서드
//    public void set멤버변수명(매개변수타입 변수명){
//        this.멤버변수명 = 변수명;
//    }


    public void setKor(int kor) {
        this.kor = kor;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public void setMath(int math) {
        this.math = math;
    }

}


