package metube.web.servlets.user;

import metube.domain.entities.User;
import metube.domain.models.view.TubeProfileViewModel;
import metube.services.TubeService;
import metube.web.WebConstants;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(WebConstants.PROFILE_URL)
public class ProfileServlet extends HttpServlet {

    private final TubeService tubeService;

    @Inject
    public ProfileServlet(TubeService tubeService) {
        this.tubeService = tubeService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = String.valueOf(req.getSession().getAttribute("user_id"));
        List<TubeProfileViewModel> tubes = this.tubeService.findByAuthorId(id);
        req.setAttribute("tubes", tubes);

        req.getRequestDispatcher(WebConstants.PROFILE_VIEW_JSP).forward(req, resp);
    }
}
