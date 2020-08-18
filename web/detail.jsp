<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 2020/8/16
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Details</title>
</head>
<body>
<table width="80%" align="center">
    <tr>
        <td>Id</td>
        <td>OrderId</td>
        <td>DishName</td>
        <td>DishPrice</td>
        <td>Quantity</td>
        <td>Operation</td>
    </tr>
    <c:forEach items="${orderDetails}" var ="bean">
        <tr>
            <td>${bean.id}</td>
            <td>${bean.orderId}</td>
            <td>${bean.menu.name}</td>
            <td>${bean.menu.price}</td>
            <td>${bean.num}</td>
            <td> <a href="delete.action?orderId=${bean.orderId}&orderDetailId=${bean.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
