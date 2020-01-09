<!-- Page Content: Example from: https://startbootstrap.com/template-overviews/simple-sidebar/ -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Entag Recognization</title>

<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap-theme.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/simple-sidebar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/jquery.dataTables.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/fontawesome-all.css">

<script src="${pageContext.request.contextPath }/static/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/static/js/bootstrap.js"></script>
<script	src="${pageContext.request.contextPath }/static/js/jquery.dataTables.js"></script>

</head>
<body>

	<div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li>
                    <a href="#">
                    	<img alt="" src="${pageContext.request.contextPath }/static/img/monkey_testing.jpg"  class="img-responsive"/>
                    	<h1>¯\_(ツ)_/¯</h1>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath }/">Login</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath }/">HOME</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath }/entag">Entag</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath }/logout">Logout</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath }/about">About</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content: Example from: https://startbootstrap.com/template-overviews/simple-sidebar/ -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                	<div class="row"> 
                		<div class="col-lg-4">
	                		<a href="#menu-toggle" class="btn btn-default" id="menu-toggle"><span class="glyphicon glyphicon-menu-hamburger" aria-hidden="true"></span></a>
	                	</div>
	                	<div class="col-lg-8">
	                		<h4>Welcome: <%=session.getAttribute("activeUser")%>  &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;  <a href="${pageContext.request.contextPath }/logout"> Logout User </a> </h4>
	                	</div>
                	</div>
                    <div class="col-lg-12">
	