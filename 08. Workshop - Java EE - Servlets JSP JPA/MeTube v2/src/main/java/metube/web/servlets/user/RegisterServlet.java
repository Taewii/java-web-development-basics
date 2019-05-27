package metube.web.servlets.user;

import metube.domain.models.binding.RegisterBindingModel;
import metube.services.UserService;
import metube.web.WebConstants;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(WebConstants.REGISTER_URL)
public class RegisterServlet extends HttpServlet {

    private final UserService userService;

    @Inject
    public RegisterServlet(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(WebConstants.REGISTER_VIEW_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.userService.save((RegisterBindingModel) req.getAttribute("model"));
        resp.sendRedirect(WebConstants.LOGIN_URL);
    }
}
