package gege.filter;

import gege.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Mr.xu
 * @create 2022/04/03/13:53
 * Description:
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JdbcUtils.commitAndClose();//提交事务
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtils.rollbackAndClose();//回滚事务
        }
    }

    @Override
    public void destroy() {

    }
}
