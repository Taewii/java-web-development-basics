package metube.web.servlets.user;

import metube.domain.entities.User;
import metube.services.UserService;
import metube.web.WebConstants;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(WebConstants.LOGIN_URL)
public class LoginServlet extends HttpServlet {

    private final UserService userService;

    @Inject
    public LoginServlet(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(WebConstants.LOGIN_VIEW_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = this.userService.find(username, password);

        if (user == null) {
            throw new IllegalArgumentException("Invalid credentials");
        } else {
            req.getSession().setAttribute("user", user);
        }

        resp.sendRedirect(WebConstants.HOME_URL);
    }
}
