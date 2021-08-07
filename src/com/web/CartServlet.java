package com.web;

import com.google.gson.Gson;
import com.pojo.Book;
import com.pojo.Cart;
import com.pojo.CartItem;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import com.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @Package com.web
 * @date 2020/11/4 19:00
 */
public class CartServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    /**
     * 修改商品数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取请求的参数 商品编号 商品数量
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        int count = WebUtils.parseInt(req.getParameter("count"),1);
//        获取Cart购物车对象
        Cart cart = (Cart)req.getSession().getAttribute("cart");

        if (cart != null){
//            修改商品数量
            cart.updateItem(id,count);
//            重定向
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null){
//            清空购物车
            cart.clear();
//            重定向
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 删除购物车商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        System.out.println(req.getParameter("id"));

//        获取购物车对象
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if (cart != null){
//            删除了购物车商品
            cart.deleteItem(id);
//            重定向回原来购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
    /**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("加入购物车");
//        System.out.println("商品编号：" + req.getParameter("id"));
        // 获取请求参数，商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),00);
        //调用bookService.queryBookById(id):Book将得到图书信息
        Book book = bookService.queryBookById(id);
//        把图书信息转换成为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
//        调用Cart.addItem(CartItem);添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }

        cart.addItem(cartItem);
        System.out.println(cart);
//        重定向回原来商品所在地址
        resp.sendRedirect(req.getHeader("referer"));
//        resp.sendRedirect(req.getContextPath());
//        最后一个添加商品名称
        req.getSession().setAttribute("lastName",cartItem.getName());
    }

    /**
     * 利用加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("加入购物车");
//        System.out.println("商品编号：" + req.getParameter("id"));
        // 获取请求参数，商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),00);
        //调用bookService.queryBookById(id):Book将得到图书信息
        Book book = bookService.queryBookById(id);
//        把图书信息转换成为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
//        调用Cart.addItem(CartItem);添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
//        最后一个添加商品名称
        req.getSession().setAttribute("lastName",cartItem.getName());

        Map<String,Object> resultMap = new HashMap<>();

        resultMap.put("totalCount", cart.getTotalCount());
        resultMap.put("lastName",cartItem.getName());

        Gson gson = new Gson();

        String s = gson.toJson(resultMap);

        resp.getWriter().write(s);

    }


}
