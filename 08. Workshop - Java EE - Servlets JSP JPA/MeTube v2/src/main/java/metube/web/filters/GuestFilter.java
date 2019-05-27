package metube.web.filters;

import metube.web.WebConstants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/home/*", "/profile/*", "/upload/*", "/details/*", "/logout/*"})
public class GuestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        if (FilterUtil.isGuest(session)) {
            res.sendRedirect(WebConstants.INDEX_URL);
            return;
        }

        req.setAttribute("user", session.getAttribute("user"));
        chain.doFilter(req, res);
    }
}
