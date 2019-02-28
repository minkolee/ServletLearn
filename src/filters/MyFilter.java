package filters;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤执行中");
        // 向Request域传入内容
        servletRequest.setAttribute("name", "fallout3");
        filterChain.doFilter(servletRequest, servletResponse);
        // 设置响应统一的编码
        servletResponse.setContentType("text/html;charset=UTF-8");


    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("---------------------过滤器创建了-------------------------");
    }

    @Override
    public void destroy() {
        System.out.println("-----------------------过滤器销毁了-------------------------");
    }
}
