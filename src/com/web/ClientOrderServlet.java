package com.web;

import com.pojo.*;
import com.service.OrderItemService;
import com.service.OrderService;
import com.service.impl.OrderItemServiceImpl;
import com.service.impl.OrderServiceImpl;
import com.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Xjm
 * @date 2020/12/3   21:50
 */
public class ClientOrderServlet extends  BaseServlet{
    private OrderService orderService = new OrderServiceImpl();
    private OrderItemService orderItemService = new OrderItemServiceImpl();

    protected void receiveOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//        获取订单号
        String orderId = req.getParameter("orderId");
//        修改订单状态
        orderService.sendOrder(orderId, Constants.DELIVERED+"");
//        重定向回页面
        String referer = req.getHeader("referer");
        resp.sendRedirect(referer);
    }
        /**
         * 订单详情
         * @param req
         * @param resp
         * @throws ServletException
         * @throws IOException
         */
    protected void orderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String orderId = req.getParameter("orderId");
        List<OrderItem> orderItem = orderItemService.getOrderItem(orderId);
        req.setAttribute("orderItem",orderItem);
        req.getRequestDispatcher("/pages/order/order_detail.jsp").forward(req,resp);
    }
    /**
     * 列出当前用户的所有订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void listOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        User user = WebUtils.getUser(req);
        List<Order> myOrder = null;
        try {
            myOrder = orderService.getMyOrder(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
//        域中保存该用户所有订单
        req.setAttribute("myOrder",myOrder);
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req,resp);
    }
    /**
     * 生成订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
//        获取userId
        User loginUser = (User) req.getSession().getAttribute("user");
//        WebUtils.getUser(req);
//        如果还没登陆则，跳转登录界面
        if (loginUser == null){
            req.setAttribute("msg","此操作需要登陆，请先登陆");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer userId = loginUser.getId();
//        调用orderService.createOrder（Cart,UserId）:生成订单
        String orderId = orderService.createOrder(cart, userId);

//        req.setAttribute("orderId",orderId);
//        请求转发到checkout.jsp
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
        req.getSession().setAttribute("orderId",orderId);

        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");

    }
}
