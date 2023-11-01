package Java.oop01.day1;

public class Score {
        // Score 클래스 정의


        String name;
        int kor;
        int eng;
        int math;

        int total;
        double average;

    /**
     *
     * @param name 학생이름
     * @param kor 국어점수
     * @param eng 영어점수
     * @param math 수학점수
     */
    void setup(String name , int kor ,  int eng , int math){
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;

            total = kor + eng + math;
            average = total / 3;
        }

        // 성적 출력하기
    void printScore(){
        System.out.println("----------------------------------");
        System.out.println("이름 : "+ name);
        System.out.println("국어 점수 : "+kor);
        System.out.println("영어 점수 : "+eng);
        System.out.println("수학 점수 : "+math);
        System.out.println("총점 : "+total);
        System.out.println("평균 : "+average);
    }

}
