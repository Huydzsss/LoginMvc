<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, model.OrderDetail" %>
<html>
<head>
    <title>Chi tiết đơn hàng</title>
    <!-- Thêm Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<h2 class="text-center">Chi tiết đơn hàng</h2>

<%
    List<OrderDetail> orderDetails = (List<OrderDetail>) request.getAttribute("orderDetails");
    if (orderDetails == null || orderDetails.isEmpty()) {
%>
<div class="alert alert-warning text-center">Không có dữ liệu đơn hàng!</div>
<% } else { %>
<table class="table table-bordered table-striped">
    <thead class="table-dark">
    <tr>
        <th>Mã sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Số lượng</th>
    </tr>
    </thead>
    <tbody>
    <% for (OrderDetail detail : orderDetails) { %>
    <tr>
        <td><%= detail.getProductId() %></td>
        <td><%= detail.getProductName() %></td>
        <td><%= detail.getPrice() %></td>
        <td><%= detail.getQuantity() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
<% } %>

<!-- Thêm Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
