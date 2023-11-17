### Score app

app
<br>ㄴReadme.md
<br>ㄴ Score.java
<br>ㄴ ScoreUI
<br>ㄴ ScoreService
<br>ㄴ ScoreRepository
<br>
<br>

---


<br>

- Score.java - 학생의 성적 정보를 표현하는 클래스

- ScoreUI.java - 성정관리 UI 클래스

- ScoreService.java - 실제 성적관리 업무로직 클래스

- ScoreRepository.java - 성적관리 영속화 클래스

<br>

---------------------

- 은닉화된 멤버변수 값을 조회 할수 있는 Getter 메서드

        public 반환타입 get 멤버변수명() {
            return 멤버변수명
        }

<br>

- 은닉화된 멤버변수의 값을 수정할 수 있는 Setter 메서드

       public void set멤버변수명(매개변수타입 변수명){
           this.멤버변수명 = 변수명;
       }  

<br>

           interface Comparable<T> {
                int compareTo(T o1 , T o2);
        } 

- o1 과 o2의 대소 관계를 비교하는 구현 메서드를 작성하면 o1과 o2는 정렬이 가능하다
  <br><br>

      Collections.sort(리스트 , Comparator구현객체)
    
      리스트.sort(Comparator 구현객체)