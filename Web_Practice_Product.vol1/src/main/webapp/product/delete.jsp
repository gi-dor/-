<%@ page import="dao.ProductDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<%

    //            요청 URL
//                localhost/pr/product/delete.jsp?no=xxx

    // 요청 파라미터 값 조회

    int no = Integer.valueOf(request.getParameter("no"));

    // 업무로직
    // DAO 생성후 해당 메서드 실행
    ProductDAO productDAO = new ProductDAO();
    productDAO.deleteProductByNo(no);

    // 삭제가 완료되면 재요청으로 list.jsp 로 이동
    response.sendRedirect("list.jsp");

%>