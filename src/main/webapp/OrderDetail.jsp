<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, model.OrderDetail" %>
<html>
<head>
    <title>Chi tiết đơn hàng</title>
</head>
<body>
<h2>Chi tiết đơn hàng</h2>

<%
    List<OrderDetail> orderDetails = (List<OrderDetail>) request.getAttribute("OrderDetail");
    if (orderDetails != null && !orderDetails.isEmpty()) {
%>
<table border="1">
    <tr>
        <th>Mã sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Số lượng</th>
    </tr>
    <% for (OrderDetail detail : orderDetails) { %>
    <tr>
        <td><%= detail.getProductId() %></td>
        <td><%= detail.getProductName() %></td>
        <td><%= detail.getPrice() %></td>
        <td><%= detail.getQuantity() %></td>
    </tr>
    <% } %>
</table>
<% } else { %>
<p>Không có dữ liệu đơn hàng!</p>
<% } %>

</body>
</html>
