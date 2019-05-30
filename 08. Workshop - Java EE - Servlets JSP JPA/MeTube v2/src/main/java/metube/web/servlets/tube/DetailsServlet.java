package metube.web.servlets.tube;

import metube.domain.models.view.TubeDetailsViewModel;
import metube.services.TubeService;
import metube.web.WebConstants;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/details/*")
public class DetailsServlet extends HttpServlet {

    private final TubeService tubeService;

    @Inject
    public DetailsServlet(TubeService tubeService) {
        this.tubeService = tubeService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getPathInfo().substring(1);
        this.tubeService.incrementViews(id);
        TubeDetailsViewModel tube = this.tubeService.findByIdViewModel(id, TubeDetailsViewModel.class);
        req.setAttribute("tube", tube);

        req.getRequestDispatcher(WebConstants.DETAILS_VIEW_JSP).forward(req, resp);
    }
}
