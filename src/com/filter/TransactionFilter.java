package com.filter;

import com.utils.JDBCUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Xjm
 * @date 2020/12/24   20:42
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JDBCUtils.commitAndClose();//提交事务
        } catch (Exception e) {
            JDBCUtils.rollbackAndClose();//回滚事务
            e.printStackTrace();
            throw new RuntimeException(e);//把异常抛给Tomcat管理展示友好的错误页面

        }
    }

    @Override
    public void destroy() {

    }
}
