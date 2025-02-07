<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/2/2025
  Time: 9:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Products</title>
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
    max-width: 400px;
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
  input[type="number"] {
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
    padding: 10px 15px;
    border: none;
    background-color: #dc3545;
    color: white;
    border-radius: 5px;
    cursor: pointer;
  }
  button:hover {
    background-color: #a71d2a;
  }
</style>
<body>
<h1>Xóa Sản Phẩm</h1>
<form id="deleteForm" method="POST" action="">
  <div>
    <label for="id">ID Sản Phẩm</label>
    <input type="number" id="id" name="id" placeholder="Nhập ID sản phẩm cần xóa" required>
  </div>
  <div class="buttons">
    <button type="submit">Xóa</button>
  </div>
</form>
</body>
</html>
