package model;

public class OrderDetail {
    private int id;
    private int orderId;
    private int productId;
    private int quantity;
    private double price;

    // Thêm các thuộc tính từ bảng orders và product
    private int customerId;
    private String orderDate;
    private double totalPrice;
    private String productName;

    public OrderDetail(int id, int orderId, int productId, int quantity, double price,
                       int customerId, String orderDate, double totalPrice, String productName) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.productName = productName;
    }

    public int getId() { return id; }
    public int getOrderId() { return orderId; }
    public int getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    // Getter mới
    public int getCustomerId() { return customerId; }
    public String getOrderDate() { return orderDate; }
    public double getTotalPrice() { return totalPrice; }
    public String getProductName() { return productName; }
}
