package metube.web.servlets;

import metube.domain.enums.TubeStatus;
import metube.domain.models.view.TubeHomeViewModel;
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

@WebServlet(WebConstants.HOME_URL)
public class HomeServlet extends HttpServlet {

    private final TubeService tubeService;

    @Inject
    public HomeServlet(TubeService tubeService) {
        this.tubeService = tubeService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TubeHomeViewModel> tubes = this.tubeService.findByTubeStatus(TubeStatus.APPROVED, TubeHomeViewModel.class);
        req.setAttribute("tubes", tubes);
        req.getRequestDispatcher(WebConstants.HOME_VIEW_JSP).forward(req, resp);
    }
}
