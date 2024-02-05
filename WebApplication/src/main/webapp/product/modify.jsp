<%@page import="vo.Event" %>
<%@page import="vo.Product" %>
<%@page import="dao.ProductDao" %>
<%@page import="vo.ProductEvent" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    /*
    요청 URL
        localhost/comm/product/midify.jsp
    요청 파라미터
        no=xxx
        &catNo=xxx
        &comNo=xxxx
        &statusNo=xxx
        &name=xxx
        &discountPrice=xxx
        &description=xxx
        &eventNo=xxx
        &enentNo=xxx
    */
    int no = Integer.valueOf(request.getParameter("no"));
    int catNo = Integer.valueOf(request.getParameter("catNo"));
    int comNo = Integer.valueOf(request.getParameter("comNo"));
    int statusNo = Integer.valueOf(request.getParameter("statusNo"));
    String name = request.getParameter("name");
    int price = Integer.valueOf(request.getParameter("price"));
    int discountPrice = Integer.valueOf(request.getParameter("discountPrice"));
    String description = request.getParameter("description");
    String[] eventNoArr = request.getParameterValues("eventNo");

    ProductDao productDao = new ProductDao();

    // 데이터 베이스에서 수정된 상품정보조회
    Product product = productDao.getProductByNo(no);

    product.getCat().setNo(catNo);
    product.getCompany().setNo(comNo);
    product.getStatus().setNo(statusNo);
    product.setName(name);
    product.setPrice(price);
    product.setDiscountPrice(discountPrice);
    product.setDescription(description);

    // 수정폼에서 변경 가능한 정보가 포함된 상품객체를 전달해서 DB에 반영
    productDao.updateProduct(product);

    // 해당 삼품과 관뢴되어 저장된 기존 이벤트정보를 전부 ㅏㄱ재헌더 헌더
    productDao.deleteProductEventsByProductNo(no);

    for (String value : eventNoArr) {
        int eventNo = Integer.parseInt(value);
        Event event = new Event();
        event.setNo(eventNo);

        ProductEvent productEvent = new ProductEvent();
        productEvent.setProduct(product);
        productEvent.setEvent(event);

        productDao.insertProductEvent(productEvent);
    }
    response.sendRedirect("detail.jsp?no=" + no);


%>