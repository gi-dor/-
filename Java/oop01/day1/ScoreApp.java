package Java.oop01.day1;

public class ScoreApp {
    public static void main(String[] args) {

        // Score 클래스 사용하기
        Score s1 = new Score();
        s1.setup("한기선" , 90 , 60 , 40);

        Score s2 = new Score();
        s2.setup("기돌" , 80 , 90 , 100);


        s1.printScore();
        s2.printScore();
    }
}
