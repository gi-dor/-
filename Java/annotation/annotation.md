### 어노테이션

- 자바의 어노테이션은 소스 코드에 추가해서 사용할수 있는 메타 데이터의 일종이다 (부가적인 정보)
    + 메타 데이터는 컴파일 과정이나 실행과정에서 코드를 어떻게 처리해야하는지 알려주기 위한 정보

- 용도

        public interface Handler{
        void handle(Evenet event);
         }

            public class MyHandler implements Handler {
            @Override
            public void handle (Event event) {
          }
      }
- @Override 는 해당 메서드가 부모의 메서드를 재정의한 메서드임을 나타낸다
- @Override 어노테이션이 부착된 메서드에 대해 부모메서드의 구조와 동일한 구조를 가지고 있느지 체크한다


- 애플리케이션 배포시 코드를 자동으로 생성할 수 있도록 정보를 제공

        @Getter
        @Setter
        public class USer {
            private int no;
            private String id;
            private String pwd;
        }

* 롬복 (Lombok)의 @Getter , @Setter 어노테이션은 Getter , Setter 메서드를 실행파일에 추가한다


- 실행 시점에 특정 기능을 시핼하도록 정보를 제공

        public class UserForm{
            @Notblank
            private String name;
            
        @Notblank
        @Email
        private String email;

        @past
        private date birthday;
                    }


- hibernate bean validator가 제공하는 어노테이션은 폼 입력값 유호청 체크를 위한 정보가된다
- UserForm 클래스는 회원가입폼에서 입력한 이름 , 이메일 , 생일정보를 저장하는 클래스
- 위의 어노테이션은 해당 변수가 가져야하는 유효한 값의 형태를 표시한다
- 이 객체에 저장된 값에 대한 유효성 여부를 체크 할 때 어노테이션과 변수의 값을 비교해서 유효성 체크한다
- @ valid는 전달받은 UseForm 객체에 저장된 값에 대해 유효성 체크를 수행하도록 하는 어노테이션이다

            public String register(@Valid Use Form....) {  }

- 자바의 Built-in 어노테이션

@Override : 해당 메서드가 재정의된 메서드임을 나타내는 어노테이션이다

@Depriecated : 해당 메서드는 비추천 메서드, 차후 사라질 기능이있다

@Suppresswarnings : 컴파일 경고를 출력하지 않도록 하는 어노테이션

@FunctionalIntrfae : 함수형 인터페이스임을 나타내는 어노테이션

+ 함수형 인터페이스는 java8 부터 등장
+ 함수형 인터페이스는 추상 메서드를 딱 하나만 가지고 있는 인터페이스
+ 함수형 인터페이스는 람다식(람다함수)에서 활용 할 수 있다


- @메타 어노테이션
-
- @Retention
    - 어노테이션의 보유기간을 지정하는 어노테이션
      RetentionPolicy.Source : 컴파일 이후 삭제
      RetentionPolicy.Class :
        + 바이트 코드 파일까지 어노테이션 정보가 유지된다
        + 프로그램 실행 시점에 사용할수 없음
        + 자바의 리플렉션 API를 이용해 어노테이션 정보획득

RetentionPolicy.Runtime :

+ 애플리케이션 실행 시점에 어노테이션 정보를 획들할 수 있다
+ 자바의 리플렉셕API를 이용해 어노테이션 정보를 획들 할수 없다

@Target

- 어노테이션이 적용될 위치를 나열
- 종류
    + Target.TYPE - 클래스 , 인터페이스 , 열거 타입에 적용할 수 있다
    + Target.FIELD - 필드 - iv,cv에 적용할수 있다
    + Target.CONSTRUCTOR - 생성자에 적용
    + Target.METHOD - 메서드에 적용
    + Target.PARAMETER - 메서드의 매개변수에 적용

@DOCUMENTED

- @Inherited
- @Documented


