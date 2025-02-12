<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
<h2 class="text-center mb-4">Danh sách sản phẩm</h2>

<table class="table table-bordered table-striped">
    <thead class="table-dark">
    <tr>
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${empty products}">
            <tr>
                <td colspan="4" class="text-center text-danger">Không có sản phẩm nào!</td>
            </tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.productId}</td>
                    <td>${product.productName}</td>
                    <td>${product.unitPrice} VNĐ</td>
                    <td>
                        <a href="edit.jsp?id=${product.productId}" class="btn btn-warning btn-sm">Sửa</a>

                        <form action="products" method="post" style="display:inline;" onsubmit="return confirm('Bạn có chắc muốn xóa sản phẩm này?');">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="productId" value="${product.productId}">
                            <button type="submit" class="btn btn-danger btn-sm">Xóa</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>

<a href="add.jsp" class="btn btn-success mt-3">Thêm sản phẩm</a>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
