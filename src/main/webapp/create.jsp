<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/2/2025
  Time: 9:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh Sach Products</title>
</head>
<style>
  body {
    font-family: Arial, sans-serif;
    margin: 20px;
  }
  h1 {
    text-align: center;
  }
  form {
    max-width: 600px;
    margin: 20px auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 10px;
    background-color: #f9f9f9;
  }
  form div {
    margin-bottom: 15px;
  }
  label {
    display: block;
    font-weight: bold;
  }
  input[type="text"], input[type="number"] {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 5px;
    margin-top: 5px;
  }
  .buttons {
    text-align: center;
  }
  button {
    margin: 5px;
    padding: 10px 15px;
    border: none;
    background-color: #007BFF;
    color: white;
    border-radius: 5px;
    cursor: pointer;
  }
  button:hover {
    background-color: #0056b3;
  }
  .danger {
    background-color: #dc3545;
  }
  .danger:hover {
    background-color: #a71d2a;
  }
</style>
<body>
<h1>Quản Lý Sản Phẩm</h1>
<form id="productForm" method="POST" action="">
  <div>
    <label for="id">ID Sản Phẩm</label>
    <input type="number" id="id" name="id" placeholder="Nhập ID sản phẩm">
  </div>
  <div>
    <label for="name">Tên Sản Phẩm</label>
    <input type="text" id="name" name="name" placeholder="Nhập tên sản phẩm">
  </div>
  <div>
    <label for="description">Mô Tả</label>
    <input type="text" id="description" name="description" placeholder="Nhập mô tả sản phẩm">
  </div>
  <div>
    <label for="price">Giá</label>
    <input type="number" id="price" name="price" step="0.01" placeholder="Nhập giá sản phẩm">
  </div>
  <div class="buttons">
    <button type="submit" name="action" value="add">Thêm</button>
    <button type="submit" name="action" value="edit">Sửa</button>
    <button type="submit" name="action" value="delete" class="danger">Xóa</button>
  </div>
</form>
</body>
</html>
