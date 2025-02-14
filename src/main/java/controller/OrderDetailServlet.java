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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<OrderDetail> orderDetails = orderDetailDao.getAllOrderDetails();

        System.out.println("Số lượng đơn hàng: " + orderDetails.size());

        request.setAttribute("orderDetails", orderDetails);

        request.getRequestDispatcher("OrderDetail.jsp").forward(request, response);
    }
}
