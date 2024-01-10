<%@page import="vo.Event" %>
<%@page import="vo.ProductEvent" %>
<%@page import="dao.ProductDao" %>
<%@page import="vo.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    /*

      요청 URL
  	  	localhost/comm/product/insert.jsp

 	  요청 파라미터
 	  	catNo=xxx
 	  	&comNo=xxx
 	  	&statusNo=xxx
 	  	&name=XXX
 	  	&price=xxx
 	  	&discountPrice=xxx
 	  	&eventNo=xxx
 	  	&eventNo=xxx
 	  	&eventNo=xxx

 	  	String getParameter(String name)
 	  			지정된 요청 파라미터 이름으로 값 하나 조회해서 반환한다
 	  	String[] getParameterValue(String name)
 	  			지정된 요청 파라미터 이름으로 조회되는 모든 값을 배열에 순서대로 담아서 반환
    */

%>


<%
    int catNo = Integer.valueOf(request.getParameter("catNo"));
    int comNo = Integer.valueOf(request.getParameter("comNo"));
    int statusNo = Integer.valueOf(request.getParameter("statusNo"));
    String name = request.getParameter("name");
    int price = Integer.valueOf(request.getParameter("price"));
    int discountPrice = Integer.valueOf(request.getParameter("discountPrice"));
    String description = request.getParameter("description");
    // 여러개 선택할수 있는 체크박스로 되어있어서 배열로 담음
    String[] eventNoArr = request.getParameterValues("eventNo");

    // Product클래스의 정적메서드인 createdProduct(값, 값,값...)
    // 실행해서 요청 파라미터 앖이 채워진 Product 객체 생성
    // 카테고리 제조사 상태 이름 가격 할인가격 설명정보가 들어있다
    Product product = Product.createProduct(catNo, comNo, statusNo, name, price, discountPrice, description);

    // 상품 번호용 일련번호를 조회해서 반환 받는다
    ProductDao productDao = new ProductDao();
    int no = productDao.getProductNo();

    product.setNo(no);    // 상품번호 , 카테고리 , 제조사 , 상태 , 이름 , 가격 , 할인가격, 설명

    // 신규 상품 정보를 저장한다
    productDao.insertProduct(product);

    // 체크박스 이벤트 정보를 상품정보와 함께 저장하기
    for (String value : eventNoArr) {
        int eventNo = Integer.valueOf(value);

        // 이벤트자체의 정보(이벤트 번호 , 제목 ㅡ 설명)
        Event event = new Event();
        event.setNo(eventNo);

        // 해당 상품의 이벤트 정보
        ProductEvent productEvent = new ProductEvent();
        productEvent.setProduct(product);
        productEvent.setEvent(event);

        productDao.insertProductEvent(productEvent);
    }

    response.sendRedirect("/product/list.jsp");


%>
