package Java.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ScoreRepository {

    private ArrayList<Score> list = new ArrayList<>();

    public ScoreRepository() {
        list.add(new Score(13, "치우1", 90, 45, 88));
        list.add(new Score(7, "헌원2", 80, 55, 34));
        list.add(new Score(2, "황제3", 70, 75, 46));
        list.add(new Score(19, "신농4", 72, 90, 95));
        list.add(new Score(41, "치우2", 67, 17, 90));
        list.add(new Score(39, "여와5", 51, 40, 54));
        list.add(new Score(28, "서왕6", 70, 20, 78));
        list.add(new Score(31, "나타7", 60, 55, 40));
        list.add(new Score(11, "몽념8", 50, 10, 90));
    }

    // 저장 , 삭제 , 수정 의 반환 타입은 void
    // 조회 - 1건 객체 1개 , 모든건 , 여러건 조회 - list


    // 신규 성적 정보를 전달받아서 저장하는 메서드
    /*
    반환 타입: void
    메서드 이름: save
    매개변수 : Score score
     */
    public void save(Score score) {
        list.add(score);
    }

    // 모든 성적 정보를 제공하는 메서드
    /*
    반환 타입: List<Score>
    메서드 이름: findaAll
    매개변수: X
     */

    @SuppressWarnings("unchecked")
    public List<Score> findAll() {
        return (List<Score>) list.clone();
    }


    // 학번을 전달받아서 해당 학번의 성적 정보를 제공하는 메서드
        /*
        반환 타입: Score
        메서드 이름: findByNo
        매개변수 : int no
         */
    public Score findByNo(int no) {
        for (Score sc : list) {
            if (sc.getNo() == no) {
                return sc;
            }
        }
        return null;
    }

    // 이름을 전달 받아서 이름에 해당하는 성적 정보를 제공하는 메서드
    /*
    반환 타입: List<Score>
    메서드 이름: findByName
    매개변수: String name
     */

    public List<Score> findByName(String name) {
        List<Score> foundScore = new ArrayList<Score>();

        return foundScore;
    }

    // 학번을 전달받아서 해당 학번의 성적 정보를 삭제하는 메서드
    /*
    반환 타입 : void
    메서드 이름: deleteByNo
    매개변수 : int no
     */

    public void deleteByNo(int no) {
        Iterator<Score> it = list.iterator();

        while (it.hasNext()) {
            Score sc = it.next();
            if (sc.getNo() == no) {
                it.remove();
                break;
            }
        }
    }

}
