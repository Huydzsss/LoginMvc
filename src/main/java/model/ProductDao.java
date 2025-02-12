package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private static final String URL = "jdbc:mysql://localhost:3307/login_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "your_new_password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // Lấy danh sách sản phẩm
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt("product_id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setUnitPrice(resultSet.getDouble("unit_price"));
                products.add(product);
            }
            System.out.println("Số lượng sản phẩm lấy được: " + products.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    // Thêm sản phẩm
    public void addProduct(Product product) {
        String sql = "INSERT INTO products (product_name, unit_price) VALUES (?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, product.getProductName());
            stmt.setDouble(2, product.getUnitPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật sản phẩm
    public void updateProduct(Product product) {
        String sql = "UPDATE products SET product_name = ?, unit_price = ? WHERE product_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, product.getProductName());
            stmt.setDouble(2, product.getUnitPrice());
            stmt.setInt(3, product.getProductId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa sản phẩm
    public void deleteProduct(int productId) {
        String sql = "DELETE FROM products WHERE product_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, productId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy sản phẩm theo ID
    public Product getProductById(int productId) {
        String sql = "SELECT * FROM products WHERE product_id = ?";
        Product product = null;

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, productId);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                product = new Product();
                product.setProductId(resultSet.getInt("product_id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setUnitPrice(resultSet.getDouble("unit_price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
