package metube.web.servlets;

import metube.domain.models.view.TubeAllViewModel;
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

@WebServlet(WebConstants.URL_TUBE_ALL)
public class TubeAllServlet extends HttpServlet {

    private final TubeService tubeService;

    @Inject
    public TubeAllServlet(TubeService tubeService) {
        this.tubeService = tubeService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TubeAllViewModel> tubes = this.tubeService.findAll();
        req.setAttribute(WebConstants.ATTRIBUTE_ALL_TUBES, tubes);
        req.getRequestDispatcher(WebConstants.JSP_TUBE_ALL).forward(req, resp);
    }
}
