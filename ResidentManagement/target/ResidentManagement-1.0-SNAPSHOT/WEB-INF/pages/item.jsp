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

<h2>Hàng trong tủ của cư dân: ${residentName}</h2>


<div class="d-flex justify-content mb-2">
    <form class="d-flex mx-2">
        <input type="hidden" name="status" value=""/>
        <button class="btn btn-primary mt-2 mb-2" type="submit" >All</button>
    </form>
    <form class="d-flex mx-2">
        <input type="hidden" name="status" value="1"/>
        <button class="btn btn-success mt-2 mb-2" type="submit" >Đã nhận</button>
    </form>
    <form class="d-flex mx-2">
        <input type="hidden" name="status" value="0"/>
        <button class="btn btn-warning mt-2 mb-2" type="submit" >Chưa nhận</button>
    </form>
</div>
<table class="table">

    <tr>
        <th>ID</th>
        <th>Trạng thái</th>
        <th>Mô tả</th>
        <th></th>
    </tr>


    <c:forEach items="${items}" var="item">
        <tr>
            <td>${item.id}</td>
            <c:choose>
                <c:when test="${item.status == 0}">
                    <td class="text-danger">Chưa nhận</td>
                </c:when>
                <c:otherwise>
                    <td class="text-success">Đã nhận</td>
                </c:otherwise>
            </c:choose>
            <td>${item.description}</td>
            <td>
                <a class="btn btn-primary"
                   href="<c:url value="/electronic-lockers/${elId}/items/${item.id}"/>">
                    Chi tiết
                </a>

                   <button class="btn btn-danger" onclick="deleteItem('<c:url value="/api/item/${item.id}/"/>')">Xóa hàng</button>
            </td>
        </tr>
    </c:forEach>

</table>

<a class="btn btn-primary" href="<c:url value='/electronic-lockers/${elId}/items/create'/>">Tạo mới</a>

<script src="<c:url value="/js/script.js" />"></script>