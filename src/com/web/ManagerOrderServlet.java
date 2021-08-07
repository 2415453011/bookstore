package com.web;

import com.pojo.Constants;
import com.pojo.Order;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Xjm
 * @date 2020/12/12   19:20
 */
public class ManagerOrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    /**
     * 发货
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deliverOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取订单号
        String orderId = req.getParameter("orderId");

//        修改订单状态
        orderService.sendOrder(orderId, Constants.DELIVER+"");
//        重定向回页面
        String referer = req.getHeader("referer");
        resp.sendRedirect(referer);
    }

        /**
         * 列出所有订单（管理员）
         * @param req
         * @param resp
         * @throws ServletException
         * @throws IOException
         */
    protected void orderList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取所有订单
        List<Order> allOrder = orderService.getAllOrder();

//        保存到域中
        req.setAttribute("orders",allOrder);

//        转发到/pages/manager/order_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req,resp);
    }
}
