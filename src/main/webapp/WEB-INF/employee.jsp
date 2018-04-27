<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>employee</title>
    <style type="text/css">　　
    　　
    table,table tr th, table tr td { border:1px solid black;}
    table {width: 80%;border-collapse:collapse;}
    table tr {height: 40px;border:none;
        padding:0;
        margin:0;}
    table tr th {background-color: black;color: white;margin:0;
        padding:7px;}
    table tr td {color: black;margin:0;
        padding:7px;text-align: center}

    </style>　　
</head>
<body>
    <table style="width: 80%">
        <tr style="background-color: black;height: 40px">
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
        </tr>
        <c:forEach items="${employees}" var="employee">
            <tr style="height: 40px">
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.age}</td>
                <td>${employee.gender}</td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>