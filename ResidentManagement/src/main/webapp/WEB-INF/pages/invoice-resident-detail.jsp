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
            <td>${i.dueDate}</td>
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
</body>
</html>
