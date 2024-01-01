### Java EE , Jakarta EE

- 2018년 Java EE 는 Jakarta EE로 명칭변경 , 오픈소스기분
- API 패키지명 변경
- javax.8 ➡ jakarta.* 로 변경

----------


Servlet API

Servlet 인터페이스

- 서블릿의 라이프 사이클 메서드를 정의하고 있는 인터페이스
- 주요 메서드
  <br>

```java
void init(ServletConfig config)
```

- 서블릿의 초기화를 담당하는 메서드
- GenericServlet 클레스에서 구현하고 있다<br>

```java
void service(ServletRequest request,ServletResponse response)
```        

- 클라이언트의 요청 처리를 담당하는 메서드 <br>

```java
void destroy()
```

- 서블릿이 폐기될 때 실행되는 메서드

<br>
<br>

#### 🔹 GenericServlet 추상 클래스

- 서블릿이 인터페이스 에서 정의한 추상 메서드의 일부를 구현하는 추상클래스 <br>

#### 🔹 주요 메서드

```java
void init()
```

- 서블릿 초기화 담당 메서드 <br><br>

```java
  ServletConfig getServletConfig()
```

- ServletConfig 객체를 반환하sms 메서드 <br><br>

```java
     ServletContext getServletContext()
```

- ServletContext 객체를 반환하는 메서드 <br><br>

#### 🔹 HttpServlet 추상 클래스

Http 프로토콜에 특화된 서블릿 클래스를 구현할 때 상속받는 추상 클래스

#### 🔹 주요 메서드

```java
void service(HttpServletRequest request,HttpServletResponse response)
```

- 요청 메세지를 분석해 요청 방식을 조회
- 요청 방식에 따라서 아래의 메서드 중 하나를 실행 <br><br>

```java
void doGet(HttpServletRequest request,HttpServletResponse response)
```

- Get 방식의 요청을 처리하는 메서드 <br><br>

```java
void doPost(HttpServletRequest request,HttpServletResponse response)
```

- Post 방식의 요청을 처리하는 메서드 <br><br>

```java
void doPut(HttpServletRequest request,HttpServletResponse response)
```

- Put방식의 요청을 처리하느 메서드 <br><br>

```java
void doDelete(HttpServletRequest request,HttpServletResponse response)
```

- Delete 방식의 요청을 처리하는 메서드 <br><br><hr>


- 사용자 정의 서블릿 클래스는 HttpServlet 클래스를 상속받아서 정의한다
- 모든 서블릿의 HTTP 프로토콜 기반에서 실행되기 때문
- 요청 방식에 따라서 해당 메서드를 재정의
- 일반적으로 클라이언트의 요청을 처리하기 위해 요청방식에 맞는 메서드를 재정의 하기보다는
  service() 메서드를 재정의한다

----------

#### 🔹 요청객체와 응답객체

ServletRequest 와 ServletResponse 인터페이스

- jakarta.servlet 패키지에 정의
- 특정 프로토콜에 의존적이지 않은 요청메세지 , 응답메세지 관련 인터페이스

HttpServletRequest 와 HttpServletResponse 인터페이스

- jakarta.servlet.http 패키지에 정의
- Http 프로토콜에 특화된 요청메세지 , 응답메세지 관련 인터페이스다
- HttpServletRequest는 ServletRequest 인터페이스를 상속받는다
- HttpServletResponse는 ServletResponse 인터페이스를 상속 받는다