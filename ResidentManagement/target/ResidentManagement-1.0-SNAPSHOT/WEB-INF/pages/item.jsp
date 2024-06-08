<%--
  Created by IntelliJ IDEA.
  User: cyberse
  Date: 5/27/2024
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Electronic Locker</title>
</head>
<body>
<h1>Các items của tủ đồ của cư dân: ${residentName}</h1>
<a class="btn btn-success" href="<c:url value='/electronic-lockers/${elId}/items/create'/>">Tạo mới</a>
<table class="table table-hover">
    <thead>
    <tr>
        <th>ID</th>
        <th>Trạng thái</th>
        <th>Mô tả</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${items}" var="item">
        <tr>
            <td>${item.id}</td>
            <c:choose>
                <c:when test="${item.status == 0}">
                    <td>Chưa nhận</td>
                </c:when>
                <c:otherwise>
                    <td>Đã nhận</td>
                </c:otherwise>
            </c:choose>
            <td>${item.description}</td>
            <td>
               <a class="btn btn-primary"
                  href="<c:url value="/electronic-lockers/${elId}/items/${item.id}"/>">
                   Chi tiết
               </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
