<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.ProductDao, model.Product" %>

<%
    String idParam = request.getParameter("id");
    int id = 0;
    Product product = null;

    if (idParam != null && !idParam.isEmpty()) {
        try {
            id = Integer.parseInt(idParam);
            ProductDao dao = new ProductDao();
            product = dao.getProductById(id);
        } catch (NumberFormatException e) {
            id = -1;
        }
    }
%>

<html>
<head>
    <title>Sửa sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
<h2 class="text-center mb-4">Sửa sản phẩm</h2>

<%
    if (product == null) {
%>
<p class="text-danger">Sản phẩm không tồn tại hoặc lỗi dữ liệu.</p>
<a href="products.jsp" class="btn btn-secondary">Quay lại danh sách</a>
<%
} else {
%>
<form action="products" method="post">
    <input type="hidden" name="action" value="edit">
    <input type="hidden" name="productId" value="<%= product.getProductId() %>">

    <div class="mb-3">
        <label class="form-label">Tên sản phẩm:</label>
        <input type="text" class="form-control" name="productName" value="<%= product.getProductName() %>" required>
    </div>

    <div class="mb-3">
        <label class="form-label">Giá sản phẩm:</label>
        <input type="number" step="0.01" class="form-control" name="unitPrice" value="<%= product.getUnitPrice() %>" required>
    </div>

    <button type="submit" class="btn btn-primary">Cập nhật</button>
    <a href="products.jsp" class="btn btn-secondary">Hủy</a>
</form>
<%
    }
%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
