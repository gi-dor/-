<%@ page import="dto.Product" %>
<%@ page import="dao.ProductDAO" %>
<%@ page import="utils.DateUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initail-scale=1">
    <title>상품 ::: 상세 페이지</title>
    <!-- CDN으로 포함시키기 -->
    <!-- 부트스트랩 CSS와 JavaScript 라이브러리  -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    <!-- jQuery 라이브러리  -->
    <script src="jquery-3.7.1.min.js"></script>
</head>
<body>

<%
    // 요청 URL locaolhost/pr/product/detail.jsp?no=xxxx
    int no = Integer.valueOf(request.getParameter("no"));

    ProductDAO productDAO = new ProductDAO();

    Product product = productDAO.getProductByNo(no);

%>
<%@include file="/include/navbar.jsp" %>


<div class="container">
    <div class="row">
        <div class="col-12">

            <h2 class="mt-5"> 상품 상세 페이지</h2>

            <table class="table table-boarded">
                <colgroup>
                    <col width="10%">
                    <col width="40%">
                    <col width="10%">
                    <col width="40%">
                </colgroup>
                <tbody>
                <tr>
                    <th>상품 이름</th>
                    <td colspan="3"><%=product.getName()%>
                    </td>
                </tr>
                <tr>
                    <th>상품 번호</th>
                    <td><%=product.getNo()%>
                    </td>
                    <th>제조회사</th>
                    <td><%=product.getMaker()%>
                    </td>
                </tr>
                <tr>
                    <th>가격</th>
                    <td><%=product.getPrice()%> 원</td>
                    <th>할인 가격</th>
                    <td><%=product.getDiscountPrice()%> 원</td>
                </tr>
                <tr>
                    <th>판매 여부</th>
                    <th><%="Y".equals(product.getOnSell()) ? "판매 중" : "판매 종료"%>
                    </th>
                    <td>재고 수량</td>
                    <td><%=product.getStock()%>
                    </td>
                </tr>
                <tr>
                    <th>상품 수정 일자</th>
                    <td><%=DateUtils.toText(product.getUpdateDate())%>
                    </td>
                    <th>상품 등록 일자</th>
                    <td><%=DateUtils.toText(product.getCreateDate())%>
                    </td>
                </tr>
                <tr>
                    <th>상품 설명</th>
                    <td><%=product.getDescription()%>
                    </td>
                </tr>

                </tbody>

            </table>

            <div class="text-end" style="margin-top: 50px">
                <a href="modifyform.jsp?no=<%=product.getNo()%>" class="btn btn-dark">수정</a>
                <a href="delete.jsp?no=<%=product.getNo()%>" class="btn btn-dark ">삭제</a>
            </div>


        </div>
    </div>
</div>


</body>
</html>