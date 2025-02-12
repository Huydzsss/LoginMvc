<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
<h2 class="text-center mb-4">Thêm sản phẩm</h2>

<form action="products" method="post">
    <input type="hidden" name="action" value="add">
    <div class="mb-3">
        <label class="form-label">Tên sản phẩm</label>
        <input type="text" name="productName" class="form-control" required>
    </div>
    <div class="mb-3">
        <label class="form-label">Giá</label>
        <input type="number" name="unitPrice" class="form-control" required>
    </div>
    <button type="submit" class="btn btn-success">Thêm</button>
</form>

<a href="products" class="btn btn-secondary mt-3">Quay lại</a>
</body>
</html>
