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



    public List<OrderDetail> getOrderDetailsByOrderId(int orderId) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        String sql = "SELECT od.id, o.customer_id, o.order_date, o.total_price,\n" +
                "       od.product_id, p.product_name AS product_name, od.price AS unit_price, od.quantity\n" +
                "FROM orderdetail od\n" +
                "JOIN orders o ON od.order_id = o.id  \n" +
                "JOIN products p ON od.product_id = p.product_id\n" +
                "WHERE od.order_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                OrderDetail detail = new OrderDetail(
                        rs.getInt("id"),
                        orderId,
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
