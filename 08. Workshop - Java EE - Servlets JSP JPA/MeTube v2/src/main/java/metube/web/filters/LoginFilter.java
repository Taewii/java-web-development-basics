package metube.web.filters;

import metube.domain.entities.User;
import metube.services.UserService;
import metube.web.WebConstants;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(WebConstants.LOGIN_URL)
public class LoginFilter implements Filter {

    private final UserService userService;

    @Inject
    public LoginFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        if (req.getMethod().equalsIgnoreCase(WebConstants.HTTP_METHOD_POST)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = this.userService.find(username, password);

            if (user == null) {
                throw new IllegalArgumentException("Invalid username or password.");
            }

            boolean isUserAdmin = this.userService.isUserAdmin(username);
            request.setAttribute("model", user);
            request.setAttribute("isAdmin", isUserAdmin);
        }

        chain.doFilter(req, response);
    }
}
