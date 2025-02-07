<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/2/2025
  Time: 8:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Danh sách products</title>
</head>
<body>
<table border="1px">
  <tr>
    <td>id</td>
    <td>name</td>
    <td>description</td>
    <td>price</td>
    <td>address</td>
  </tr>

  <c:forEach items="${products}" var="p">
    <tr>
      <td>${p.id}</td>
      <td>${p.name}</td>
      <td>${p.description}</td>
      <td>${p.price}</td>
      <td>${p.address}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
