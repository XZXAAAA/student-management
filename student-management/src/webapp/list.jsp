<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
<div class="container">
    <h1>学生列表</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>班级</th>
            <th>成绩</th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>${student.gender}</td>
                <td>${student.className}</td>
                <td>${student.score}</td>
            </tr>
        </c:forEach>
    </table>

    <div class="section">
        <a href="${pageContext.request.contextPath}/index.jsp" class="btn">返回主页</a>
    </div>
</div>
</body>
</html>