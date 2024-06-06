<%-- 
    Document   : index.
    Created on : May 24, 2024, 11:32:11 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<h1 class="text-center text-dark mt-1">QUẢN LÝ CƯ DÂN</h1>






<div class="d-flex justify-content mb-2">
    <form class="d-flex mx-2" action="<c:url value="/"/>">
        <input type="hidden" name="block" value="0"/>
        <button class="btn btn-dark mt-2 mb-2" type="submit" >Cư dân đã khóa</button>
    </form>

    <c:url value="/resident" var="resident"/>
    <a class="btn btn-primary mt-2 mb-2 mx-2" href="${resident}">Thêm cư dân</a>
</div>

<table class="table">
    <tr>
        <th>#</th>
        <th>Họ và Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Sdt</th>
        <th></th>
    </tr>
    <c:forEach items="${residents}" var="r">
        <tr>
            <td>${r[0]}</td>
            <td>${r[1]} ${r[2]}</td>
            <td>${r[3]}</td>
            <td>${r[4]}</td>
            <td>${r[5]}</td>

            <c:if test="${r[6]==1}">
                <c:url value="/api/resident/${r[7]}" var="deleteUrl"/>
                <td><button onclick="deleteResident('${deleteUrl}')" class="btn btn-danger" >Xóa</button></td>
            </c:if>


        </tr>

    </c:forEach>

</table>

<script src="<c:url value="/js/script.js" />"></script>