<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生管理系统</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>学生管理系统</h1>

    <!-- 1. 添加学生表单 -->
    <div class="section">
        <h2>添加学生</h2>
        <form action="${pageContext.request.contextPath}/student/add" method="post">
            <div class="form-group">
                <label>姓名：</label>
                <input type="text" name="name" required>
            </div>
            <div class="form-group">
                <label>年龄：</label>
                <input type="number" name="age" required>
            </div>
            <div class="form-group">
                <label>性别：</label>
                <select name="gender">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
            <div class="form-group">
                <label>班级：</label>
                <input type="text" name="className" required>
            </div>
            <div class="form-group">
                <label>成绩：</label>
                <input type="number" step="0.01" name="score" required>
            </div>
            <button type="submit" class="btn">添加学生</button>
        </form>
    </div>

    <!-- 2. 修改学生表单 -->
    <div class="section">
        <h2>修改学生信息</h2>
        <form action="${pageContext.request.contextPath}/student/update" method="post">
            <div class="form-group">
                <label>学生ID：</label>
                <input type="number" name="id" required>
            </div>
            <div class="form-group">
                <label>姓名：</label>
                <input type="text" name="name" required>
            </div>
            <div class="form-group">
                <label>年龄：</label>
                <input type="number" name="age" required>
            </div>
            <div class="form-group">
                <label>性别：</label>
                <select name="gender">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
            <div class="form-group">
                <label>班级：</label>
                <input type="text" name="className" required>
            </div>
            <div class="form-group">
                <label>成绩：</label>
                <input type="number" step="0.01" name="score" required>
            </div>
            <button type="submit" class="btn">更新信息</button>
        </form>
    </div>

    <!-- 3. 删除学生 -->
    <div class="section">
        <h2>删除学生</h2>
        <form action="${pageContext.request.contextPath}/student/delete" method="get">
            <div class="form-group">
                <label>学生ID：</label>
                <input type="number" name="id" required>
            </div>
            <button type="submit" class="btn btn-danger" onclick="return confirm('确定要删除这个学生吗？')">
                删除学生
            </button>
        </form>
    </div>

    <!-- 4. 查看所有学生链接 -->
    <div class="section">
        <h2>查看学生列表</h2>
        <a href="${pageContext.request.contextPath}/student/list" class="btn">查看所有学生</a>
    </div>
</div>
</body>
</html>