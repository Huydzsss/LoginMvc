package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDao {
    private static final String URL = "jdbc:mysql://localhost:3307/login_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "your_new_password";

    public OrderDetailDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public List<OrderDetail> getAllOrderDetails() {
        List<OrderDetail> orderDetails = new ArrayList<>();
        String sql = "SELECT od.id, od.order_id, o.customer_id, o.order_date, o.total_price, " +
                "od.product_id, p.product_name, od.price, od.quantity " +
                "FROM orderdetail od " +
                "JOIN orders o ON od.order_id = o.id " +
                "JOIN products p ON od.product_id = p.product_id";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                OrderDetail detail = new OrderDetail(
                        rs.getInt("id"),
                        rs.getInt("order_id"),  // ✅ Thêm order_id
                        rs.getInt("product_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getInt("customer_id"),
                        rs.getString("order_date"),
                        rs.getDouble("total_price"),
                        rs.getString("product_name")
                );
                orderDetails.add(detail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetails;
    }


}
