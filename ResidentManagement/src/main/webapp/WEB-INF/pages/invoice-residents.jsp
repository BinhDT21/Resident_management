<%--
  Created by IntelliJ IDEA.
  User: cyberse
  Date: 5/27/2024
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .table td, .table th{
        text-align: center;
        vertical-align: middle;
    }
</style>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Invoice</title>
</head>
<body>
<h1 class="text-center text-dark mt-1">QUẢN LÝ HÓA ĐƠN</h1>
<a class="btn btn-success" href="<c:url value="/invoices/create-multiple"/>">Tạo hóa đơn hàng loạt</a>


<form class="d-flex mx-2" action="<c:url value="/"/>">
    <input type="hidden" name="block" value="0"/>
    <button class="btn btn-dark mt-2 mb-2" type="submit" >Cư dân đã khóa</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên cư dân</th>
        <th>Hóa đơn chưa thanh toán</th>
        <th>Hóa đơn chờ thanh toán</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${residents}" var="r">
        <tr>
            <td>${r.id}</td>
            <td>${r.userId.lastName} ${r.userId.firstName}</td>
            <td>${r.invoiceSet.stream().filter(i -> i.getStatus().equals("unpaid")).count()}</td>
            <td>${r.invoiceSet.stream().filter(i -> i.getStatus().equals("waiting")).count()}</td>
            <td>
                <a class="btn btn-primary"
                   href="<c:url value="/invoice-residents/${r.id}/all"/>">
                    Danh sách hóa đơn
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<nav>
    <ul class="pagination">
        <c:if test="${currentPage > 1}">
            <li class="page-item"><a class="page-link" href="?page=${currentPage - 1}">Previous</a></li>
        </c:if>
        <c:forEach var="i" begin="1" end="${totalPages}">
            <li class="page-item <c:if test='${i == currentPage}'>active</c:if>'">
                <a class="page-link" href="?page=${i}">${i}</a>
            </li>
        </c:forEach>
        <c:if test="${currentPage < totalPages}">
            <li class="page-item"><a class="page-link" href="?page=${currentPage + 1}">Next</a></li>
        </c:if>
    </ul>
</nav>

</body>
</html>
