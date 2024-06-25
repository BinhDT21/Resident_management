<%--
  Created by IntelliJ IDEA.
  User: cyberse
  Date: 5/27/2024
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    <title>Invoice Details</title>
</head>
<body>
<h1 class="text-center text-dark mt-1">QUẢN LÝ HÓA ĐƠN</h1>
<a class="btn btn-success" href="<c:url value='/invoice-residents/${residentId}/create'/>">Tạo mới</a>
<table class="table" >
    <thead>
    <tr>
        <th>Tên</th>
        <th>Số tiền</th>
        <th>Hạn đóng</th>
        <th>Trạng thái</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${invoices}" var="i">
        <tr>
            <td>${i.name}</td>
            <td>${i.amount}</td>
            <td><fmt:formatDate value="${i.dueDate}" pattern="dd-MM-yyyy" /></td>
            <td>${i.status}</td>
            <td>
                <a class="btn btn-primary"
                   href="<c:url value="/invoice-residents/${i.residentId.id}/${i.id}"/>">
                    Chi tiết
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
