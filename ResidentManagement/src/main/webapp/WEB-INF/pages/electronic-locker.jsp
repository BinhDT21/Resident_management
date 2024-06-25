<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Electronic Locker</title>
</head>
<body>
<h1 class="text-center text-dark mt-1">QUẢN LÝ TỦ ĐỒ</h1>
<table class="table">
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
            <td>${el.residentId.userId.lastName} ${el.residentId.userId.firstName}</td>
            <td>
                <a class="btn btn-primary" href="<c:url value='/electronic-lockers/${el.id}/items'/>">
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
