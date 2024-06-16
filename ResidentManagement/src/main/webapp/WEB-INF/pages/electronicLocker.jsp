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
        <h1 class="text-center text-dark mt-1">QUẢN LÝ TỦ ĐỒ</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Họ và Tên</th>
                    <th>Ngày sinh</th>
                    <th>Địa chỉ</th>
                    <th>Sdt</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${electronicLockers}" var="el">
                    <tr>
                        <td>${el[0]}</td>
                        <td>${el[2]} ${el[1]}</td>
                        <td>${el[3]}</td>
                        <td>${el[4]}</td>
                        <td>${el[5]}</td>
                        <td>
                            <a class="btn btn-primary"
                               href="<c:url value="/electronic-lockers/${el[0]}/items"/>">
                                Chi tiết tủ đồ
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
