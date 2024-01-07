Servlet Context

- 웹 애플리케이션 당 하나 생성되는 객체
- 웹서버가 기동될 때 생성 , 웹서버가 종료될 때 폐기한다
- 웹 애플리케이션과 관련된 설정 정보를 포함

HttpSession

- 클라이언트 하나당 생성되는 객체 - 클라이언트가 첫번째 요청시 생성
- 클라이언트 마다 고유한 자신의 세션 객체가 있다 (인증된 로그인 정보를 저장한다)
- 로그아웃을 실행 하거나 일종 시간 이상 웹사이트 이용이 없으면 폐기 (기본30분)

ServletConfig

- 서블릿 객체당 하나 생성되는 객체
- 서블릿과 관뢴된 설정 정보를 포함
- JSP 에서는 사용빈도가 매위 낮음

HttpServletRequest <br>
HttpServletResponse

- Http 요청당 하나 생성되는 객체
- 요청을 처리하고 응답이 완료되면 폐기한다
- 요청메세지 , 응답메세지를 담당한다

#### 🔹 JSP 내장객체

JSP페이지가 Java로 변환될 떄 _jspSercive 메서드에서 사용가능한 객체

_jspService(request,response) {

PageContext pageContext =...; <br>
ServletContext application = pageContext.getServletContext()<br>
ServletConfig config = pageContext.getServletConfig()<br>
JspWriter out = pageContext.getWriter();<br>
HttpSession session = pageContext.getSession()';<br>
Object page = this;<br>
}

<br>

<img src="https://github.com/gi-dor/HTA/assets/86302876/86579386-01fd-402d-b38c-03d1a4cd2242">

#### 🔹 HttpServletRequest 객체

요청헤더 정보 - name:String , value : String

요청 파라미터 정보 - name:String value:Object

속성정보 - name : String value:Object

PageContext객체 , HttpSession 객체 , ServletContext

#### 🔹 HttpSession객체

- 로그아웃 하기 전까지 속성정보가 유지된다
- 인증이 완료된 사용자 정보를 속성으로 저장한다
- 개인화된 정보를 속성으로 저장한다(장바구니 , 최근 본 상품 정보)

<br>

<img src="https://github.com/gi-dor/HTA/assets/86302876/b2dfef78-40aa-45cb-8d9d-d3c4a5b70305">
<img src="https://github.com/gi-dor/HTA/assets/86302876/d2f4a091-66b6-43aa-b234-25ddd72e2448">


----

### 🔸 속성과 스코프(유효범위)

#### 🔹 속성

- 속성은 pageContext , HttpServletRequest , HttpSession , ServletContext에 저장되는 객체(값)을 의미
- 속성은 name 과 value로 구성되며 name의 타입은 String , value의 타입은 Object 다
    - value의 타입이 Object 이기 때문에 속성의 값으로 모든 객체가 가능하다 <br><br>
- PageContext , HttpServletRequest , HttpSession , ServletContext의 주요 속성관련 API
    - void setAttribute(String name);
        - 속성 (이름과 값)을 저장한다
    - Object getAttribute(String name);
        - 지정된 이름으로 저장된 속성값을 반환 한다
    - void removeAttribute(String name);
        - 지정된 이름으로 저장된 속성(이름과 값)을 삭제한다

#### 🔹 스코프

- 스코프는 속성의 사용 (참조) 범위다
- 속성을 어느 객체에 저장하느냐에 따라 스코프가 달라진다 <br><br>
- PageContext
    - 해당 JSP 에서만 사용 할 수 있다
- HttpServletRequest
    - 요청과 응답이 완료되기 전까지 사용 할 수 있다
- HttpSession
    - 로그아웃 전 까지 사용할 수 있다 ,특정 클라이언트만 사용할 수 있다
- ServletContext
    - 서버가 종료되기 전 까지 사용할 수 있다
    - 모든 서블릿 , 모든 JSP , 모든 클라이언트가 사용 할 수 있따

```java
public class Person {
    int no;
    String name; // 인스턴스 변수 iv , 멤버변수 , 클래스의 속성
    String email;
}
```

```html
<input type="text" name="userName">
</input> :태그
type="text" : 태그의 속성
```

- 인증이 완료된 클라이언트는 HttpSession 객체에 인증된 사용자 정보가 보관되어있다
- 인증이 완료된 클라이언트는 더이상 자신을 식별하기위한 정보(사용자번호 , 사용자 이이디 등) 을 서버로 전달할 필요가 없다
- 인증이 완료된 클라이언트는 자신이 조회하고자 하는 서비스만 요청하면된다 (요청할 때마다 세션아이디가 요청 헤더 정보에 포함되어 자동으로 서버로 전달된다)

#### 🔹 HttpSession 객체 생성과 획득

- JSP
    + JSP는 내장 객체로 HttpSession 객체를 지원한다
    + jsp 페이지의 스크립틀릿에서는 session 참조변수에 저장되어 있는 HttpSession객체를 즉시 사용 할수 있다
    + JSP가 HttpSession 객체를 획득/생성 하는 방법
      <br><Br>
        - 요청 객체에 JSESSIONID 가 존재하지 않는경우
            * HttpSession 객체를 생성한다
            * 참조변수 session에 대입한다
            * 응답메세지를 보낼 때 새로 생성된 HttpSession 객체의 JSESSIONID를 쿠키로 내려보낸다
              <br><Br>
        - 요청 객체에 JSESSIONID가 존재하는 경우
            * JSESSIONID에 해당하는 HttpSession 객체가 검색된다
                - 참조변수 session 에 대입한다 <br><br>
            * JSESSIONID에 해당하는 HttpSession 객체가 검색되지 않는다 (장시간 웹을 사용하지 않은경우 , 기간만료 객체 자동폐기)
            *
                - HttpSession 객체를 생성한다
                - 참조변수 session에 대입한다
                - 응답메세지를 보낼 때 새로 생성된 HttpSession 객체의 JSESSIONID를 쿠키로 내려보낸다
                  <br><Br>
    + JSP가 내장객체로 HttpSession 객체를 지원하지 않도록 설정
    + <%@ page session ="false" %>
    + 위와 같이 설정하면 JSP에서 내장 객체로 HttpSession 객체를 제공하지 않는다
    + 수동으로 HttpSession 객체를 생성 / 획득 하기
        - HttpServletRequest API를 사용
            1. HttpSession getSession()
            2. HttpSession getSession(true)
                1. 요청객체에 JSESSIONID가 없다, HttpSession객체를 새로 생성한다
                2. 요청객체에 JSESSIONID가 있다
                    1. JSESSIONID에 해당하는 HttpSession객체가 검색된다 , 검색된 HttpSession 객체를 반환한다
                    2. JSESSIONID에 해당하는 HttpSession객체가 검색되지 않는다, HttpSession객체 새로 생성

          <br><br>
            3. HttpSession getSession(false)
                - 요청객체에 JSESSIONID가 없다 , null 반환
                - 요청객체에 JSESSIONID가 있다
                    1. JSESSIONID에 해당하는 HttpSession객체가 검색된다 , 검색된 HttpSession 객체를 반환한다
                    2. JSESSIONID에 해당하는 HttpSession객체가 검색되지 않는다, null 반환
                       <img src="https://github.com/gi-dor/HTA/assets/86302876/ef8fed26-a590-4073-be5a-da99e3d66f09" />
                       <img src="https://github.com/gi-dor/HTA/assets/86302876/257f8b17-2646-4613-94de-c2d92addbd8e" />

### 📌 인증 Authentication 과 인과 Authorization

#### ▶ 인증 - 사용자가 누구인지 확인하는 절차

#### ▶ 인가 - 사용자가 리소스에 대한 접근권한이 있는지 확인하는 절차