package panda.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/packages/*", "/receipts/*", "/admin/*"})
public class GuestAuthorizationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String role = (String) req.getSession().getAttribute("role");

        if (role == null) {
            res.sendRedirect("/");
            return;
        }

        chain.doFilter(request, res);
    }
}
