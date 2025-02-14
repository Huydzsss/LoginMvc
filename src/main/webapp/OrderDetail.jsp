<%@ page import="java.util.List, model.OrderDetail" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>Chi tiết đơn hàng</title>
</head>
<body>
<h2>Chi tiết đơn hàng</h2>
<%
    List<OrderDetail> orderDetails = (List<OrderDetail>) request.getAttribute("orderDetails");
    if (orderDetails != null && !orderDetails.isEmpty()) {
        OrderDetail firstDetail = orderDetails.get(0);
%>
<p>Mã khách hàng: <%= firstDetail.getCustomerId() %></p>
<p>Ngày đặt hàng: <%= firstDetail.getOrderDate() %></p>
<p>Tổng tiền: <%= firstDetail.getTotalPrice() %></p>

<h3>Sản phẩm trong đơn hàng</h3>
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
        <td><%= detail.getUnitPrice() %></td>
        <td><%= detail.getQuantity() %></td>
    </tr>
    <% } %>
</table>
<% } else { %>
<p>Không có dữ liệu đơn hàng!</p>
<% } %>
</body>
</html>
