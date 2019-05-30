package metube.web.servlets.tube;

import metube.domain.enums.TubeStatus;
import metube.domain.models.view.TubePendingViewModel;
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

@WebServlet(WebConstants.ADMIN_PENDING_URL)
public class PendingServlet extends HttpServlet {

    private final TubeService tubeService;

    @Inject
    public PendingServlet(TubeService tubeService) {
        this.tubeService = tubeService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TubePendingViewModel> tubes = this.tubeService.findByTubeStatus(TubeStatus.PENDING, TubePendingViewModel.class);
        req.setAttribute("tubes", tubes);

        req.getRequestDispatcher(WebConstants.PENDING_VIEW_JSP).forward(req, resp);
    }
}
