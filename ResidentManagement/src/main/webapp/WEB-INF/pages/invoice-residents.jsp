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
            <td>${r.unpaidInvoiceCount}</td>
            <td>${r.waitingInvoiceCount}</td>
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
</body>
</html>
