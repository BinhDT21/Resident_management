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
    <h1>Quản lý tủ đồ</h1>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên cư dân</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${electronicLockers}" var="el">
                <tr>
                    <td>${el.id}</td>
                    <td>${el.residentId.userId.lastName} ${el.residentId.userId.firstName}</td>>
                    <td>
                        <a class="btn btn-primary"
                           href="<c:url value="/electronic-lockers/${el.id}"/>">
                            Chi tiết
                        </a>

                        <a class="btn btn-warning"
                           href="<c:url value="/electronic-lockers/${el.id}/items"/>">
                            Danh sách vật phẩm
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
