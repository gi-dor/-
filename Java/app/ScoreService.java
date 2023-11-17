package Java.app;

import java.util.List;

public class ScoreService {


    private ScoreRepository repo = new ScoreRepository();

    // 신규 정보를 등록하는 서비스
    //  - 해당 학번의 성적 정보가 있는지 체크
    //  - 정보가 존재하면 오류 발생
    //  - 정보가 존재하지 않으면 성정정보를 저장시킨다
    // 반환타입 void
    // 메서드이름 : addNewScore
    // 매개변수 : Score score

    public void addNewScore(Score score) {
        Score saveScore = repo.findByNo(score.getNo());
        if (saveScore != null) {
            throw new RuntimeException("[" + score.getNo() + "] 성적정보가 이미 등록 되어 있습니다");
        }
        repo.save(score);
    }

    // 모든 성적 정보를 제공하는 서비스
    //  - 학생정보를 학번순으로 정렬해서 제공
    // 반환타입 : List<Score>
    // 메서드명 : getAllScore
    // 매개변수 : X

    /*
    interface Comparable<T> {
        int compareTo(T o1 , T o2);
        }
        o1 과 o2의 대소 관계를 비교하는 구현 메서드를 작성하면 o1과 o2는 정렬이 가능하다
        Collections,sort(리스트 , Comparator구현객체)
        리스트.sort(Comparator 구현객체)
     */

    public List<Score> getAllScore() {
        List<Score> list = repo.findAll();

        // 각각의 성적 정보를 학번 기준으로 오름차 순으로 정렬시키기 위한 구현
//        list.sort(new Comparator<Score>() {
//            @Override
//            public int compare(Score s1, Score s2) {
//                return s1.getNo() - s2.getNo();
//            }
//        });
        list.sort((s1, s2) -> s1.getNo() - s2.getNo());

        return list;
    }

    // 모든 성적 정보를 성적순으로 제공하는 서비스
    //  - 학생 성적 정보를 총점에 대한 내림차순으로 정렬해서 제공한다
    // 반환타입 : List<Score>
    // 메서드명 : getSortedScore
    // 매개변수 : X

    List<Score> getSoredScore() {
        List<Score> list = repo.findAll();
        list.sort((s1, s2) -> s2.getTotal() - s1.getTotal());
        return list;
    }

    // 성적 정보를 변경하는 서비스
    //  - 성적 정보가 존재하지 않으면 예외를 발생시킨다
    //  - 성적 정보가 존재하면 국어 영우 수학점수를 setter 메서드를 사용해 변경
    //  - 변경된 성적 정보로 총점과 평균을 다시 집계하도록 reduce() 메서드 실행
    // 반환 타입 : void
    // 메서드명 : updateScore
    // 매개변수 :  int no , int kor , int eng , int math
    public void updateScore(int no, int kor, int eng, int math) {
        Score saveScore = repo.findByNo(no);
        if (saveScore == null) {
            throw new RuntimeException("[" + no + "] 번 성적 정보가 존재 하지 않습니다");
        }
        saveScore.setKor(kor);
        saveScore.setEng(eng);
        saveScore.setMath(math);

        saveScore.reduce();

    }


}
