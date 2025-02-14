package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.OrderDetail;
import model.OrderDetailDao;

import java.io.IOException;
import java.util.List;

@WebServlet("/OrderDetail")
public class OrderDetailServlet extends HttpServlet {
    private OrderDetailDao orderDetailDao;

    @Override
    public void init() throws ServletException {
        orderDetailDao = new OrderDetailDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("view".equals(action)) {
            try {
                String orderIdParam = request.getParameter("orderId");
                if (orderIdParam == null || orderIdParam.isEmpty()) {
                    throw new IllegalArgumentException("Thiếu orderId");
                }

                int orderId = Integer.parseInt(orderIdParam);
                List<OrderDetail> orderDetails = orderDetailDao.getOrderDetailsByOrderId(orderId);

                if (orderDetails.isEmpty()) {
                    request.setAttribute("message", "Không có chi tiết đơn hàng nào!");
                }

                request.setAttribute("orderDetails", orderDetails);
                request.getRequestDispatcher("orderDetail.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                request.setAttribute("error", "Mã đơn hàng không hợp lệ!");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } catch (Exception e) {
                request.setAttribute("error", "Lỗi khi lấy dữ liệu đơn hàng: " + e.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }
    }
}
