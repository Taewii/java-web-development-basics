package metube.web.servlets.user;

import metube.domain.entities.User;
import metube.web.WebConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(WebConstants.LOGIN_URL)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(WebConstants.LOGIN_VIEW_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = (User) req.getAttribute("model");

        if (user == null) {
            throw new IllegalArgumentException("Invalid credentials");
        } else {
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("user_id", user.getId());
        }

        resp.sendRedirect(WebConstants.HOME_URL);
    }
}
