<%@ page import="dao.ProductDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="dto.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initail-scale=1">
    <title>상품 ::: 목록</title>
    <!-- CDN으로 포함시키기 -->
    <!-- 부트스트랩 CSS와 JavaScript 라이브러리  -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    <!-- jQuery 라이브러리  -->
    <script src="jquery-3.7.1.min.js"></script>
</head>
<body>
<%@include file="../include/navbar.jsp" %>


<div class="container">
    <div class="row">
        <div class="col-12">
            <h3 class="mt-3 mb-5"> 전체 상품 조회</h3>
            <table class="table">
                <colgroup>
                    <col width="10%">
                    <col width="30%">
                    <col width="20%">
                    <col width="20%">
                    <col width="20%">
                </colgroup>


                <%
                    // 1. 요청 파라미터 조회 - 없음 생략

                    // 2. 업무로직 수행 - 전체 상품 목록을 조회
                    ProductDAO productDAO = new ProductDAO();
                    List<Product> productList = productDAO.getProducts();

                %>
                <thead>
                <tr>
                    <th>상품 번호</th>
                    <th>상품명</th>
                    <th>제조사</th>
                    <th>가격</th>
                    <th>할인 가격</th>
                </tr>
                </thead>

                <tbody>
                <%
                    if (productList.isEmpty()) {
                %>
                <tr>
                    <td colspan="5" class="text-center">상품이 존재하지 않습니다</td>
                </tr>
                <%
                } else {
                    for (Product pd : productList) {
                %>

                <tr>
                    <td><%=pd.getNo() %>
                    </td>
                    <td><a href="detail.jsp?no=<%=pd.getNo()%>"
                           class="text-black text-decoration-none"><%=pd.getName()%>
                    </a>
                    </td>
                    <td><%=pd.getMaker()%>
                    </td>
                    <td><%=pd.getPrice()%> 원
                    </td>
                    <td><%=pd.getDiscountPrice()%> 원
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>

            <div class="d-flex justify-content-end">
                <div class="text-end">
                    <a href="../home.jsp" class="btn btn-dark btn-sm">메인으로</a>
                    <a href="form.jsp" class="btn btn-dark btn-sm">상품 등록</a>
                    <%--                    <a href="" class="btn btn-dark btn-sm">상품 수정</a>--%>
                </div>

            </div>
        </div>
    </div>
</div>


</body>
</html>