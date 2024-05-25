<%-- 
    Document   : header
    Created on : May 24, 2024, 5:11:07 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">

        <a class="navbar-brand" href="#">
            <img src="https://res.cloudinary.com/dwdvnztnn/image/upload/v1716542240/2_k3qyxl.png" 
                 style="width:70px;" class="rounded-pill"> 
        </a>

        <c:url value="/" var="index"/>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    
                    <a class="nav-link" href="${index}">Resident management</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Tiện ích</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="${index}">Quản lý cư dân</a></li>
                        <li><a class="dropdown-item" href="#">Quản lý tủ đồ</a></li>
                        <li><a class="dropdown-item" href="#">Quản lý phản hồi</a></li>
                        <li><a class="dropdown-item" href="#">Khảo sát</a></li>
                        <li><a class="dropdown-item" href="#">Hóa đơn</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex" action="<c:url value="/"/>">
                <input class="form-control me-2" type="text" placeholder="Tên cư dân" name="name">
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
