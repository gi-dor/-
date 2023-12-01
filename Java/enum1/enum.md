🔸 enum (열거형)

미리 값이 정해져 있는 한정된 데이터의 묶음
열거형으로 상수를 대체 할 수 있다

◻ 고객의 등급 : Gold , Shilver , Bronze<br>
◻ 학점 : A , B , C , D<br>
◻ 계절 : 봄 , 여름 , 가을 , 겨울

📌 열거형 정의하기

    public enum Grade {
    GOLD , SILVER , BRONZE;
    }

    public enum Grade {
    A(4.0) , B(3.0) , C(2.0) , D (1.0) ,F (0.0);
    }

🔸 상수

상수는 프로그램이 실행되는 동안 변하지 않는 값 ( 미리 값이 정해진 데이터 ) 다

public static final 타입 상수이름 = 값;
public class Constants{
public static final int GOLD =1;
public static final int SILVER = 2;
public static final int BRONZE = 3;

    public static final double GOLD_POINT_DEPOSIT_RATE = 0.05; 
    public static final double SHILVER_POINT_DEPOSIT_RATE = 0.02; 
    public static final double BRONZE_POINT_DEPOSIT_RATE = 0.01; 
    
    public static final long MAX_UPLOAD_SIZE = 1024 * 1024 * 10 ;

}

🔹 상수를 정의하는 목적

가독을 향상 시킨다.
유지보수성을 높인다.
위에 예시인 Constants 상수의 값을 변경하기만 하면 해당 상수 값을 사용하는 모든 클래스에 변경된 값이 적용된다
상수 값들간에 상관관계가 있는경우 2배 3배 1/2배...등 상수값을 그 상관 관계를 표현하는 식으로 작성한다
final double GOLD_DEPOSIT_RATE = 0.1;
final double SHILVER_DEPOSIT_RATE = GOLD_DEPOSIT_RATE/2;
final double BRONZE_DEPOSIT_RATE = GOLD_DEPOSIT_RATE/4;
final double GUEST_DEPOSIT_RATE = GOLD_DEPOSIT_RATE/8;

// 상수 사용안함

        public int getDeposiPoint(int customerGrade , int amount) {
        if(customerGrade == 1 ) {
                  return (int) (amount * 0.05);
        } else if ( customerGrade == 2) {
                 return (int) (amount * 0.02 ) ;
        } else if (customerGrade == 3 {
              return (int) (amount * 0.01);
        }
        return 0;
        
        }

// 상수사용

    public int getDeposiPoint(int customerGrade , int amount) {
    if(customerGrade == constants.GOLD ) {
        return (int) (amount * 0.05);
    } else if ( customerGrade == constants.SHILVER) {
        return (int) (amount * 0.02 ) ;
    } else if (customerGrade == constants.BRONZE {
      return (int) (amount * 0.01);
    }
         return 0;

    }

🔹 enum (열거형)
상수값 (상수데이터)의 집합이 열거형이다

<br>
🔹 형식

        enum (열거형이름) {
            상수 , 상수 , 상수;
        }

- 열거형 이름 : 클래스 이름처럼 첫번째 글자를 대문자로 하고 나머지는 소문자로 작성
- 상수 : 전부 대문자로 작성 , 두단어 이상 조합일 떄 ' _ ' 로 연결

<br>

🔹 enum의 장점

- 허용 가능한 값들을 제한 한다<br>

• 열거형 상수가 특정 열거타입에 포함되어 있기 때문에 <br>
열거형 변수에 대입 가능한 값은 해당 열거형의 열거상수들 뿐이다

        static final int GOLD = 1;
        static final int SILVER = 2;
        int customerGrade = GOLD;
        int customerGrade = 100;    // 고객등급과 상관없는 값이 대입되어도 에러가 발생 안함

<br>

    public enum Grade{
        GOLD , SILVER , BRONZE;
        }
    
    Grade grade = Grade.GOLD;
    Grade grade = 100;  // 컴파일 오류 발생

- 개발도구의 자동완성 , 문법오류 체크등을 지원받을수 있다
- 조건식에서 == 으로 비교 가능하고 , switch문에서도 바로 사용이 가능하다

<br>

🔹 enum의 주요 내장메서드


<br>

    String name()
        열거객체가 가지고 있는 문자열을 반환 , 문자열은 열거상수의 이름과 동일하다
    
    int ordinal()
    	열거객체의 순번을(0번부터 시작하는) 반환한다 
    
    int compareTo(enum other)
    	지정된 열거객체와 순번을 비교해서 정수값을 반환한다
        전달받은 다른 열거객체의 순번보다 빠르면 음수
        전달받은 다른 열거객체의 순번보다 늦으면 양수 
        
    enum valueOf(String name)
    	매개변수로 전달받은 문자열과 동일한 이름을 가지는 열거객체를 생성해서 반환
    
    enum[] values()
        해당 열거형의 모든 열거상수들에 대한 열거객체를 배열로 반환

            열거객체 		---->			문자열
             Grade.GOLD   	         name()			"GOLD"
    
            문자열			---->			열거객체
            "GOLD"		 Grade.valueOf("GOLD")  	Grade.GOLD

📌 따로 new 연산자로 객체를 생성하지 않고 해당 코드 처럼 하면

        Grade grade = Grade.GOLD;

Grade.GOLD가 열거 객체가 된다

🔹 enum 과 상수 값 매핑하기

        enum ScoreGrade{
        public static final ScoreGrade 수 = new ScroreGrade(90);
        public static final ScoreGrade 우 = new ScroreGrade(80);
        public static final ScoreGrade 미 = new ScroreGrade(70);

    public int score;

    private ScoreGrade (int score) {
    this.score = score;
    }

    public int getScore() {
        return score;
    }
