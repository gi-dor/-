<%@ page import="dto.Product" %>
<%@ page import="dao.ProductDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    // 요청파라미터 값 조회하기
    String name = request.getParameter("name");
    String maker = request.getParameter("maker");
    int amount = Integer.parseInt(request.getParameter("amount"));
    int price = Integer.parseInt(request.getParameter("price"));
    String description = request.getParameter("description");

    // Product 에 담기 위해 객체 생성
    Product product = new Product();

    // set 을 사용해 product 변수에 담는다
    product.setName(name);
    product.setMaker(maker);
    product.setStock(amount);
    product.setPrice(price);
    product.setDescription(description);
    product.setDiscountPrice((int) (product.getPrice() * 0.9));

    // 업무 로직 수행
    ProductDAO productDAO = new ProductDAO();
    productDAO.insertProduct(product);

    response.sendRedirect("/pr/product/list.jsp");
//    response.sendRedirect("list.jsp");
%>